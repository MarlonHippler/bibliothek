import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {PubService} from "../services/pub.service";
import {pipe, Subject, takeUntil} from "rxjs";
import {PubAusleihenModel} from "../models/pub-ausleihen-model";

@Component({
  selector: 'app-pub-ausleihen',
  templateUrl: './pub-ausleihen.component.html',
  styleUrls: ['./pub-ausleihen.component.css']
})


export class PubAusleihenComponent implements OnDestroy{


  @Input() pubAusleihenForm: FormGroup;
  private destroy$: Subject<boolean> = new Subject<boolean>();


  constructor(private pubAusleihenService: PubService) {
    this.pubAusleihenForm = new FormGroup({
      pubID: new FormControl('', Validators.required),
      vorname: new FormControl('', Validators.required),
      nachname: new FormControl('', Validators.required),
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
        nachname: this.pubAusleihenForm.get('nachname')?.value,
        matrikelnummer: this.pubAusleihenForm.get('matrikelnummer')?.value,


      } as PubAusleihenModel
      this.pubAusleihenService.ausleihenPub(pub).pipe(takeUntil(this.destroy$)).subscribe()

    }
  }

    ngOnDestroy() {
      this.destroy$.next(true);
      this.destroy$.unsubscribe();
    }

}


// dcfkk
//<!--   public int buch_ID;
//public String titel;
//@ElementCollection
// public List<String> autor;
// public Date veroeffentlichung;
// public String verlag;
// public Publikationsart publikationsart;
// public String ISBN;
// @ElementCollection
// public List<String> schlagwoerter;
// public int bestandAnzahl; -
// }) }

// ngOnInit(): void {


