import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpClientModule} from "@angular/common/http";
import {PubAnlegenModel} from "../models/pub-anlegen-model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {PubAusleihenModel} from "../models/pub-ausleihen-model";
import {PubModel} from "../models/publikation-model";
import {LeihvorgangModel} from "../models/leihvorgang-model";

@Injectable({
  providedIn: 'root'
})
export class PubService {
  private pubUrl = environment.backendUrl;

  constructor(private http: HttpClient) {
  }

  erstellePub(pubAnlegenModel: PubAnlegenModel): Observable<PubAnlegenModel> {
    return this.http.post<PubAnlegenModel>(this.pubUrl + "publikation/anlegen", pubAnlegenModel)


  }

  ausleihenPub(pubAusleihenModel: PubAusleihenModel): Observable<PubAusleihenModel> {
    return this.http.post<PubAusleihenModel>(this.pubUrl + "ausleihen", pubAusleihenModel)


  }

  zeigeAlleAusgeliehenenPubs(): Observable<LeihvorgangModel[]> {
    return this.http.get<LeihvorgangModel[]>(this.pubUrl + "ausleihen/leihvorgaengeLaden")
  }




  zeigeAllePubs(): Observable<PubModel[]> {
    return this.http.get<PubModel[]>(this.pubUrl + "publikation/alleLaden")
  }

  zeigeEinenPub(publikationID: number): Observable<PubModel> {
    return this.http.get<PubModel>(this.pubUrl + "publikation/laden/" + publikationID)
  }

  loeschePub(pubID: number): Observable<PubModel> {
    return this.http.delete<PubModel>(this.pubUrl + "publikation/loeschen/{publikationID}")
  }

bearbeitePub(pub: PubModel): Observable<PubModel> {
    return this.http.put<PubModel>( this.pubUrl + "publikation/editieren", pub)
}
}
