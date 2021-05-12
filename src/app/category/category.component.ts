import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {CategoryService} from '../services/category/category.service';
import {HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})

export class CategoryComponent implements OnInit {

  public categories: [];
  public title: string;
  public description: string;


  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    if(this.categories === null) {}
    else {
      this.getCategories();
    }
  }

  getCategories(): void {
    console.log('categories component get categories');

    this.categoryService.getCategories()
      .subscribe( categories => {
        this.categories = categories;
        console.log(categories);
      });

  }

  createCategory(): any {
    let category: any = {
      title: this.title,
      description: this.description
    };

    this.categoryService.createCategories(category)
      .subscribe(response => {
        console.log(response);
        this.getCategories();
      });

  }

}
