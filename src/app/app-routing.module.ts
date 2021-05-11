import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  {
    path: "categories",
    component: CategoryComponent 
  },
  {
    path: "user",
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
