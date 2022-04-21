import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpClientModule} from "@angular/common/http";
import {PubAusleihenModel} from "../models/pub-ausleihen-model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PubAusleihenService {
  private pubUrl = environment.backendUrl;

  constructor(private http: HttpClient) {
  }

  ausleihenPub(pubAusleihenModel: PubAusleihenModel): Observable<PubAusleihenModel> {
    return this.http.post<PubAusleihenModel>(this.pubUrl + "publikation/ausleihen", pubAusleihenModel)
  }
}
