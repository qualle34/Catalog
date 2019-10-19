import {Component, OnInit} from '@angular/core';
import {AdvertService} from './advert.service';
import {Advert} from '../../model/advert.model';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html',
  styleUrls: ['./advert.component.css']
})

export class AdvertComponent implements OnInit {
  advert: Advert;
  id: string;

  constructor(private advertService: AdvertService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });

    return this.advertService.getAdvert(this.id)
      .subscribe(data => this.advert = data);
  }
}
