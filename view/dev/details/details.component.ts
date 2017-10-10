import {Component} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {Router, ActivatedRoute, Params} from '@angular/router';
import {DetailsService} from './details.service';
import {DatePipe} from '@angular/common';
import {DetailsDto} from './detailsDto';
import {AlertService} from '../alert/alert.service';

@Component({
    selector: 'details-component',
    templateUrl: 'dev/details/details.component.html',
    styleUrls: ['dev/css/details.component.css'],
    providers: [DatePipe, DetailsDto]
  })
export class DetailsComponent{

    constructor(private detailsDto: DetailsDto,private datepipe: DatePipe, private activatedRoute: ActivatedRoute, 
        private _detailsService : DetailsService, private _router: Router, private alertService: AlertService){

        this.detailsDto.currentDate = this.datepipe.transform(this.detailsDto.currentDate, 'yyyy-MM-dd');
        this.activatedRoute.params.subscribe((params: Params) => {
            this.detailsDto.vehicleId = params['id'];
            this.detailsDto.action = params['action'];
            this.activatedRoute.params.subscribe(
                data =>{
                    this.detailsDto.borrowDate = data['date'];
                }
              );
            if(this.detailsDto.action=="details" || this.detailsDto.action=="edit"){
                this.init();
            }
        });
        this.getUsers();
    }

    init() {
        this._detailsService.getDetails(this.detailsDto.vehicleId, this.detailsDto.currentDate)
        .subscribe(
            data => {
                this.detailsDto.vehicle = data;
            },
            error => {
                this._router.navigate(['/error', {backUrl: "home"}]);
            }
        );
    }

    getUsers(){
        this._detailsService.getUsers()
        .subscribe(
            data =>{
                this.detailsDto.users = data;
            }
        )
    }

    goBack(){
        this._router.navigate(['/home']);
    }

    doSave(number){
        this.detailsDto.action == 'edit' ? this.edit() : this.addNew(number);
    }

    borrow(){
        if(this.detailsDto.borrowDate >= this.detailsDto.currentDate && this.detailsDto.borrowDate != this.detailsDto.vehicle.borrowDate){
            this._detailsService.borrow({vehicle: this.detailsDto.vehicleId, borrower: this.detailsDto.userId, borrowDate: this.detailsDto.borrowDate})
            .subscribe(
                data =>{
                    this.alertService.success("Vehicle has been successfully borrowed");
                },
                error => {
                    this._router.navigate(['/error', {backUrl: this.detailsDto.action + '/' + this.detailsDto.vehicleId + '/' + this.detailsDto.borrowDate}]);
                }
            );
        }
    }

    addNew(number){
        this.detailsDto.vehicle.type == 'Car' ? this.addNewCar() : this.addNewBike(number);
    }

    addNewCar(){
        this._detailsService.addNewCar(this.detailsDto.vehicle)
        .subscribe(
            data =>{
                console.log("Added");
                this.alertService.success("Vehicle has been successfully added");
            },
            error => {
                this._router.navigate(['/error', {backUrl: this.detailsDto.action + '/' + this.detailsDto.vehicleId + '/' + this.detailsDto.borrowDate}]);
            }
        );
    }

    addNewBike(number){
        this._detailsService.addNewBike(number)
        .subscribe(
            data =>{
                this.alertService.success("Vehicle has been successfully added");
            },
            error => {
                this._router.navigate(['/error', {backUrl: this.detailsDto.action + '/' + this.detailsDto.vehicleId + '/' + this.detailsDto.borrowDate}]);
            }
        );
    }

    edit(){
        this._detailsService.edit(this.detailsDto.vehicleId, this.detailsDto.vehicle)
        .subscribe(
            data =>{
                this.alertService.success("Vehicle has been successfully edited");
            },
            error => {
                this._router.navigate(['/error', {backUrl: this.detailsDto.action + '/' + this.detailsDto.vehicleId + '/' + this.detailsDto.borrowDate}]);
            }
        );
    }
}