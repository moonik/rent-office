import {Injectable} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";

@Injectable()
export class UsersService{

  constructor(private _http: HttpClient){}

  getAll(){
    return this._http.get("/api/admin/users").map(res => {
      return res.json();
    });
  }

  delete(id){
    return this._http.delete("/api/admin/user/"+id).map(res => {
      return res.json();
    })
  }

}