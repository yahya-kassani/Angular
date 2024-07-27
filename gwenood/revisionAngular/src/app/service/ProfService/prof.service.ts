import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfService {

  constructor(private _http: HttpClient) { }

  addProf(data:any):Observable<any>{
    return this._http.post('http://localhost:42410/professeur',data);
  }

  getProf():Observable<any>{
    return this._http.get('http://localhost:42410/professeur');
  }

  deleteProf(id:number):Observable<any>{
    return this._http.delete(`http://localhost:42410/professeur/${id}`);
  }

  updateProf(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:42410/professeur/${id}`, data);
  }
}
