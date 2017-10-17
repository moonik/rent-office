export class DetailsDto{
    vehicleId: any;
    vehicle = {type: "Car", borrowDate: null};
    action: string;
    vehicleType: string;
    borrowDate: any;
    currentDate: any = new Date();
    users = [];
}