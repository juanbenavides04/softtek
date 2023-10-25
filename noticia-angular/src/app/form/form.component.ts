import { Component, OnInit } from '@angular/core';
import {Noticia} from './../noticia';
import {NoticiaService} from './../noticia.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{
  //private cliente:Noticia=new Noticia();

   noticia:Noticia=new Noticia( 1,"","","","","");

  title:string='Ingresar Noticia';
//var car= new Noticia();
//private noticia:Noticia=new Noticia();
//noticia:Noticia[];

  constructor(private noticiaService:NoticiaService ){
//this.noticias=null;
  }

  ngOnInit(){
  }

  public create():void{
console.log(this.noticia);
this.noticiaService.create(this.noticia)

  }

}
