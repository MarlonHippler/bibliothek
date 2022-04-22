import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Input} from "@angular/core";
import {PubAnlegenService} from "../services/pub-anlegen.service";
import {PubAnlegenModel} from "../models/pub-anlegen-model";
import {Subject, takeUntil} from "rxjs";


@Component({
  selector: 'app-pub-anlegen',
  templateUrl: './pub-anlegen.component.html',
  styleUrls: ['./pub-anlegen.component.css']
})
export class PubAnlegenComponent implements OnDestroy {


  @Input() pubAnlegenForm: FormGroup;
  private destroy$: Subject<boolean> = new Subject<boolean>();

  constructor(private pubService: PubAnlegenService) {
    this.pubAnlegenForm = new FormGroup({
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
      this.pubAnlegenForm.valid
    ) {
      let pub = {

        titel: this.pubAnlegenForm.get('titel')?.value,
        autor: this.pubAnlegenForm.get('autor')?.value,
        veroeffentlichung: this.pubAnlegenForm.get('veroeffentlichung')?.value,
        verlag: this.pubAnlegenForm.get('verlag')?.value,
        publikationsart: this.pubAnlegenForm.get('publikationsart')?.value,

        ISBN: this.pubAnlegenForm.get('ISBN')?.value,
        schlagwoerter: this.pubAnlegenForm.get('schlagwoerter')?.value,
        bestandAnzahl: this.pubAnlegenForm.get('bestandAnzahl')?.value,

      } as PubAnlegenModel
      this.pubService.erstellePub(pub).pipe(takeUntil(this.destroy$)).subscribe()

    }


  }

  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }
}






