import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private _http:HttpClient) { }
  
  addStudent(data:any):Observable<any>{
    return this._http.post('http://localhost:42400/student',data);
  }

  getStudent():Observable<any>{
    return this._http.get('http://localhost:42400/student');
  }

  deleteStudent(id:number):Observable<any>{
    return this._http.delete(`http://localhost:42400/student/${id}`);
  }

  updateStudent(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:42400/student/${id}`, data);
  }
  
}
