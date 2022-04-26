import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subject, takeUntil} from "rxjs";
import {PubService} from "../services/pub.service";
import {PubAnlegenModel} from "../models/pub-anlegen-model";
import {PubModel} from "../models/publikation-model";

@Component({
  selector: 'app-pub-editieren',
  templateUrl: './pub-editieren.component.html',
  styleUrls: ['./pub-editieren.component.css']
})
export class PubEditierenComponent implements OnDestroy {


  @Input() pubEditierenForm: FormGroup;
  private destroy$: Subject<boolean> = new Subject<boolean>();

  constructor(private pubService: PubService) {
    this.pubEditierenForm = new FormGroup({
      pubID: new FormControl('', Validators.required),
      titel: new FormControl('', Validators.required),
      autor: new FormControl('', Validators.required),
      veroeffentlichung: new FormControl('', Validators.required),
      verlag: new FormControl(''),
      publikationsart: new FormControl(''),
      ISBN: new FormControl(''),
      schlagwoerter: new FormControl(''), // in Zukunft FormArray,
      bestandAnzahl: new FormControl('')

    })
  }

  onsubmit(): void {

    if (
      this.pubEditierenForm.valid
    ) {
      let pub = {
        pubID: this.pubEditierenForm.get('pubID')?.value,
        titel: this.pubEditierenForm.get('titel')?.value,
        autor: this.pubEditierenForm.get('autor')?.value,
        veroeffentlichung: this.pubEditierenForm.get('veroeffentlichung')?.value,
        verlag: this.pubEditierenForm.get('verlag')?.value,
        publikationsart: this.pubEditierenForm.get('publikationsart')?.value,

        ISBN: this.pubEditierenForm.get('ISBN')?.value,
        schlagwoerter: this.pubEditierenForm.get('schlagwoerter')?.value,
        bestandAnzahl: this.pubEditierenForm.get('bestandAnzahl')?.value,

      } as PubModel
      this.pubService.erstellePub(pub).pipe(takeUntil(this.destroy$)).subscribe()

    }


  }

  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }
}
