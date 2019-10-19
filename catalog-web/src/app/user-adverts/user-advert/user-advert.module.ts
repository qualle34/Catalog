import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserAdvertRoutingModule} from './user-advert-routing.module';
import {UserAdvertComponent} from './user-advert.component';
import {UserAdvertsService} from '../user-adverts.service';

@NgModule({
  declarations: [UserAdvertComponent],
  imports: [
    CommonModule,
    UserAdvertRoutingModule
  ],
  providers: [UserAdvertsService]
})

export class UserAdvertModule {
}
