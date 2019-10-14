import {Component, OnInit} from '@angular/core';
import {SimpleAdvert} from '../model/simple-advert.model';
import {HomeService} from './home.service';
import {Category} from '../model/category.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  adverts: SimpleAdvert[];
  categories: Category[];

  constructor(private homeService: HomeService) {
  }

  ngOnInit() {
    this.homeService.getAdverts().subscribe(data => this.adverts = data);
    this.homeService.getCategories().subscribe(data => this.categories = data);
  }

  byCategory(id) {
    this.homeService.getAdvertsByCategory(id).subscribe(data => this.adverts = data);
  }

  bySearch(event: any) {
    this.homeService.getBySearch(event.target.value).subscribe(data => this.adverts = data);
  }
}
