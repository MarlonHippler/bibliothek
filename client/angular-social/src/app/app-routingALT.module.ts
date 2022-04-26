import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {PubAnlegenComponent} from "./pub-anlegen/pub-anlegen.component";
import {PubAusleihenComponent} from "./pub-ausleihen/pub-ausleihen.component";

import {CommonModule} from "@angular/common";
import {PubUebersichtComponent} from "./pub-uebersicht/pub-uebersicht.component";

const routes: Routes = [
  {path: 'menu', component: PubUebersichtComponent},
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
