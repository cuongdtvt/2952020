import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { formatDate } from '@angular/common';
import { ChartService } from '../chart.service';
import { HttpClient , HttpClientModule} from '@angular/common/http';
import { Chart } from '../chart';

import { Observable } from 'rxjs';


@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.css']
})
export class LineChartComponent implements OnInit {

  

   abc: any[]=  [];
   bcd: any[]= [];


  constructor(private chartService : ChartService,private http: HttpClient) { }

  ngOnInit() {
      for (let i = 6; i >= 0;i--)
         { 
              let day : string = new Date(new Date().getFullYear(), new Date().getMonth(),new Date().getDate()-i).toString();
              let date = formatDate(day, "dd-MM-yyyy", "en");
              this.lineChartLabels.push(date);
          }
   console.log(this.lineChartLabels);

 
        
      this.chartService.getStatistics7Exports()
        .subscribe(res => {
          console.log(res)
          for(let i = 0; i < res.length; i++) {
            console.log(res[i].qty)
            
            this.abc.push(res[i].qty);
          }

      });

      this.chartService.getStatistics7Imports()
      .subscribe(res => {
        console.log(res)
        for(let i = 0; i < res.length; i++) {
          console.log(res[i].qty)
          
          this.bcd.push(res[i].qty);
        }

    })




 
  }
   

   // Array of different segments in chart
   lineChartData: ChartDataSets[] = [
    { data: this.abc, label: 'Xuất Hàng' },
    { data: this.bcd, label: 'Nhập Hàng' }
  ];

  //Labels shown on the x-axis
  lineChartLabels: Label[] = [];

  // Define chart options
  lineChartOptions: ChartOptions = {
    responsive: true
  };

  // Define colors of chart segments
  lineChartColors: Color[] = [

    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
    },
    { // red
      backgroundColor: 'rgba(255,0,0,0.3)',
      borderColor: 'red',
    }
  ];

  // Set true to show legends
  lineChartLegend = true;

  // Define type of chart
  lineChartType = 'line';

  lineChartPlugins = [];

  // events
  chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

}


