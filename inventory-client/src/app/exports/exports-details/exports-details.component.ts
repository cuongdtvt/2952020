import { Component, OnInit } from '@angular/core';
import { Exports } from '../exports';
import { ExportsService } from '../exports.service';
import { ExportsListComponent } from '../exports-list/exports-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-exports-details',
  templateUrl: './exports-details.component.html',
  styleUrls: ['./exports-details.component.css']
})
export class ExportsDetailsComponent implements OnInit {

  id: number;
  exports: Exports;

  constructor(private router: Router, private route: ActivatedRoute, private exportsService: ExportsService) { }

  ngOnInit() {
    this.exports = new Exports();

    this.id = this.route.snapshot.params['id'];

    this.exportsService.getExports(this.id).subscribe(data => {
      console.log(data)
      this.exports = data;
    }, error => console.log(error));
  }
  list(){
    this.router.navigate(['exports']);
  }

}
