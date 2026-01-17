import { createNgModuleRef, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExploitationsComponent } from './exploitations/exploitations.component';
import { CapteursComponent } from './capteurs/capteurs.component';
import { AlertesComponent } from './alertes/alertes.component';
import { CreateexploitationComponent } from './createexploitation/createexploitation.component';
import { CreatedonneecapteurComponent } from './createdonneecapteur/createdonneecapteur.component';

const routes: Routes = [
  { path: '', redirectTo: '/exploitations', pathMatch: 'full' },
  { path: 'exploitations', component: ExploitationsComponent },
  { path: 'capteurs', component: CapteursComponent },
  { path: 'alertes', component: AlertesComponent },
  { path: 'create-exploitation', component: CreateexploitationComponent },
  { path: 'create-donnee-capteur', component: CreatedonneecapteurComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }