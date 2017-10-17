import {Component} from '@angular/core';
import {UsersService} from './users.service'
import {UserDTO} from '../auth.reg/UserDTO'

@Component({
    templateUrl: 'dev/users/users.component.html',
    styleUrls: ['dev/css/auth.component.css'],
    providers: [UsersService, UserDTO]
  })
  export class UsersComponent{
      userDTO: UserDTO[];

    constructor(private userService: UsersService){
      this.getUsers();
    }

    addNew(){}

    getUsers(){
        this.userService.getAll().subscribe(
            data =>{
                this.userDTO = data;
            }
        )
    }

    delete(user){
        this.userService.delete(user.userId).subscribe(
            success =>{
                let index = this.userDTO.indexOf(user);
                this.userDTO.splice(index, 1);
              }
          )
      }
  }