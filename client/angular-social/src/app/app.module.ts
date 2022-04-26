import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {LeihvorgangVerlaengernComponent} from './leihvorgang-verlaengern/leihvorgang-verlaengern.component' ;
import {AppRoutingALTModule} from './app-routingALT.module';
import {AppComponent} from './app.component';
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
import {MatTableModule, MatTextColumn} from "@angular/material/table";
import {PubEditierenComponent} from "./pub-editieren/pub-editieren.component";
import {PubLoeschenComponent} from "./pub-loeschen/pub-loeschen.component";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    AppComponent,

    LeihvorgangVerlaengernComponent,
    LeihvorgaengeUebersichtComponent,
    PubAusleihenComponent,
    PubRueckgabeComponent,
    PubUebersichtComponent,
    PubAnlegenComponent,
    PubEditierenComponent,
    PubLoeschenComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingALTModule,
    NoopAnimationsModule,
    RouterModule.forRoot([{path: 'pubuebersicht', component: PubUebersichtComponent},
      {path: 'anlegen', component: PubAnlegenComponent},
      {path: 'ausleihen', component: PubAusleihenComponent},
      {path: 'leihvorganguebersicht', component: LeihvorgaengeUebersichtComponent},
      {path: 'editieren', component: PubEditierenComponent},
      {path: 'loeschen', component: PubLoeschenComponent}

    ]),
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    MatTableModule,
    MatButtonModule



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
