import {RouterModule, Routes} from '@angular/router';
import {ClientListComponent} from './components/client-list/client-list.component';
import {ClientFormComponent} from './components/client-form/client-form.component';
import {ClientDetailsComponent} from './components/client-details/client-details.component';
import {NgModule} from '@angular/core';

export const routes: Routes = [
  { path: '', redirectTo: '/clients', pathMatch: 'full' },
  { path: 'clients', component: ClientListComponent },
  { path: 'add-client', component: ClientFormComponent },
  { path: 'client/:id', component: ClientDetailsComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
