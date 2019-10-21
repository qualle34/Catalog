import {Component} from '@angular/core';
import {Advert} from '../../model/advert.model';
import {UserAdvertsService} from '../user-adverts.service';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-add-advert',
  templateUrl: './add-advert.component.html',
  styleUrls: ['./add-advert.component.css']
})

export class AddAdvertComponent {
  advert: Advert;

  constructor(private advertService: UserAdvertsService, private cookieService: CookieService) {
  }

  add(event) {
    event.preventDefault();
    this.advert = new Advert();
    this.advert.title = event.target.querySelector('#title').value;
    this.advert.description = event.target.querySelector('#description').value;
    this.advert.price = event.target.querySelector('#price').value;
    this.advert.categoryId = event.target.querySelector('#category').value;
    this.advert.type = event.target.querySelector('#type').value;
    this.advertService.addAdvert(this.advert, this.getToken());
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
