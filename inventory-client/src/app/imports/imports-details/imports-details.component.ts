import { Component, OnInit } from '@angular/core';
import { Imports } from '../imports';
import { ImportsService } from '../imports.service';
import { ImportsListComponent } from '../imports-list/imports-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-imports-details',
  templateUrl: './imports-details.component.html',
  styleUrls: ['./imports-details.component.css']
})
export class ImportsDetailsComponent implements OnInit {

  id: number;
  imports: Imports;

  constructor(private router: Router, private route: ActivatedRoute, private importsService: ImportsService) { }

  ngOnInit() {
    this.imports = new Imports();
    
    this.id = this.route.snapshot.params['id'];

    this.importsService.getImports(this.id).subscribe(data => {
      console.log(data)
      this.imports = data;
    }, error => console.log(error));
  }

  list(){
    this.router.navigate(['imports']);
  }

}
