import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Observable } from 'rxjs';

import { ExportsService } from '../exports.service';
import { Exports } from '../exports';

import { ProductService } from './../../product/product.service';
import { Product } from 'src/app/product/product';

@Component({
  selector: 'app-create-exports',
  templateUrl: './create-exports.component.html',
  styleUrls: ['./create-exports.component.css']
})
export class CreateExportsComponent implements OnInit {

  exports: Exports = new Exports();
  submitted = false;

  products: Observable<Product[]>;
  exports1: Observable<Exports[]>;
  constructor(private productService: ProductService, private router: Router, private exportsService: ExportsService) { }

  ngOnInit() {
    this.products = this.productService.getProductsList();
  }

  newExports(): void {
    this.submitted = false;
    this.exports = new Exports();
  }

  reloadData() {
    this.exports1 = this.exportsService.getExportsList();
  }

  save() {
    console.log(this.exports)
    this.exportsService.createExports(this.exports)
      .subscribe(data => console.log(data), error => console.log(error));
    this.exports = new Exports();
    this.reloadData();
    this.gotoList();
   
  }

  onSubmit(){
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/exports']);
  }
}

