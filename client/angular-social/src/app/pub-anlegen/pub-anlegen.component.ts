import {Component, OnInit} from '@angular/core';

import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Input} from "@angular/core";
import {PubService} from "../services/pub.service";



@Component({
  selector: 'app-pub-anlegen',
  templateUrl: './pub-anlegen.component.html',
  styleUrls: ['./pub-anlegen.component.css']
})
export class PubAnlegenComponent  {


  @Input() pubAnlegenForm: FormGroup;


  constructor(private pubService:PubService) {
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
  onsubmit(): void { this.pubService.createPub().subscribe()
    let pub {
    titel:
    }


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



