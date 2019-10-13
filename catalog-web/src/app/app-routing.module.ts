import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdvertComponent} from './advert/advert.component';
import {ProfileComponent} from './profile/profile.component';
import {UserAdvertComponent} from './user-advert/user-advert.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {UserChatComponent} from './user-chat/user-chat.component';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'advert/:id', component: AdvertComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'my', component: UserAdvertComponent},
  {path: 'my', component: UserProfileComponent},
  {path: 'chats', component: UserChatComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
