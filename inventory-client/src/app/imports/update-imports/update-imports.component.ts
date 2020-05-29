import { Component, OnInit } from '@angular/core';
import { Imports } from '../imports';
import { ActivatedRoute, Router } from '@angular/router';
import { ImportsService } from '../imports.service';

@Component({
  selector: 'app-update-imports',
  templateUrl: './update-imports.component.html',
  styleUrls: ['./update-imports.component.css']
})
export class UpdateImportsComponent implements OnInit {

  id: number;
  imports: Imports;

  constructor(private route: ActivatedRoute, private router: Router, private importsService: ImportsService) { }

  ngOnInit() {
    this.imports = new Imports();

    this.id = this.route.snapshot.params['id'];

    this.importsService.getImports(this.id)
    .subscribe(data => {
      console.log(data)
      this.imports = data;
    }, error => console.log(error));
  }
  updateImports(){
    this.importsService.updateImports(this.id, this.imports)
    .subscribe(data => console.log(data), error => console.log(error));
  this.imports = new Imports();
  this.gotoList();
  }

  onSubmit(){
    this.updateImports();
  }

  gotoList(){
    this.router.navigate(['/imports']);
  }


}
