import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-advert',
  templateUrl: './user-advert.component.html',
  styleUrls: ['./user-advert.component.css']
})

export class UserAdvertComponent implements OnInit {

  constructor(private ar: ActivatedRoute) {
  }

  ngOnInit() {
  }
}
