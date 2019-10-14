import {Component} from '@angular/core';
import {RegistrationUser} from '../model/registration-user.model';
import {RegistrationService} from './registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent {
  private user: RegistrationUser;

  constructor(private registrationService: RegistrationService) {
  }

  register(event) {
    event.preventDefault();
    this.user = new RegistrationUser();
    this.user.login = event.target.querySelector('#login').value;
    this.user.firstname = event.target.querySelector('#firstname').value;
    this.user.email = event.target.querySelector('#email').value;
    this.user.password = event.target.querySelector('#password').value;
    this.registrationService.register(this.user);
  }
}
