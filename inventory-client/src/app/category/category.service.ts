import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseUrl = 'http://192.168.144.123:8080/categories'

  constructor(private http: HttpClient) { }

  getCategory(id: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCategory(category: object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`, category);
  }

  updateCategory(id: number, value: any): Observable<Object>{
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteCategory(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  getCategoryList(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
