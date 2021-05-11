import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

const url = 'localhost:9092'

@Injectable({
  providedIn: 'root'
})
export class PublicCategoryService {

  // Need to have Http client object when service starts
  constructor(private http : HttpClient) { }

  // Method will get categories from http
  getCategories(): any {
    console.log("getCategories call from service");
    return this.http
      .get(`${url}/categories`);
  }

}
