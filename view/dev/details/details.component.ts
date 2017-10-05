import {Component} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {Router, ActivatedRoute, Params} from '@angular/router';
import {DetailsService} from './details.service';

@Component({
    selector: 'details-component',
    templateUrl: 'dev/details/details.component.html'
  })
export class DetailsComponent{
    vehicleId: any;
    vehicle = {type: "Car"};
    action: string;
    vehicleType: string;
    userId = {};
    borrowDate: any;
    users = [];

    constructor(private activatedRoute: ActivatedRoute, private _detailsService : DetailsService, private _router: Router){
        this.activatedRoute.params.subscribe((params: Params) => {
            this.vehicleId = params['id'];
            this.action = params['action'];
            this.borrowDate = params['date'];
            if(this.action=="details" || this.action=="edit"){
                this.init();
            }
        });
        this.getUsers();
    }

    init() {
        this._detailsService.getDetails(this.vehicleId)
        .subscribe(
            data => {
                this.vehicle = data;
            }
        );
    }

    getUsers(){
        this._detailsService.getUsers()
        .subscribe(
            data =>{
                this.users = data;
            }
        )
    }

    goBack(){
        this._router.navigate(['/home']);
    }

    doSave(number){
        this.action == 'edit' ? this.edit() : this.addNew(number);
    }

    borrow(){
        this._detailsService.borrow({vehicle: this.vehicleId, borrower: this.userId, borrowDate: this.borrowDate})
        .subscribe(
            data =>{
                console.log("Borrowed!");
            }
        )
    }

    addNew(number){
        this.vehicle.type == 'Car' ? this.addNewCar() : this.addNewBike(number);
    }

    addNewCar(){
        this._detailsService.addNewCar(this.vehicle)
        .subscribe(
            data =>{
                console.log("Added");
            }
        );
    }

    addNewBike(number){
        this._detailsService.addNewBike(number)
        .subscribe(
            data =>{
                console.log("Added");
            }
        );
    }

    edit(){
        this._detailsService.edit(this.vehicleId, this.vehicle)
        .subscribe(
            data =>{
                console.log("Edited!");
            }
        );
    }
}