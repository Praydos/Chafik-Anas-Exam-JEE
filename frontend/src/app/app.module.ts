// src/app/app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { ClientListComponent } from './components/client-list/client-list.component';
import { ClientFormComponent } from './components/client-form/client-form.component';
import { ClientDetailsComponent } from './components/client-details/client-details.component';
import {AppRoutingModule} from './app.routes';

@NgModule({
  declarations: [
    AppComponent,
    ClientFormComponent,

  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule, ClientListComponent, ClientDetailsComponent],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
