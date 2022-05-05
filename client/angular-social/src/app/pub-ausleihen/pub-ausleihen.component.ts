import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {PubService} from "../services/pub.service";
import {pipe, Subject, takeUntil} from "rxjs";
import {PubAusleihenModel} from "../models/pub-ausleihen-model";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-pub-ausleihen',
  templateUrl: './pub-ausleihen.component.html',
  styleUrls: ['./pub-ausleihen.component.css']
})


export class PubAusleihenComponent implements OnDestroy{


  @Input() pubAusleihenForm: FormGroup;
  private destroy$: Subject<boolean> = new Subject<boolean>();


  constructor(private pubAusleihenService: PubService, private snackBar: MatSnackBar) {
    this.pubAusleihenForm = new FormGroup({
      pubID: new FormControl('', Validators.required),
      vorname: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      matrikelnummer: new FormControl('', Validators.required),

    })
  }

  onsubmit(): void {

    if (
      this.pubAusleihenForm.valid
    ) {
      let pub = {


        pubID: this.pubAusleihenForm.get('pubID')?.value,
        vorname: this.pubAusleihenForm.get('vorname')?.value,
        name: this.pubAusleihenForm.get('name')?.value,
        matrikelnummer: this.pubAusleihenForm.get('matrikelnummer')?.value,


      } as PubAusleihenModel
      this.pubAusleihenService.ausleihenPub(pub).pipe(takeUntil(this.destroy$)).subscribe(publikation => {
        },
        error => {
          if (error.error) {
            this.openSnackBar(error.error.nachricht)
          }})

    }
  }

    ngOnDestroy() {
      this.destroy$.next(true);
      this.destroy$.unsubscribe();
    }
    openSnackBar(nachricht: string): void {
      this.snackBar.open(nachricht, 'X', {
        duration: 5000
      })
    }
}





