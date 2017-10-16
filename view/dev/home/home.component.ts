import {Component} from '@angular/core';
import {DatePipe} from '@angular/common';
import {HomeService} from './home.service';
import {Router} from '@angular/router';
import {HomeDto} from './homeDto';
import {AlertService} from '../alert/alert.service';

@Component({
  selector: 'home-component',
  templateUrl: 'dev/home/home.component.html',
  styleUrls: ['dev/css/home.component.css'],
  providers: [DatePipe, HomeDto, HomeService]
})
export class HomeComponent {

  constructor(private homeDto: HomeDto, private datepipe: DatePipe, private _homeService: HomeService, private _router: Router, 
    private alertService: AlertService){

    this.homeDto.date = this.datepipe.transform(this.homeDto.date, 'yyyy-MM-dd');
    this.getAll(this.homeDto.date);
  }

  getAll(date){
    this._homeService.getAll(date)
    .subscribe(
      data => {
        this.homeDto.items = data;
      },
      error =>{
        if(error.status == 401){
          this._router.navigate(['/form']);
        }else
          this._router.navigate(['/error']);
      }
    );
  }

  details(id){
    this._router.navigate(['/details/'+id, {date: this.homeDto.date}]);
  }
  
  edit(id){
    this._router.navigate(['/edit/'+id, {date: this.homeDto.date}]);
  }

  addNew(){
    this._router.navigate(['/add/'+'new', {date: this.homeDto.date}]);
  }
  
  delete(item){
    if(item.wasBorrowed == null){
      this._homeService.delete(item.id)
      .subscribe(
        success =>{
          let index = this.homeDto.items.indexOf(item);
          this.homeDto.items.splice(index, 1);
          this.alertService.success("Vehicle has been successfully deleted");
        },
        error =>{
          this.alertService.error(error._body);
        }
      );
    }
  }

  unborrow(item){
    this._homeService.unborrow(item.id, this.homeDto.date)
    .subscribe(
      success =>{
        let index = this.homeDto.items.indexOf(item);
        this.homeDto.items[index].borrower = "";
        this.homeDto.items[index].borrowDate = "";
        this.alertService.success("Vehicle has been successfully removed from borrow");
      },
      error =>{
        this.alertService.error(error._body);
      }
    );
  }
}
