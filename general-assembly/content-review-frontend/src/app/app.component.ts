import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userRoutes: string[] = [
    'register',
    'login',
    'profile'
  ];

  title = 'content-review-frontend';
}
