import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';

import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Category } from 'src/app/category/category';
import { CategoryService } from 'src/app/category/category.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product: Product = new Product();
  submitted = false;
  urlImage: any = ""
  showDefaultImg: boolean = false

  categories: Observable<Category[]>;
  imageUrl: any;

  constructor(private productService: ProductService, private router: Router, private categoryService: CategoryService) { }

  ngOnInit() {
    this.categories = this.categoryService.getCategoryList();
  }

  newProduct(): void {
    this.submitted = false;
    this.product = new Product();
  }
  save() {
    this.product.imageUrl= this.urlImage;
    console.log(this.product)
    this.productService.createProduct(this.product)
      .subscribe(data => console.log(data));
    this.product = new Product();
    this.gotoList();
  }


  onSubmit() {
    this.submitted = true;
    this.save();
  }

  onSelectFile(event) { // called each time file input changes
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        this.urlImage = (event.target as any).result;
      }
    }
    if (!this.urlImage) {
      this.showDefaultImg = true;
    }
  }


  gotoList() {
    this.router.navigate(['/products']);
  }

}
