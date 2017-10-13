import {Component} from '@angular/core';
import {AuthRegService} from './auth.reg.service';
import {UserDTO} from './UserDTO';
import {AlertService} from '../alert/alert.service';

@Component({
    selector: 'auth-component',
    templateUrl: 'dev/auth.reg/auth.reg.component.html',
    styleUrls: ['dev/css/auth.component.css'],
    providers: [UserDTO]
  })
  export class AuthRegComponent{

    constructor(private authRegService: AuthRegService, private userDTO: UserDTO, private alertService: AlertService){

    }

    signMeUp(){
        this.authRegService.signMeUp(this.userDTO)
        .subscribe(
            res =>{
                this.alertService.success("Signed up! :)")
            },
            error =>{
                this.alertService.error(error);
            }
        );
    }
  }