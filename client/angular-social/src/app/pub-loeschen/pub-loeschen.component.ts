import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subject, takeUntil} from "rxjs";
import {PubService} from "../services/pub.service";
import {PubAnlegenModel} from "../models/pub-anlegen-model";

@Component({
  selector: 'app-pub-loeschen',
  templateUrl: './pub-loeschen.component.html',
  styleUrls: ['./pub-loeschen.component.css']
})
export class PubLoeschenComponent implements OnDestroy {
  @Input() pubLoeschenForm: FormGroup;
  private destroy$: Subject<boolean> = new Subject<boolean>();

  constructor(private pubService: PubService) {
    this.pubLoeschenForm = new FormGroup({pubID: new FormControl('', Validators.required)})
  }

  onsubmit(): void {

    if (
      this.pubLoeschenForm.valid
    ) {let pub = {
      pubID: this.pubLoeschenForm.get('pubID')?.value,
      titel:   '',
      autor:  '',
      veroeffentlichung:  '',
      verlag:  '',
      publikationsart:  '',

      ISBN: '',
      schlagwoerter:'',
      bestandAnzahl:  '',

      this.pubService.loeschePub(pub).pipe(takeUntil(this.destroy$)).subscribe()

    }

  ngOnDestroy(){
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }
}
