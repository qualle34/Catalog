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
}
