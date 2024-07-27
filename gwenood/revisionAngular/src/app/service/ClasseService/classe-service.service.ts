import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClasseServiceService {

  constructor(private _http:HttpClient) { }

  addClass(data:any):Observable<any>{
    return this._http.post('http://localhost:42401/class',data);
  }

  getClass():Observable<any>{
    return this._http.get('http://localhost:42401/class');
  }

  deleteClass(id:number):Observable<any>{
    return this._http.delete(`http://localhost:42401/class/${id}`);
  }

  updateClass(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:42401/class/${id}`, data);
  }

}
