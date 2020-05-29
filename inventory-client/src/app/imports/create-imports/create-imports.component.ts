import { ProductService } from './../../product/product.service';
import { Component, OnInit } from '@angular/core';
import { ImportsService } from '../imports.service';
import { Imports } from '../imports';
import { Router} from '@angular/router';

import { Product } from 'src/app/product/product';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-create-imports',
  templateUrl: './create-imports.component.html',
  styleUrls: ['./create-imports.component.css']
})
export class CreateImportsComponent implements OnInit {

  imports: Imports = new Imports();
  submitted = false;

  products: Observable<Product[]>;

  constructor(private productService: ProductService, private router: Router, private importsService: ImportsService) { }

  ngOnInit() {
    this.products = this.productService.getProductsList();
  }

  newImports(): void {
    this.submitted = false;
    this.imports = new Imports();
  }

  save() {
    this.importsService.createImports(this.imports)
      .subscribe(data => console.log(data), error => console.log(error));
    this.imports = new Imports();
    this.gotoList();
  }

  onSubmit(){
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/imports']);
  }
}
