import {Component} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {DatePipe} from '@angular/common';

@Component({
  selector: 'home-component',
  templateUrl: 'dev/home/home.component.html',
  providers: [DatePipe]
})
export class HomeComponent {
  
  items = [];
  date : any = new Date();

  constructor(public datepipe: DatePipe, private _httpClient: HttpClient){
    this.date = this.datepipe.transform(this.date, 'yyyy-MM-dd');
    this._httpClient.get('/api/rent-office/'+this.date).map(res => {
      console.log(res);
      return res.json();
    }).subscribe(
      data => {
        this.items = data;
      }
    );
  };

  onChange(date){
    console.log("HEY THERE");
    console.log(date);
    this.date = date;
    this._httpClient.get('/api/rent-office/'+this.date).map(res => {
      console.log(res);
      return res.json();
    }).subscribe(
      data => {
        this.items = data;
      }
    );
  }
}
