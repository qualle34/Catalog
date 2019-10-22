import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
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

  constructor(private userAdvertsService: UserAdvertsService, private cookieService: CookieService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });
    this.get();
  }

  get() {
    this.userAdvertsService.getUserAdvert(this.id, this.getToken()).subscribe(data => this.advert = data);
  }

  update(event) {
    event.preventDefault();
    this.newAdvert = new Advert();
    this.newAdvert.id = Number(this.id);
    this.newAdvert.title = event.target.querySelector('#title').value;
    this.newAdvert.price = event.target.querySelector('#price').value;
    this.newAdvert.type = event.target.querySelector('#type').value;
    this.newAdvert.description = event.target.querySelector('#description').value;
    this.userAdvertsService.updateAdvert(this.newAdvert, this.getToken());
  }

  async delete(id: number) {
    this.userAdvertsService.deleteAdvert(id, this.getToken());
    await this.router.navigate(['/my/adverts']);
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
