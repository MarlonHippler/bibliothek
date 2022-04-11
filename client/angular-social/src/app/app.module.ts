import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { Pub } from './pub.uebersicht/pub.uebersicht.component';
import { Pub } from './pub.anlegen/pub.anlegen.component';
import { Pub } from './pub.ausleihen/pub.ausleihen.component';
import { Leihvorgaenge } from './leihvorgaenge.uebersicht/leihvorgaenge.uebersicht.component';
import { Leihvorgang } from './leihvorgang.verlaengern/leihvorgang.verlaengern.component';
import { Pub } from './pub.rueckgabe/pub.rueckgabe.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    Pub.UebersichtComponent,
    Pub.AnlegenComponent,
    Pub.AusleihenComponent,
    Leihvorgaenge.UebersichtComponent,
    Leihvorgang.VerlaengernComponent,
    Pub.RueckgabeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
