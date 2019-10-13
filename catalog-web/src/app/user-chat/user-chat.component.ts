import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-chat',
  templateUrl: './user-chat.component.html',
  styleUrls: ['./user-chat.component.css']
})

export class UserChatComponent implements OnInit {

  constructor(private ar: ActivatedRoute) {
  }

  ngOnInit() {
  }
}
