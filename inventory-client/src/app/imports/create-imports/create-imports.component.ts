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
  imports1: Observable<Imports[]>;
  constructor(private productService: ProductService, private router: Router, private importsService: ImportsService) { }

  ngOnInit() {
    this.products = this.productService.getProductsList();
  }

  newImports(): void {
    this.submitted = false;
    this.imports = new Imports();
  }

  reloadData() {
    this.imports1 = this.importsService.getImportsList();
  }

  save() {
    console.log(this.imports)
    this.importsService.createImports(this.imports)
      .subscribe(data => console.log(data), error => console.log(error));
    this.imports = new Imports();
    this.reloadData();
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
