import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const url = 'http://localhost:9092'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  registerUser(user: any): void {
    console.log("user service - registerUser method");
    this.http
    .post(`${url}/auth/users/register`, user)
    .subscribe( user => {
      console.log(user);
    });
  }

  loginUser(user: any): any {
    this.http
    .post(`${url}/auth/users/login`, user)
    .subscribe(response =>{
      const token = response['jwt'];
      console.log(response)
      localStorage.setItem('token', `${token}`);
    })
  }

  createUserProfile(userProfile: any) {
    const token = localStorage.getItem('token');
      const requestOptions = {
        headers: new HttpHeaders({
          Authorization: `Bearer ${token}`
        }),
      };

    this.http
    .post(`${url}/auth/users/create`, userProfile, requestOptions)
    .subscribe(userProfile =>{
      console.log(userProfile);
    })
  }
}
