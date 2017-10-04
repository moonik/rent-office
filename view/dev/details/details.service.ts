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

    edit(id,data){
        return this._http.put('/api/car/'+id, data).map(res =>{
            return res.json();
        });
    }

    borrow(data: Object){
        return this._http.post('/api/rent-office/borrow', data).map(res =>{
            return res.json();
        });
    }

    addNewCar(data){
        return this._http.post('/api/car/', data).map(res =>{
            return res.json();
        });  
    }
}