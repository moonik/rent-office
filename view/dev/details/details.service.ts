import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import 'rxjs/Rx';

@Injectable()
export class DetailsService{

    constructor(private _http: HttpClient) {}

    getDetails(id, currentDate){
        return this._http.get('/api/rent-office/details/'+id+'/'+currentDate).map(res => {
            return res.json();
        });
    }

    edit(id,data){
        return this._http.put('/api/admin/car/'+id, data).map(res =>{
            return res.json();
        });
    }

    borrow(data){
        return this._http.post('/api/rent-office/borrow', data).map(res =>{
            return res.json();
        });
    }

    addNewCar(data){
        return this._http.post('/api/car/', data).map(res =>{
            return res.json();
        });  
    }

    addNewBike(number){
        return this._http.post('/api/bike/'+number, null).map(res =>{
            return res.json();
        }); 
    }
}