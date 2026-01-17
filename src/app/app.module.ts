import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';  // ← IMPORTANT pour ngModel

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExploitationsComponent } from './exploitations/exploitations.component';
import { CapteursComponent } from './capteurs/capteurs.component';
import { AlertesComponent } from './alertes/alertes.component';
import { CreateexploitationComponent } from './createexploitation/createexploitation.component';
import { CreatedonneecapteurComponent } from './createdonneecapteur/createdonneecapteur.component';

@NgModule({
  declarations: [
    AppComponent,
    ExploitationsComponent,
    CapteursComponent,
    AlertesComponent,
    CreateexploitationComponent,
    CreatedonneecapteurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule  // ← Obligatoire pour [(ngModel)]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }