import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ExportsDetailsComponent} from '../exports-details/exports-details.component';
import { ExportsService } from '../exports.service';
import { Exports} from "../exports"
import { Router } from '@angular/router';

@Component({
  selector: 'app-exports-list',
  templateUrl: './exports-list.component.html',
  styleUrls: ['./exports-list.component.css']
})
export class ExportsListComponent implements OnInit {
  p: number=1;
  
  exports: Observable<Exports[]>;

  fileType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';


  constructor(private router: Router, private exportsService: ExportsService) { }
  
  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.exports = this.exportsService.getExportsList();
  }

  updateExports(id: number) {
    this.router.navigate(['/exports/update' + id]);
  }

  deleteExports(id: number){
    this.exportsService.deleteExports(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  reportExports(){
    this.exportsService.reportExports().subscribe(x=>{
      const blob= new Blob([x], {type:this.fileType})
      // if (window.navigator && window.navigator.msSaveOrOpenBlob){
      //   window.navigator.msSaveOrOpenBlob(blob);
      //   return;
      // }
      const data= window.URL.createObjectURL(blob);
      const link=document.createElement('a');
      link.href=data;
      link.download='ReportExport.xlsx';
      link.dispatchEvent(new MouseEvent('click',{bubbles:true, cancelable:true, view:window}));
      // setTimeout(function(){
      //   window.URL.revokeObjectURL(data);
      //   link.remove();
      // },100);
    });
  }

  exportsDetails(id: number){
    this.router.navigate(['exports/details', id])
  }

  createExport(){
    this.router.navigate(['exports/add']);
  }

  

}
