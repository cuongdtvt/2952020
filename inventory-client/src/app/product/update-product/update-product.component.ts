import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Observable } from 'rxjs';

import { Category } from 'src/app/category/category';
import { CategoryService } from 'src/app/category/category.service';
@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  urlImage: any = ""
  showDefaultImg: boolean = false
  imageUrl: any;
  id: number;
  product: Product;
  products: Observable<Product[]>;
  constructor(private route: ActivatedRoute,private categoryService: CategoryService, private router: Router, private productService: ProductService) { }

  categories: Observable<Category[]>;

  ngOnInit() {
    this.product = new Product();

    this.id = this.route.snapshot.params['id'];
    
    this.productService.getProduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.product = data;
      }, error => console.log(error));

      this.categories = this.categoryService.getCategoryList();
  }


  updateProduct(){
    
    this.product.imageUrl= this.urlImage;
    this.productService.updateProduct(this.id, this.product)
    .subscribe(data => console.log(data), error => console.log(error));
  this.product = new Product();
  
  this.gotoList();
  this.reloadData();
  }

  onSubmit(){
    this.updateProduct();
  }

  gotoList(){
    this.router.navigate(['/products']);
  }

  reloadData() {
    this.products = this.productService.getProductsList();
  }

  onSelectFile(event) { // called each time file input changes
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        this.urlImage = (event.target as any).result;
      }
    }
  }

}
