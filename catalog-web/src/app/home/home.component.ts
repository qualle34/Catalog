import {Component, OnInit} from '@angular/core';
import {SimpleAdvert} from '../model/simple-advert.model';
import {HomeService} from './home.service';
import {Category} from '../model/category.model';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  adverts: SimpleAdvert[];
  categories: Category[];
  category: number;
  type: string;

  constructor(private homeService: HomeService, private cookieService: CookieService) {
  }

  ngOnInit() {
    this.homeService.getAdverts().subscribe(data => this.adverts = data);
    this.homeService.getCategories().subscribe(data => this.categories = data);
  }

  byCategory() {
    this.homeService.getAdvertsByCategory(this.category).subscribe(data => this.adverts = data);
  }

  byType() {
    this.homeService.getAdvertsByType(this.type).subscribe(data => this.adverts = data);
  }

  byCategoryAndType() {
    this.homeService.getAdvertsByCategoryAndType(this.category, this.type).subscribe(data => this.adverts = data);
  }

  bySearch(event: any) {
    this.homeService.getBySearch(event.target.value).subscribe(data => this.adverts = data);
  }

  bySearchAndType(event: any) {
    this.homeService.getAdvertsBySearchAndType(event.target.value, this.type).subscribe(data => this.adverts = data);
  }

  isTokenExists() {
    return this.cookieService.get('token') !== null && this.cookieService.get('token') !== '';
  }

  setCategory(id: number) {
    this.category = id;
    this.byCategory();
  }

  setType(type: string) {
    this.type = type;
    this.byType();
  }
}
