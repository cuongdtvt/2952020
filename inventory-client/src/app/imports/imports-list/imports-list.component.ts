import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { ImportsDetailsComponent } from '../imports-details/imports-details.component';
import { Imports} from '../imports';
import { ImportsService } from './../imports.service';



@Component({
  selector: 'app-imports-list',
  templateUrl: './imports-list.component.html',
  styleUrls: ['./imports-list.component.css']
})
export class ImportsListComponent implements OnInit {
  p: number=1;
  
  imports: Observable<Imports[]>;

  fileType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';

  constructor(private importsService: ImportsService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.imports = this.importsService.getImportsList();
  }

  updateImports(id: number) {
    this.router.navigate(['/imports/update' + id]);
  }

  deleteImports(id: number) {
    this.importsService.deleteImports(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }


  reportImports(){
    this.importsService.reportImports().subscribe(x=>{
      const blob= new Blob([x], {type:this.fileType})
      // if (window.navigator && window.navigator.msSaveOrOpenBlob){
      //   window.navigator.msSaveOrOpenBlob(blob);
      //   return;
      // }
      const data= window.URL.createObjectURL(blob);
      const link=document.createElement('a');
      link.href=data;
      link.download='ReportImport.xlsx';
      link.dispatchEvent(new MouseEvent('click',{bubbles:true, cancelable:true, view:window}));
      // setTimeout(function(){
      //   window.URL.revokeObjectURL(data);
      //   link.remove();
      // },100);
    });
  }

  importsDetails(id: number){
    this.router.navigate(['imports/details', id])
  }

}
