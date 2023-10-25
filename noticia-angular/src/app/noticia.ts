export class Noticia {

  id: number;
  titulo: string;
  descripcion: string;
  resumen: string;
  fecha: string;
  favorito:string;


  constructor(id: number,titulo: string,descripcion: string,resumen: string,fecha: string,favorito:string){
    this.id=id;
    this.titulo=titulo;
    this.descripcion=descripcion;
    this.resumen=resumen;
    this.fecha=fecha;
    this.favorito=favorito;
  }
}
