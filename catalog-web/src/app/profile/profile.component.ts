import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProfileService} from './profile.service';
import {SimpleUser} from '../model/simple-user.model';
import {CookieService} from 'ngx-cookie-service';
import {NewChat} from '../model/new-chat.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  user: SimpleUser;
  chat: NewChat;
  id: string;

  constructor(private profileService: ProfileService, private route: ActivatedRoute, private router: Router, private cookieService: CookieService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });
    this.get();
  }

  get() {
    this.profileService.getUserProfile(this.id)
      .subscribe(data => this.user = data);
  }

  async newChat(event, title: string) {
    event.preventDefault();
    this.chat = new NewChat();
    this.chat.userId = Number(this.id);
    this.chat.title = title;

    this.profileService.newChat(this.chat, this.getToken());
    await this.router.navigate(['/my/chats']);
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}

