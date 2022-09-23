import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/userservice/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public email: string;
  public password: string;
  public token: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  loginUser(){
    const user = {
      email: this.email,
      password: this.password
    };

    this.token = this.userService.loginUser(user);
  }

}
