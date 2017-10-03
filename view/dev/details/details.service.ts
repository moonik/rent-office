import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import 'rxjs/Rx';

@Injectable()
export class DetailsService{

    constructor(private _http: HttpClient) {}

    getDetails(id){
        return this._http.get('/api/rent-office/details/'+id).map(res => {
            return res.json();
        });
    }
}