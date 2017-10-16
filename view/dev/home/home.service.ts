import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import 'rxjs/Rx';

@Injectable()
export class HomeService{

    constructor(private _http: HttpClient) {}

    getAll(date){
        return  this._http.get('/api/rent-office/'+date).map(res => {
            return res.json();
        });
    };

    delete(id){
        return  this._http.delete('/api/admin/vehicle/'+id).map(res => {
            return res.json();
        });
    }

    unborrow(id, date){
        return  this._http.delete('/api/admin/unborrow/'+id+'/'+date).map(res => {
            return res.json();
        }); 
    }
}