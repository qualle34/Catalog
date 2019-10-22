import {Component, OnInit} from '@angular/core';
import {AdvertService} from './advert.service';
import {Advert} from '../../model/advert.model';
import {Comment} from '../../model/comment.model';
import {ActivatedRoute} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html',
  styleUrls: ['./advert.component.css']
})

export class AdvertComponent implements OnInit {
  advert: Advert;
  comment: Comment;
  id: string;

  constructor(private advertService: AdvertService, private route: ActivatedRoute, private cookieService: CookieService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });
    this.get();
  }

  get() {
    this.advertService.getAdvert(this.id).subscribe(data => this.advert = data);
  }

  addComment(event) {
    event.preventDefault();

    this.comment = new Comment();
    this.comment.advertId = Number(this.id);
    this.comment.text = event.target.querySelector('#comment').value;
    event.target.querySelector('#comment').value = '';
    this.advertService.addComment(this.comment, this.getToken());
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
