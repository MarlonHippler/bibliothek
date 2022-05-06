import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpClientModule} from "@angular/common/http";
import {PubAnlegenModel} from "../models/pub-anlegen-model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {PubAusleihenModel} from "../models/pub-ausleihen-model";
import {PubModel} from "../models/publikation-model";
import {LeihvorgangModel} from "../models/leihvorgang-model";

//autor marc
@Injectable({
  providedIn: 'root'
})
export class PubService {
  private pubUrl = environment.backendUrl;

  constructor(private http: HttpClient) {
  }

  erstellePub(pubAnlegenModel: PubAnlegenModel): Observable<PubAnlegenModel> { //erstellt eine publikation
    return this.http.post<PubAnlegenModel>(this.pubUrl + "publikation/anlegen", pubAnlegenModel)


  }

  ausleihenPub(pubAusleihenModel: PubAusleihenModel): Observable<PubAusleihenModel> { //legt einen ausleihvorgang an
    return this.http.post<PubAusleihenModel>(this.pubUrl + "ausleihen", pubAusleihenModel)


  }

  zeigeAlleAusgeliehenenPubs(): Observable<LeihvorgangModel[]> { //lädt alle´leihvorgänge
    return this.http.get<LeihvorgangModel[]>(this.pubUrl + "ausleihen/leihvorgaengeLaden")
  }
  zeigeAlleAusgeliehenenPubsnachPubID(publikationID: number): Observable<LeihvorgangModel[]> { //lädt alle´leihvorgänge
    return this.http.get<LeihvorgangModel[]>(this.pubUrl + "publikation/ausleihvorgaenge/" + publikationID)
  }




  zeigeAllePubs(): Observable<PubModel[]> { //lädt alle pubs
    return this.http.get<PubModel[]>(this.pubUrl + "publikation/alleLaden")
  }

  zeigeEinenPub(publikationID: number): Observable<PubModel> { //lädt einen bestimmten pub anhand von id
    return this.http.get<PubModel>(this.pubUrl + "publikation/laden/" + publikationID)
  }

  loeschePub(pubID: number): Observable<PubModel> { //löscht einen bestimmten pub anhand der id
    return this.http.delete<PubModel>(this.pubUrl + "publikation/loeschen/" + pubID)
  }

bearbeitePub(pub: PubModel): Observable<PubModel> { // bearbeitet einen pub anhand der id
    return this.http.put<PubModel>( this.pubUrl + "publikation/update/"+ pub.pubID, pub)
}
}
