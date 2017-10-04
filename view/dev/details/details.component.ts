import {Component} from '@angular/core';
import {HttpClient} from "../common/services/http-client.service";
import {Router, ActivatedRoute, Params} from '@angular/router';
import {DetailsService} from './details.service';

@Component({
    selector: 'details-component',
    templateUrl: 'dev/details/details.component.html'
  })
export class DetailsComponent{
    vehicleId: number;
    vehicle = {};
    action: string;
    vehicleType: string;

    constructor(private activatedRoute: ActivatedRoute, private _detailsService : DetailsService){
        this.activatedRoute.params.subscribe((params: Params) => {
            this.vehicleId = params['id'];
            this.action = params['action'];
            if(this.action=="details" || this.action=="edit"){
                this.init();
            }
        });
    }

    init() {
        this._detailsService.getDetails(this.vehicleId)
        .subscribe(
            data => {
                this.vehicle = data;
            }
        );
    }
}