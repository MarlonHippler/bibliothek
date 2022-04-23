import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PublikationsUebersichtComponent} from "./publikationsUebersicht/publikations-uebersicht.component";
import {PubAnlegenComponent} from "./pub-anlegen/pub-anlegen.component";
import {PubAusleihenComponent} from "./pub-ausleihen/pub-ausleihen.component";

import {CommonModule} from "@angular/common";

const routes: Routes = [
  {path: 'menu', component: PublikationsUebersichtComponent},
  {path: 'anlegen', component: PubAnlegenComponent},
  {path: 'ausleihen', component: PubAusleihenComponent}
];

@NgModule({
  declarations:[],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingALTModule {
}
