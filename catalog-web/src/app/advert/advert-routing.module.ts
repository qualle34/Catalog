import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdvertComponent} from './advert.component';

const routes: Routes = [
  {path: 'advert/:id', component: AdvertComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdvertRoutingModule {
}
