import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './user-profile.component';
import {UserProfileRoutingModule} from './user-profile-routing.module';
import {UserProfileService} from './user-profile.service';
import {CookieService} from 'ngx-cookie-service';

@NgModule({
  declarations: [UserProfileComponent],
  imports: [
    CommonModule,
    UserProfileRoutingModule
  ],
  providers: [UserProfileService, CookieService]
})

export class UserProfileModule { }
