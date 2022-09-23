import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

const url = 'http://localhost:9092/api/categories';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  title: string;
  description: string;

  getCategories(): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };

    return this.http
      .get(`${url}`, requestOptions);
  }

  createCategories(category: any): any {

    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    console.log(token, 'token intialized');
    return this.http
      .post(`${url}`, category , requestOptions);

  }

  deleteCategory(categoryId: any): any {

    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    console.log(token, 'token intialized');
    return this.http
      .delete(`${url}/${categoryId}`, requestOptions);

  }

  updateCategory(categoryId: any): any {

    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    console.log(token, 'token intialized');
    return this.http
      .put(`${url}/${categoryId}`, requestOptions);

  }



}
