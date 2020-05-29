import { Component, OnInit } from '@angular/core';
import { Exports } from '../exports';
import { ActivatedRoute, Router } from '@angular/router';
import { ExportsService } from '../exports.service';


@Component({
  selector: 'app-update-exports',
  templateUrl: './update-exports.component.html',
  styleUrls: ['./update-exports.component.css']
})
export class UpdateExportsComponent implements OnInit {
  id: number;
  exports: Exports;

  constructor(private route: ActivatedRoute, private router: Router, private exportsService: ExportsService) { }

  ngOnInit() {
    this.exports = new Exports();

    this.id = this.route.snapshot.params['id'];

    this.exportsService.getExports(this.id)
    .subscribe(data => {
      console.log(data)
      this.exports = data;
    }, error => console.log(error));
  }

  updateExports(){
    this.exportsService.updateExports(this.id, this.exports)
      .subscribe(data => console.log(data), error => console.log(error));
    
    this.exports = new Exports();
    
    this.gotoList();
  }

  onSubmit(){
    this.updateExports();
  }

  gotoList(){
    this.router.navigate(['/exports']);
  }

}
