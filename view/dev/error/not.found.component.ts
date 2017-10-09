import {Component} from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';

@Component({
    selector: 'error-page-component',
    templateUrl: 'dev/error/not.found.component.html',
    styleUrls: ['dev/css/not.found.css']
  })
  export class NotFoundErrorPage{

    constructor(private router: Router){

    }

    goHome(){
      this.router.navigate(['/home']);
    }
  }