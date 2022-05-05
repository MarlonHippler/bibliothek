import {AfterViewInit, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Observable, Subject, subscribeOn, takeUntil} from "rxjs";
import {PubService} from "../services/pub.service";
import {PubModel} from "../models/publikation-model";
import {MatSort, Sort} from '@angular/material/sort';
import {LiveAnnouncer} from "@angular/cdk/a11y";
import {MatTableDataSource} from "@angular/material/table";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-pub-uebersicht',
  templateUrl: './pub-uebersicht.component.html',
  styleUrls: ['./pub-uebersicht.component.css']
})

// autor marc

export class PubUebersichtComponent implements OnInit, OnDestroy {
  displayedColumns: any[] = ['publikationID', 'titel', 'autor', 'veroeffentlichung', 'publikationsart',
    'verlag', 'isbn', 'schlagwoerter', 'bestandAnzahl', 'bearbeiten', 'loeschen'];
  publikations!: MatTableDataSource<PubModel>
  private destroy$: Subject<boolean> = new Subject<boolean>();
  public dataSource!: Observable<PubModel[]>;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;


  constructor(private pubService: PubService,  private snackBar: MatSnackBar
  ) {
  } // service reingeben lassen

  ngOnInit(): void { //pubs abrufen
    this.dataSource = this.pubService.zeigeAllePubs()
    this.pubService.zeigeAllePubs().pipe(takeUntil(this.destroy$)).subscribe(
      publikation =>
      {this.publikations = new MatTableDataSource(publikation);
      this.publikations.sort = this.sort},
      error => {if(error.error){this.openSnackBar(error.error.nachricht)}
  })}

  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toISOString().slice(0, 10); //format fürs datum
  }

  pubLoeschen(pubID: number) {

    this.pubService.loeschePub(pubID).pipe(takeUntil(this.destroy$)).subscribe(
      () =>{},
    error => {if(error.error){this.openSnackBar(error.error.nachricht)}})

  }

  ngOnDestroy() {
    this.destroy$.next(true)
    this.destroy$.unsubscribe()
  }
  suchen(suchwert: string) {this.publikations.filter = suchwert.trim() //suchfunktion für die suche in der übersicht
  }


  openSnackBar(nachricht: string): void {
    this.snackBar.open(nachricht, 'X', {
      duration: 5000
    })
  }

}
