import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../category.service';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  id: number;
  category: Category;

  categories: Observable<Category[]>;

  constructor(private route: ActivatedRoute, private router: Router, private categoryService: CategoryService) { }


  ngOnInit() {
    this.category = new Category();

    this.id = this.route.snapshot.params['id'];

    this.categoryService.getCategory(this.id)
    .subscribe(data => {
      console.log(data)
      this.category = data;
    }, error => console.log(error));
  }

  updateCategory(){
    this.categoryService.updateCategory(this.id, this.category)
    .subscribe(data => console.log(data), error => console.log(error));
  this.category = new Category();
  this.reloadData();
  this.gotoList();
  }

  reloadData() {
    this.categories = this.categoryService.getCategoryList();
  }

  onSubmit(){
    this.updateCategory();
  }

  gotoList(){
    this.router.navigate(['/categories'])
  }
}
