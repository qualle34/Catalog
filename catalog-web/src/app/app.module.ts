import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {ProfileModule} from './profile/profile.module';
import {AdminModule} from './admin/admin.module';
import {LoginModule} from './login/login.module';
import {RegistrationModule} from './registration/registration.module';
import {UserAdvertModule} from './user-adverts/user-advert/user-advert.module';
import {UserChatsModule} from './user-chats/user-chats.module';
import {UserProfileModule} from './user-profile/user-profile.module';
import {HomeModule} from './home/home.module';
import {ErrorModule} from './error/error.module';
import {ChatModule} from './user-chats/chat/chat.module';
import {UserAdvertsModule} from './user-adverts/user-adverts.module';
import {AdvertModule} from './home/advert/advert.module';
import {LogoutModule} from './login/logout/logout.module';
import {AddAdvertModule} from './user-adverts/add-advert/add-advert.module';

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
    LogoutModule,
    ProfileModule,
    RegistrationModule,
    UserAdvertsModule,
    UserAdvertModule,
    AddAdvertModule,
    UserChatsModule,
    ChatModule,
    UserProfileModule,
    ErrorModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
