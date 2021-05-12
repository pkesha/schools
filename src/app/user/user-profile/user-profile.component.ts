import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/userservice/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public firstName: string;
  public lastName: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  registerUserProfile(){
    const userProfile = {
      firstName: this.firstName,
      lastName: this.lastName
    }

    this.userService.createUserProfile(userProfile);
  }
}
