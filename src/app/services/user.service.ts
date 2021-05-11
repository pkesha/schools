import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const url = 'http://localhost:9092'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userName: string;
  private emailAddress: string;
  private password: string;

  constructor(private http: HttpClient) { }

  registerUser(user: any): void {
    console.log("user service - registerUser method");
    this.http
    .post(`${url}/auth/users/register`, user)
    .subscribe( user => {
      console.log(user);
    });
    
  }
}
