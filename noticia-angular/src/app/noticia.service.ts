import { Injectable } from '@angular/core';
import {Noticia} from './noticia';
import {Observable,of,throwError} from 'rxjs';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class NoticiaService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  /*noticias:Noticia[]=[
    {id:1, titulo:'titulo 1', descripcion:'descripcion 1', resumen:'resumen 1', fecha:'fecha 1', favorito:'favorito 1'},
    {id:2, titulo:'titulo 1', descripcion:'descripcion 1', resumen:'resumen 1', fecha:'fecha 1', favorito:'favorito 1'},
    {id:3, titulo:'titulo 1', descripcion:'descripcion 1', resumen:'resumen 1', fecha:'fecha 1', favorito:'favorito 1'},
    {id:4, titulo:'titulo 1', descripcion:'descripcion 1', resumen:'resumen 1', fecha:'fecha 1', favorito:'favorito 1'},
    {id:5, titulo:'titulo 1', descripcion:'descripcion 1', resumen:'resumen 1', fecha:'fecha 1', favorito:'favorito 1'}
  ];*/
  constructor(private http:HttpClient) { }
  private urlEmpoint:string='http://localhost:8080/api/mostrarlista';
  private urlEmpoint2:string='http://localhost:8080/api/mostrafavoritos';
  private urlEmpoint3:string='http://localhost:8080/api/moificarfavoritos';
  private urlEmpoint4:string='http://localhost:8080/api/modificar';
  private urlEmpoint5:string='http://localhost:8080/api/guardar';
/*
  getNoticia ():Noticia[]{

    return this.noticias;
  }
  */
  getNoticia ():Observable<Noticia[]>{

  //  return of(this.noticias);
//  return this.http.get<Noticia[]>(this.urlEmpoint);
return this.http.get<Noticia[]>(this.urlEmpoint).pipe(
  map(response=>response as Noticia[])
);
  }

  getNoticiaFavoritas ():Observable<Noticia[]>{

  //  return of(this.noticias);
//  return this.http.get<Noticia[]>(this.urlEmpoint);
return this.http.get<Noticia[]>(this.urlEmpoint2).pipe(
  map(response=>response as Noticia[])
);
  }

  update(id:number,favorito:boolean):Observable<Noticia>{
    console.log(this.urlEmpoint3+"/"+id+"/"+favorito)
    return this.http.put<Noticia>(this.urlEmpoint3+"/"+id+"/"+favorito,{headers: this.httpHeaders})
  }

  update2(noticia:Noticia):Observable<Noticia>{

    return this.http.post<Noticia>(this.urlEmpoint4,noticia).pipe(
  catchError(e=>{

    if(e.status==400){
      return throwError(e);
    }

    if(e.error.mensaje){
      console.log(e.error.mensaje);
    }

    return throwError(e)
  })
)
  /*  console.log(noticia.titulo);
    noticia.titulo='false';
    console.log(noticia.titulo);
return this.http.post<Noticia>(this.urlEmpoint4,noticia, {headers: this.httpHeaders})*/
}


create(noticia: Noticia) : Observable<Noticia> {
  return this.http.post<Noticia>(this.urlEmpoint5, noticia, {headers: this.httpHeaders})
}

}
