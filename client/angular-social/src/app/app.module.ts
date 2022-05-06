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

// import {PubLoeschenComponent} from "./pub-loeschen/pub-loeschen.component";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {MatSortModule} from "@angular/material/sort";
import {MatSnackBar, MatSnackBarModule} from "@angular/material/snack-bar";
import {MatButtonToggleModule} from "@angular/material/button-toggle";


@NgModule({
  declarations: [
    AppComponent,

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
    RouterModule.forRoot([{path: 'pubuebersicht', component: PubUebersichtComponent},
      {path: 'anlegen', component: PubAnlegenComponent},
      {path: 'anlegen/:id', component: PubAnlegenComponent},
      {path: 'ausleihen', component: PubAusleihenComponent},
      {path: 'leihvorganguebersicht', component: LeihvorgaengeUebersichtComponent},
      {path: 'leihvorganguebersicht/:id', component: LeihvorgaengeUebersichtComponent},

      // Routen an dieser Stelle werden genutzt

    ]),
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatSelectModule,
    MatSortModule,
    MatSnackBarModule,
    MatButtonToggleModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
