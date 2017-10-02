import {Component} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";

@Component({
  selector: 'home-component',
  templateUrl: 'dev/home/home.component.html'
})
export class HomeComponent {
  
  items = [];

  constructor(private _httpClient: HttpClient){
    this._httpClient.get('/api/rent-office').map(res => {
      console.log(res);
      return res.json();
    }).subscribe(
      data => {
        this.items = data;
      }
    );
  };
}
