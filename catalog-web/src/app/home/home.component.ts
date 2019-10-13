import {Component, OnInit} from '@angular/core';
import {SimpleAdvert} from '../model/simple-advert.model';
import {HomeService} from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  adverts: SimpleAdvert[];

  constructor(private homeService: HomeService) {
  }

  ngOnInit() {
    return this.homeService.getAdverts()
      .subscribe(data => this.adverts = data);
  }
}
