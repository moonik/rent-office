import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import 'rxjs/Rx';

@Injectable()
export class AuthRegService{
    constructor(private _http: HttpClient){

    }

    signMeUp(credentials){
        return  this._http.post('/save', credentials).map(res => {
            return res.json();
        });
    }
}