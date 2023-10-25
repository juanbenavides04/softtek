import { Component } from '@angular/core';
import {Noticia} from './../noticia';
import {NoticiaService} from './../noticia.service';

@Component({
  selector: 'app-favorito',
  templateUrl: './favorito.component.html',
  styleUrls: ['./favorito.component.css']
})
export class FavoritoComponent {

  noticias:Noticia[];

    constructor(private noticiaService:NoticiaService ){

      this.noticias = [];
    }

    ngOnInit(){
    //  this.noticias=this.noticiaService.getNoticia();
      this.noticiaService.getNoticiaFavoritas().subscribe(
        noticias=>this.noticias= noticias
      );
    }
}
