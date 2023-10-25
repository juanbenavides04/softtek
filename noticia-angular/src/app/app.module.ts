import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FavoritoComponent } from './favorito/favorito.component';
import {NoticiaService} from './noticia.service';

import {RouterModule,Routes} from '@angular/Router';
import { NoticiaComponent } from './noticia/noticia.component';
import {HttpClientModule} from '@angular/common/http';
import { FormComponent } from './form/form.component';

import {FormsModule} from '@angular/forms';



  const routes:Routes=[
  {path:'',redirectTo:'/noticia',pathMatch:'full'},
  {path:'favoritos',component:FavoritoComponent},
  {path:'noticia',component:NoticiaComponent},
  {path:'form',component:FormComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    FavoritoComponent,
    NoticiaComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [NoticiaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
