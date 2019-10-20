import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileComponent} from './profile/profile.component';
import {UserAdvertComponent} from './user-adverts/user-advert/user-advert.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {UserChatsComponent} from './user-chats/user-chats.component';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {HomeComponent} from './home/home.component';
import {ErrorComponent} from './error/error.component';
import {ChatComponent} from './user-chats/chat/chat.component';
import {AdvertComponent} from './home/advert/advert.component';
import {UserAdvertsComponent} from './user-adverts/user-adverts.component';
import {LogoutComponent} from './login/logout/logout.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'advert/:id', component: AdvertComponent},
  {path: 'profile/:id', component: ProfileComponent},
  {path: 'my/profile', component: UserProfileComponent},
  {path: 'my/adverts', component: UserAdvertsComponent},
  {path: 'my/advert/:id', component: UserAdvertComponent},
  {path: 'my/chats', component: UserChatsComponent},
  {path: 'my/chat/:id', component: ChatComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
