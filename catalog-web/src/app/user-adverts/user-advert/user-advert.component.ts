import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {UserAdvertsService} from '../user-adverts.service';
import {CookieService} from 'ngx-cookie-service';
import {Advert} from '../../model/advert.model';

@Component({
  selector: 'app-user-advert',
  templateUrl: './user-advert.component.html',
  styleUrls: ['./user-advert.component.css']
})

export class UserAdvertComponent implements OnInit {
  advert: Advert;
  newAdvert: Advert;
  id: string;

  constructor(private userAdvertsService: UserAdvertsService, private cookieService: CookieService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    const token: string = this.cookieService.get('token');
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });
    this.userAdvertsService.getUserAdvert(this.id, token).subscribe(data => this.advert = data);
  }

  update(event) {
    event.preventDefault();
    this.newAdvert = new Advert();
    this.newAdvert.price = event.target.querySelector('#price').value;
    this.newAdvert.description = event.target.querySelector('#description').value;
    this.userAdvertsService.updateAdvert(this.newAdvert, this.getToken());
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
