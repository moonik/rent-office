import {Component} from '@angular/core';
import {DatePipe} from '@angular/common';
import {HomeService} from './home.service';
import {Router} from '@angular/router';
import {HomeDto} from './homeDto';

@Component({
  selector: 'home-component',
  templateUrl: 'dev/home/home.component.html',
  styleUrls: ['dev/css/home.component.css'],
  providers: [DatePipe, HomeDto]
})
export class HomeComponent {

  constructor(private homeDto: HomeDto, private datepipe: DatePipe, private _homeService: HomeService, private _router: Router){
    this.homeDto.date = this.datepipe.transform(this.homeDto.date, 'yyyy-MM-dd');
    this.getAll(this.homeDto.date);
  }

  getAll(date){
    this._homeService.getAll(date)
    .subscribe(
      data => {
        this.homeDto.items = data;
      }
    );
  }

  details(id){
    this._router.navigate(['/details/'+id+'/'+this.homeDto.date]);
  }
  
  edit(id){
    this._router.navigate(['/edit/'+id+'/vehicle']);
  }

  addNew(){
    this._router.navigate(['/add/'+'new'+'/vehicle']);
  }
  
  delete(item){
    if(item.wasBorrowed == null){
      this._homeService.delete(item.id)
      .subscribe(
        res =>{
          let index = this.homeDto.items.indexOf(item);
          this.homeDto.items.splice(index, 1);
        }
      );
    }
  }
}
