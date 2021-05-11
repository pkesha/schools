import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public userName: string;
  public password: string;
  public emailAddress: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    console.log("user component ngOnInit")
  }

  registerUser(): void {

    const newUser = {
      userName: this.userName,
      emailAddress: this.emailAddress,
      password: this.password
    }

    this.userService.registerUser(newUser);
  }

  loginUser(): void {
    
  }

}
