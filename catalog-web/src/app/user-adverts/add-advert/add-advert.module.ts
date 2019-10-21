import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddAdvertRoutingModule } from './add-advert-routing.module';
import { AddAdvertComponent } from './add-advert.component';


@NgModule({
  declarations: [AddAdvertComponent],
  imports: [
    CommonModule,
    AddAdvertRoutingModule
  ]
})
export class AddAdvertModule { }
