import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Input} from "@angular/core";
import {PubService} from "../services/pub.service";
import {PubAnlegenModel} from "../models/pub-anlegen-model";
import {Subject, takeUntil} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {PubModel} from "../models/publikation-model";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatTableDataSource} from "@angular/material/table";


@Component({
  selector: 'app-pub-anlegen',
  templateUrl: './pub-anlegen.component.html',
  styleUrls: ['./pub-anlegen.component.css']
})
export class PubAnlegenComponent implements OnDestroy, OnInit {


  @Input() pubAnlegenForm: FormGroup;
  private destroy$: Subject<boolean> = new Subject<boolean>();
  pubID!: number;
  vorgangstyp = "anlegen";


  constructor(private pubService: PubService, private route: ActivatedRoute, private snackBar: MatSnackBar) {
    this.pubAnlegenForm = new FormGroup({
      titel: new FormControl('', Validators.required),
      autor: new FormControl('', Validators.required),
      veroeffentlichung: new FormControl('', Validators.required),
      verlag: new FormControl(''),
      publikationsart: new FormControl(''),
      ISBN: new FormControl(''),
      schlagwoerter: new FormArray( []),
      bestandAnzahl: new FormControl('')

    })
  }


  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toISOString().slice(0, 10);
  }

  onsubmit(): void {

    if (
      this.pubAnlegenForm.valid
    ) {
      if (this.pubID) {
        let pubUpdate = {
          pubID: this.pubID,
          titel: this.pubAnlegenForm.get('titel')?.value,
          autor: this.pubAnlegenForm.get('autor')?.value,
          veroeffentlichung: this.pubAnlegenForm.get('veroeffentlichung')?.value,
          verlag: this.pubAnlegenForm.get('verlag')?.value,
          publikationsart: this.pubAnlegenForm.get('publikationsart')?.value,

          ISBN: this.pubAnlegenForm.get('ISBN')?.value,
          schlagwoerter: this.pubAnlegenForm.get('schlagwoerter')?.value,
          bestandAnzahl: this.pubAnlegenForm.get('bestandAnzahl')?.value,
        } as PubModel
          this.pubService.bearbeitePub(pubUpdate).pipe(takeUntil(this.destroy$)).subscribe(
          )
        } else {
        let pub = {
          titel: this.pubAnlegenForm.get('titel')?.value,
          autor: this.pubAnlegenForm.get('autor')?.value,
          veroeffentlichung: this.pubAnlegenForm.get('veroeffentlichung')?.value,
          verlag: this.pubAnlegenForm.get('verlag')?.value,
          publikationsart: this.pubAnlegenForm.get('publikationsart')?.value,

          ISBN: this.pubAnlegenForm.get('ISBN')?.value,
          // schlagwoerter: this.pubAnlegenForm.get('schlagwoerter')?.value,
          bestandAnzahl: this.pubAnlegenForm.get('bestandAnzahl')?.value,

        } as PubAnlegenModel
        this.pubService.erstellePub(pub).pipe(takeUntil(this.destroy$)).subscribe(
          publikation => {
          },
          error => {
            if (error.error) {
              this.openSnackBar(error.error.nachricht)
            }
          })
      }}}







    ngOnDestroy()
    {
      this.destroy$.next(true)
      this.destroy$.unsubscribe()
    }

    ngOnInit()
    {
      this.pubID = parseInt(this.route.snapshot.paramMap.get('id') as string);

      if (this.pubID) {
        this.vorgangstyp = "bearbeiten"
        this.pubService.zeigeEinenPub(this.pubID)
          .pipe(takeUntil(this.destroy$))
          .subscribe(pub => {
            this.pubAnlegenForm.get('titel')?.setValue(pub.titel)
            this.pubAnlegenForm.get('publikationsart')?.setValue(pub.publikationsart)
            this.pubAnlegenForm.get('ISBN')?.setValue(pub.ISBN)
            this.pubAnlegenForm.get('autor')?.setValue(pub.autor)
            this.pubAnlegenForm.get('veroeffentlichung')?.setValue(this.toLocalDateString(pub.veroeffentlichung))
            this.pubAnlegenForm.get('titel')?.setValue(pub.titel)
            this.pubAnlegenForm.get('bestandAnzahl')?.setValue(pub.bestandAnzahl)
            this.pubAnlegenForm.get('verlag')?.setValue(pub.verlag)
            this.pubAnlegenForm.get('schlagwoerter')?.setValue(pub.schlagwoerter)
          })


      }


    }
schlagwoerterHinzufuegen(schlagwort: string){
    console.log(schlagwort)
    let schlagwortArray = this.pubAnlegenForm.get('schlagwoerter') as FormArray;
    schlagwortArray.push(new FormControl(schlagwort))

}

  openSnackBar(nachricht: string): void {
    this.snackBar.open(nachricht, 'X', {
      duration: 5000
    })
  }


}






