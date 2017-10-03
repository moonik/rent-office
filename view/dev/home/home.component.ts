import {Component} from '@angular/core';
import {DatePipe} from '@angular/common';
import {HomeService} from './home.service';
import {Router} from '@angular/router';

@Component({
  selector: 'home-component',
  templateUrl: 'dev/home/home.component.html',
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

  addNew(id){
    this._router.navigate(['/details/'+id]);
  }
}
