import { Component, OnInit } from '@angular/core';
import { PublicCategoryService } from '../services/public-category.service';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  public categories: [];

  constructor(private categoryService: PublicCategoryService) { }

  ngOnInit(): void {
    console.log("ngOnInit category component");
    this.getCategories();
  }

  getCategories(): any {
    this.categoryService.getCategories().subscribe( response => {
      this.categories = response;
    }, err => console.log(err));
    
  }

}
