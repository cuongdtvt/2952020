import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Category } from '../category';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  category: Category = new Category();
  submitted = false; 

  categories: Observable<Category[]>;

  constructor( private categoryService: CategoryService, private router: Router) { }

  ngOnInit() {
  }

  newCategory(): void{
    this.submitted = false;
    this.category = new Category();
  }

  save(){
    this.categoryService.createCategory(this.category)
      .subscribe(data => console.log(data), error => console.log(error));
    this.category = new Category();
    this.reloadData();
    this.gotoList();
  }

  reloadData() {
    this.categories = this.categoryService.getCategoryList();
  }

  onSubmit(){
    this.submitted = true;
    this.save();
  }

  gotoList(){
    this.router.navigate(['/categories']);
  }

}
