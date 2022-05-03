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

// titel: string
//   autor: string
//   veroeffentlichung: Date
//   verlag: string
//   publikationsart: string
//   ISBN: string
//   schlagwoerter: string
//   bestandAnzahl: number
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

  ngOnInit(): void {
    this.dataSource = this.pubService.zeigeAllePubs()
    this.pubService.zeigeAllePubs().pipe(takeUntil(this.destroy$)).subscribe(
      publikation =>
      {this.publikations = new MatTableDataSource(publikation);
      this.publikations.sort = this.sort},
      error => {if(error.error){this.openSnackBar(error.error.nachricht)}
  })}

  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toISOString().slice(0, 10);
  }

  pubLoeschen(pubID: number) {

    this.pubService.loeschePub(pubID).pipe(takeUntil(this.destroy$)).subscribe(
      () =>{},
    error => {if(error.error){this.openSnackBar(error.error.message)}})

  }

  ngOnDestroy() {
    this.destroy$.next(true)
    this.destroy$.unsubscribe()
  }
  suchen(suchwert: string) {this.publikations.filter = suchwert.trim()
  }
  // /**
  //  * Opens a snackbar with the given string as message
  //  * @param message given string
  //  */
  openSnackBar(message: string): void {
    this.snackBar.open(message, 'X', {
      duration: 5000
    })
  }

}
