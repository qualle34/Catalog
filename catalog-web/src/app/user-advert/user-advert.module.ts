import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserAdvertRoutingModule} from './user-advert-routing.module';
import {UserAdvertComponent} from './user-advert.component';
import {UserAdvertService} from './user-advert.service';

@NgModule({
  declarations: [UserAdvertComponent],
  imports: [
    CommonModule,
    UserAdvertRoutingModule
  ],
  providers: [UserAdvertService]
})

export class UserAdvertModule {
}
