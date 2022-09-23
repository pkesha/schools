import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CategoryService} from "../services/category/category.service";

@Component({
  selector: 'app-category-card',
  templateUrl: './category-card.component.html',
  styleUrls: ['./category-card.component.css']
})
export class CategoryCardComponent implements OnInit {

  @Input() category: any;

  @Output() deleteItemEvent = new EventEmitter<any>();

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
  }

  deleteCategory(categoryId: number): void {
    this.categoryService.deleteCategory(categoryId)
      .subscribe(response => {
        console.log(response + 'categoryId ' + categoryId);
        // telling the parent that an item is deleted in the child
        this.deleteItemEvent.emit();
      });
  }

  updateCategory(categoryId: number): void {
    this.categoryService.updateCategory(categoryId)
      .subscribe(response => {
        console.log(response + 'categoryId ' + categoryId);
        // telling the parent that an item is deleted in the child
        this.deleteItemEvent.emit();
      });
  }

}
