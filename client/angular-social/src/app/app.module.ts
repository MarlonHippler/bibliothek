import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {LeihvorgangVerlaengernComponent} from './leihvorgang-verlaengern/leihvorgang-verlaengern.component' ;
import {AppRoutingALTModule} from './app-routingALT.module';
import {AppComponent} from './app.component';
import {PublikationsUebersichtComponent} from './publikationsUebersicht/publikations-uebersicht.component';
import {LeihvorgaengeUebersichtComponent} from './leihvorgaenge-uebersicht/leihvorgaenge-uebersicht.component' ;
import {PubAusleihenComponent} from "./pub-ausleihen/pub-ausleihen.component";
import {PubRueckgabeComponent} from "./pub-rueckgabe/pub-rueckgabe.component";
import {PubUebersichtComponent} from "./pub-uebersicht/pub-uebersicht.component";
import {PubAnlegenComponent} from './pub-anlegen/pub-anlegen.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    AppComponent,
    PublikationsUebersichtComponent,
    LeihvorgangVerlaengernComponent,
    LeihvorgaengeUebersichtComponent,
    PubAusleihenComponent,
    PubRueckgabeComponent,
    PubUebersichtComponent,
    PubAnlegenComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingALTModule,
    NoopAnimationsModule,
    RouterModule.forRoot([{path: 'menu', component: PublikationsUebersichtComponent},
      {path: 'anlegen', component: PubAnlegenComponent},
      {path: 'ausleihen', component: PubAusleihenComponent}]),
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
