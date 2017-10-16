import {Component} from '@angular/core';
import {AuthRegService} from './auth.reg.service';
import {UserDTO} from './UserDTO';
import {AlertService} from '../alert/alert.service';
import {Router} from '@angular/router';

@Component({
    selector: 'auth-component',
    templateUrl: 'dev/auth.reg/auth.reg.component.html',
    styleUrls: ['dev/css/auth.component.css'],
    providers: [UserDTO, AuthRegService]
  })
  export class AuthRegComponent{
    errorMessage: string;
    feedback: string;

    constructor(private authRegService: AuthRegService, private userDTO: UserDTO, private alertService: AlertService, private _router: Router){

    }

    signMeUp(){
        this.authRegService.signMeUp(this.userDTO)
        .subscribe(
            res =>{
                this.feedback = "Signed up! :) Now you can Sign in"
            },
            error =>{
                this.errorMessage = error._body;
            }
        );
    }

    signMeIn(){
        this.authRegService.signMeIn(this.userDTO)
        .subscribe(
            res =>{
                this._router.navigate(['/home']);
            },
            error =>{
                if(error.status == 401){
                    this.errorMessage = error._body;
                }else
                    this._router.navigate(['/error']);
            }
        );  
    }
}