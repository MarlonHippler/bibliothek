import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {PubService} from "../services/pub.service";
import {PubModel} from "../models/publikation-model";

@Component({
  selector: 'app-pub-uebersicht',
  templateUrl: './pub-uebersicht.component.html',
  styleUrls: ['./pub-uebersicht.component.css']
})

// titel: string
//   autor: string
//   veroeffentlichung: Date
//   verlag: string
//   publikationsart: string
//   ISBN: string
//   schlagwoerter: string
//   bestandAnzahl: number
export class PubUebersichtComponent implements OnInit {
  displayedColumns: string[] = ['publikation_ID', 'titel', 'autor', 'veroeffentlichung', 'publikationsart',
    'verlag', 'isbn', 'schlagwoerter', 'bestandAnzahl'];

  public dataSource!: Observable<PubModel[]>;

  constructor(private pubService: PubService) {
  } // service reingeben lassen

  ngOnInit(): void {
    this.dataSource = this.pubService.zeigeAllePubs()
  }

  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toLocaleDateString()
  }
}
