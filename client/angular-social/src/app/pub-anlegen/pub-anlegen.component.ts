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
      datum: new FormControl('', Validators.required),
      verlag: new FormControl(''),
      publikationsart: new FormControl(''),
      isbn: new FormControl(''),
      schlagwoerter: new FormControl(''), // in Zukunft FormArray,
      bestand: new FormControl('')

    })
  }

  onsubmit(): void {

    if (
      this.pubAnlegenForm.valid
    ) {
      let pub = {

        titel: this.pubAnlegenForm.get('titel')?.value,
        autor: this.pubAnlegenForm.get('autor')?.value,
        datum: this.pubAnlegenForm.get('datum')?.value,
        verlag: this.pubAnlegenForm.get('verlag')?.value,
        publikationsart: this.pubAnlegenForm.get('publikationsart')?.value,

        isbn: this.pubAnlegenForm.get('isbn')?.value,
        schlagwoerter: this.pubAnlegenForm.get('schlagwoerter')?.value,
        bestand: this.pubAnlegenForm.get('bestand')?.value,

      } as PubAnlegenModel
      this.pubService.erstellePub(pub).pipe(takeUntil(this.destroy$)).subscribe()

    }


  }

  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }
}






