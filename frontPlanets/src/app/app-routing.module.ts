import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PersonsComponent} from './components/persons/persons.component';
import {PlanetsComponent} from './components/planets/planets.component';

const routes: Routes = [
  {path: 'persons',  component: PersonsComponent},
  {path: 'planets', component: PlanetsComponent},
  {path: 'plantes/:id', component: PlanetsComponent },
  {path: 'persons/:card/:type', component: PersonsComponent },
  {path: '', redirectTo: '/planets', pathMatch: 'full'},
  {path: '**', redirectTo: '/persons'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
