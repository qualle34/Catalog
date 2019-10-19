import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdvertRoutingModule} from './advert-routing.module';
import {AdvertComponent} from './advert.component';
import {AdvertService} from './advert.service';

@NgModule({
  declarations: [AdvertComponent],
  imports: [
    CommonModule,
    AdvertRoutingModule
  ],
  providers: [AdvertService]
})

export class AdvertModule {
}
