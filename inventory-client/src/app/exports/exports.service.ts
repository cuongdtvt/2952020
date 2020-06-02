import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExportsService {
 
  private baseUrl = 'http://localhost:8080/exports'
  private baseUrl1 = 'http://localhost:8080/exports/report'
  constructor(private http: HttpClient) { }

  getExports(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createExports(exports: object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, exports);
  }

  updateExports(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteExports(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  reportExports(): Observable<Blob>{
    return this.http.get(`${this.baseUrl1}`,{ responseType:'blob'});
  }

  getExportsList(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
