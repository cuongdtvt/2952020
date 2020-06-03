import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChartService {
  private baseUrl1 = 'http://localhost:8080/statistics7exports'
  private baseUrl2 = 'http://localhost:8080/statistics30exports'
  private baseUrl3 = 'http://localhost:8080/statistics7imports'
  private baseUrl4 = 'http://localhost:8080/statistics30imports'
  
  constructor(private http: HttpClient) { }

  getStatistics7Exports(): Observable<any>{
    return this.http.get(`${this.baseUrl1}`);
  }

  getStatistics30Exports(): Observable<any>{
    return this.http.get(`${this.baseUrl2}`);
  }

  getStatistics7Imports(): Observable<any>{
    return this.http.get(`${this.baseUrl3}`);
  }

  getStatistics30Imports(): Observable<any>{
    return this.http.get(`${this.baseUrl4}`);
  }

}

