
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductListComponent } from './product/product-list/product-list.component';
import { UpdateProductComponent } from './product/update-product/update-product.component';
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { CreateProductComponent } from './product/create-product/create-product.component';

import { CategoryListComponent } from './category/category-list/category-list.component';
import { UpdateCategoryComponent } from './category/update-category/update-category.component';
import { CategoryDetailsComponent } from './category/category-details/category-details.component';
import { CreateCategoryComponent } from './category/create-category/create-category.component';

import { ImportsListComponent } from './imports/imports-list/imports-list.component';
import { UpdateImportsComponent } from './imports/update-imports/update-imports.component';
import { ImportsDetailsComponent } from './imports/imports-details/imports-details.component';
import { CreateImportsComponent } from './imports/create-imports/create-imports.component';

import { ExportsListComponent } from './exports/exports-list/exports-list.component';
import { UpdateExportsComponent } from './exports/update-exports/update-exports.component';
import { ExportsDetailsComponent } from './exports/exports-details/exports-details.component';
import { CreateExportsComponent } from './exports/create-exports/create-exports.component';



const routes: Routes = [
  { path: '', redirectTo: 'product', pathMatch: 'full' },
  { path: 'products', component: ProductListComponent },
  { path: 'add', component: CreateProductComponent },
  { path: 'update/:id', component: UpdateProductComponent },
  { path: 'details/:id', component: ProductDetailsComponent },
 
  { path: 'categories', component: CategoryListComponent },
  { path: 'categories/add', component: CreateCategoryComponent },
  { path: 'categories/update/:id', component: UpdateCategoryComponent },
  { path: 'categories/details/:id', component: CategoryDetailsComponent },

  { path: 'imports', component: ImportsListComponent },
  { path: 'imports/add', component: CreateImportsComponent },
  { path: 'imports/update/:id', component: UpdateImportsComponent },
  { path: 'imports/details/:id', component: ImportsDetailsComponent },

  { path: 'exports', component: ExportsListComponent },
  { path: 'exports/add', component: CreateExportsComponent },
  { path: 'exports/update/:id', component: UpdateExportsComponent },
  { path: 'exports/details/:id', component: ExportsDetailsComponent },

  

  

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
