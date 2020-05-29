import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { CategoryListComponent } from '../category-list/category-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  id: number;
  category: Category;

  constructor(private route: ActivatedRoute, private router: Router, private categoryService: CategoryService) {}

  ngOnInit() {
    this.category = new Category();

    this.id = this.route.snapshot.params['id'];

    this.categoryService.getCategory(this.id).subscribe(data => {
      console.log(data)
      this.category = data;
    }, error => console.log(error));
  }

  list(){
    this.router.navigate(['categories'])
  }

}
