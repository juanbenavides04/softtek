import { Component ,OnInit} from '@angular/core';
import {Noticia} from './../noticia';
import {NoticiaService} from './../noticia.service';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.css']
})
export class NoticiaComponent {

  noticias:Noticia[];

    constructor(private noticiaService:NoticiaService ){

      this.noticias = [];
    }

    ngOnInit(){
    //  this.noticias=this.noticiaService.getNoticia();
      this.noticiaService.getNoticia().subscribe(
        noticias=>this.noticias= noticias
      );
    }

/*    update():void{
  this.clienteService.update(this.cliente).subscribe(
    cliente=>{
      this.router.navigate(['/clientes'])
      swal.fire('cliente Acualizado', `Cliente ${cliente.nombre} Actualizado con éxito!`, 'success')
    }
  )
}*/

update(noticia:Noticia):void{
  //console.log("component "+noticia)
    this.noticiaService.update2(noticia);
}
/*
    update(id:number,favorito:boolean):void{
      console.log(id+" "+favorito)
        this.noticiaService.update(id,favorito);
    }*/

}
