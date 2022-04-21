import {FormControl, Validators} from "@angular/forms";

export interface PubAnlegenModel {


  titel: string
  autor: string
  datum: Date
  verlag: string
  publikationsart: string
  isbn: string
  schlagwoerter: string
  bestand: number
}
