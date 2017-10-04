import {Component} from '@angular/core';

@Component({
    selector: 'creation-component',
    templateUrl: 'dev/creation/creation.component.html',
    styleUrls: ['dev/css/home.component.css']
  })
  export class CreationComponent {
      type: string = "Car";
  }