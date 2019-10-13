import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {AdvertModule} from './advert/advert.module';
import {HttpClientModule} from '@angular/common/http';
import {ProfileModule} from './profile/profile.module';
import {AdminModule} from './admin/admin.module';
import {LoginModule} from './login/login.module';
import {RegistrationModule} from './registration/registration.module';
import {UserAdvertModule} from './user-advert/user-advert.module';
import {UserChatModule} from './user-chat/user-chat.module';
import {UserProfileModule} from './user-profile/user-profile.module';
import {HomeModule} from './home/home.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HomeModule,
    AdminModule,
    AdvertModule,
    LoginModule,
    ProfileModule,
    RegistrationModule,
    UserAdvertModule,
    UserChatModule,
    UserProfileModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
