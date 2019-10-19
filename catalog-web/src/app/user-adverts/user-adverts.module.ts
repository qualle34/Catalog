import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserAdvertsRoutingModule } from './user-adverts-routing.module';
import { UserAdvertsComponent } from './user-adverts.component';


@NgModule({
  declarations: [UserAdvertsComponent],
  imports: [
    CommonModule,
    UserAdvertsRoutingModule
  ]
})
export class UserAdvertsModule { }
