import {Component} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {Router, ActivatedRoute, Params} from '@angular/router';
import {DetailsService} from './details.service';
import {DatePipe} from '@angular/common';

@Component({
    selector: 'details-component',
    templateUrl: 'dev/details/details.component.html',
    providers: [DatePipe]
  })
export class DetailsComponent{
    vehicleId: any;
    vehicle = {type: "Car", borrowDate: null};
    action: string;
    vehicleType: string;
    userId = null;
    borrowDate: any;
    currentDate: any = new Date();
    users = [];

    constructor(private datepipe: DatePipe, private activatedRoute: ActivatedRoute, private _detailsService : DetailsService, private _router: Router){
        this.currentDate = this.datepipe.transform(this.currentDate, 'yyyy-MM-dd');
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
        this._detailsService.getDetails(this.vehicleId, this.currentDate)
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
        if(this.borrowDate >= this.currentDate && this.borrowDate != this.vehicle.borrowDate){
            this._detailsService.borrow({vehicle: this.vehicleId, borrower: this.userId, borrowDate: this.borrowDate})
            .subscribe(
                data =>{
                    console.log("Borrowed!");
                }
            );
        }
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