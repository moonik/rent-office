import {Component} from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';

@Component({
    selector: 'error-page-component',
    templateUrl: 'dev/error/error.html',
    styleUrls: ['dev/css/error.page.css']
  })
  export class ErrorPage{
    backUrl :any;
    date: any;

    constructor(private _router: Router, private activatedRoute: ActivatedRoute){
      this.activatedRoute.params.subscribe(
        data =>{
          this.backUrl = data['backUrl'];
          this.date = data['date'];
        }
      );
    }

  goBack(){
    this._router.navigate(['/' + this.backUrl == null? 'home' : this.backUrl, {date: this.date}]);
  }
}