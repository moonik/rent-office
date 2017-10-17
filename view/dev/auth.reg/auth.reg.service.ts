import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {CookieService} from '../common/services/cookie.service';
import 'rxjs/Rx';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class AuthRegService{

    constructor(private _http: HttpClient, private cookieService: CookieService){
    }

    signMeIn(credentials){
        return this._http.post('/auth', credentials)
        .map(res => {
          const data = res.json();
          if(data) {
            //localStorage.setItem('token', data.token);
            this.cookieService.setCookie('token', data.token, 1, "/");   
            this.cookieService.setCookie('role', data.userDTO.role, 1, "/");
          }
        });
    }

    signMeUp(credentials){
        return  this._http.post('/save', credentials).map(res => {
            return res.json();
        });
    }
}