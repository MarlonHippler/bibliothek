import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {PubModel} from "../models/publikation-model";
import {HttpClient} from "@angular/common/http";
import {LeihvorgangModel} from "../models/leihvorgang-model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LeihvorgangService {
  private leihUrl = environment.backendUrl;


  constructor(private http: HttpClient ) {
    }
  verlaengereLeihvorgang( leihvorgangModel: LeihvorgangModel): Observable<LeihvorgangModel> {
    return this.http.put<LeihvorgangModel>(this.leihUrl + "ausleihen/verlaengern/" + leihvorgangModel.vorgangID, leihvorgangModel)
  }
}
