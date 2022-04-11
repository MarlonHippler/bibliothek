import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {LeihvorgangVerlaengernComponent} from './leihvorgang-verlaengern/leihvorgang-verlaengern.component' ;
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LeihvorgaengeUebersichtComponent } from './leihvorgaenge-uebersicht/leihvorgaenge-uebersicht.component' ;
import {PubAusleihenComponent} from "./pub-ausleihen/pub-ausleihen.component";
import {PubRueckgabeComponent} from "./pub-rueckgabe/pub-rueckgabe.component";
import {PubUebersichtComponent} from "./pub-uebersicht/pub-uebersicht.component";
import { PubAnlegenComponent } from './pub-anlegen/pub-anlegen.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LeihvorgangVerlaengernComponent,
    LeihvorgaengeUebersichtComponent,
    PubAusleihenComponent,
    PubRueckgabeComponent,
    PubUebersichtComponent,
    PubAnlegenComponent,





  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
