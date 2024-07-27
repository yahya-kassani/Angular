import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  constructor(private _http: HttpClient) { }

  addMatiere(data:any):Observable<any>{
    return this._http.post('http://localhost:42423/matiere',data);
  }

  getMatiere():Observable<any>{
    return this._http.get('http://localhost:42423/matiere');
  }

  deleteMatiere(id:number):Observable<any>{
    return this._http.delete(`http://localhost:42423/matiere/${id}`);
  }

  updateMatier(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:42423/matiere/${id}`, data);
  }
}
