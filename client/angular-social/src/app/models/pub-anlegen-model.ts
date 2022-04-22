import {FormControl, Validators} from "@angular/forms";

export interface PubAnlegenModel {


  titel: string
  autor: string
  veroeffentlichung: Date
  verlag: string
  publikationsart: string
  ISBN: string
  schlagwoerter: string
  bestandAnzahl: number
}
