import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpClientModule} from "@angular/common/http";
import {PubAnlegenModel} from "../models/pub-anlegen-model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PubAnlegenService {
  private pubUrl = environment.backendUrl;

  constructor(private http: HttpClient) {
  }

  erstellePub(pubAnlegenModel: PubAnlegenModel): Observable<PubAnlegenModel> {
    return this.http.post<PubAnlegenModel>(this.pubUrl + "publikation/anlegen", pubAnlegenModel)
  }
}
