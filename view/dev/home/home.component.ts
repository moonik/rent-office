import {Component} from '@angular/core';
import {DatePipe} from '@angular/common';
import {HomeService} from './home.service';
import {Router} from '@angular/router';

@Component({
  selector: 'home-component',
  templateUrl: 'dev/home/home.component.html',
  styleUrls: ['dev/css/home.component.css'],
  providers: [DatePipe]
})
export class HomeComponent {
  items = [];
  date : any = new Date();

  constructor(private datepipe: DatePipe, private _homeService: HomeService, private _router: Router){
    this.date = this.datepipe.transform(this.date, 'yyyy-MM-dd');
    this.getAll(this.date);
  }

  getAll(date){
    this._homeService.getAll(date)
    .subscribe(
      data => {
        this.items = data;
      }
    );
  }

  details(id){
    this._router.navigate(['/details/'+id+'/'+this.date]);
  }
  
  edit(id){
    this._router.navigate(['/edit/'+id+'/vehicle']);
  }

  addNew(){
    this._router.navigate(['/add/'+'new'+'/vehicle']);
  }
}
