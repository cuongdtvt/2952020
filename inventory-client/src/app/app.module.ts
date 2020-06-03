import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';


import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipe } from 'ng2-search-filter';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { ChartsModule } from 'ng2-charts';


import { CreateProductComponent } from './product/create-product/create-product.component';
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { UpdateProductComponent } from './product/update-product/update-product.component';

import { CreateCategoryComponent } from './category/create-category/create-category.component';
import { CategoryDetailsComponent } from './category/category-details/category-details.component';
import { CategoryListComponent } from './category/category-list/category-list.component';
import { UpdateCategoryComponent } from './category/update-category/update-category.component';

import { CreateImportsComponent } from './imports/create-imports/create-imports.component';
import { ImportsDetailsComponent } from './imports/imports-details/imports-details.component';
import { ImportsListComponent } from './imports/imports-list/imports-list.component';
import { UpdateImportsComponent } from './imports/update-imports/update-imports.component';

import { CreateExportsComponent } from './exports/create-exports/create-exports.component';
import { ExportsDetailsComponent } from './exports/exports-details/exports-details.component';
import { ExportsListComponent } from './exports/exports-list/exports-list.component';
import { UpdateExportsComponent } from './exports/update-exports/update-exports.component';



import { LineChartComponent } from './chart/line-chart/line-chart.component';


@NgModule({
  declarations: [
    AppComponent,
    
    CreateProductComponent,
    ProductDetailsComponent,
    ProductListComponent,
    UpdateProductComponent,

    CreateCategoryComponent,
    CategoryDetailsComponent,
    CategoryListComponent,
    UpdateCategoryComponent,

    CreateImportsComponent,
    ImportsDetailsComponent,
    ImportsListComponent,
    UpdateImportsComponent,

    CreateExportsComponent,
    ExportsDetailsComponent,
    ExportsListComponent,
    UpdateExportsComponent,
    Ng2SearchPipe,

    LineChartComponent,

  
    
  ],
  imports: [
    ChartsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger'}),
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
