import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryDetailsComponent } from '../category-details/category-details.component';
import { CategoryService } from '../category.service';
import { Category} from "../category"
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  
  categories: Observable<Category[]>;
  p: number=1; 

  public popoverTitle: string = 'WARNING!!!!!!!!';
  public popoverMessage: string ='DO YOU REALLY WANT TO DELETE THESE RECORD?';
  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;

  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  
  reloadData() {
    this.categories = this.categoryService.getCategoryList();
  }

  updateCategory(id: number) {
    this.router.navigate(['/categories/update', id] );
  }

  deleteCategory(id: number){
    this.categoryService.deleteCategory(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }


  createCategory(){
    this.router.navigate(['/categories/add']);
  }

  categoryDetails(id: number){
    this.router.navigate(['/categories/details', id]);
  }

}