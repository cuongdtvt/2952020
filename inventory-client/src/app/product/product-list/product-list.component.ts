import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { ProductDetailsComponent } from '../product-details/product-details.component';
import { ProductService } from "../product.service";
import { Product } from "../product";

import { Category } from 'src/app/category/category';
import { CategoryService } from 'src/app/category/category.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  
  p: number=1; 
  
  products: Observable<Product[]>;

  categories: Observable<Category[]>;

  public popoverTitle: string = 'WARNING!!!!!!!!';
  public popoverMessage: string ='DO YOU REALLY WANT TO DELETE THESE RECORD?';
  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;


  constructor(private categoryService: CategoryService,private productService: ProductService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
    this.categories = this.categoryService.getCategoryList();
  }
  
  reloadData() {
    this.products = this.productService.getProductsList();
    console.log(this.products);
  }

  updateProduct(id: number) {
    this.router.navigate(['/update', id] );
  }
  deleteProduct(id: number){
    this.productService.deleteProduct(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  
  createProduct(){
    this.router.navigate(['add']);
  }
  productDetails(id: number){
    this.router.navigate(['details', id]);
  }

}
