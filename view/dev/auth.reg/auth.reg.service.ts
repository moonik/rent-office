import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {CookieService} from '../common/services/cookie.service';
import 'rxjs/Rx';

@Injectable()
export class AuthRegService{

    constructor(private _http: HttpClient, private cookieService: CookieService){}

    signMeIn(credentials){
        return this._http.post('/auth', credentials)
        .map(res => {
          const data = res.json();
          if(data) {
            localStorage.setItem('token', data.token);
            this.cookieService.setCookie('token', data.token, 1, "/");                                                                                                                                                                                                                                                                                                                                                                                       
            // document.cookie = "token="+data.token;
            // let x = document.cookie;
            // console.log(x);
          }
        });
    }

    signMeUp(credentials){
        return  this._http.post('/save', credentials).map(res => {
            return res.json();
        });
    }
}