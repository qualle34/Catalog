import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProfileService} from './profile.service';
import {SimpleUser} from '../model/simple-user.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  user: SimpleUser;
  id: string;

  constructor(private profileService: ProfileService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });
    this.profileService.getUserProfile(this.id)
      .subscribe(data => this.user = data);
  }
}

