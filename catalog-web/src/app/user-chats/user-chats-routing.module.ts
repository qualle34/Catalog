import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserChatsComponent} from './user-chats.component';

const routes: Routes = [
    {path: 'my/chats', component: UserChatsComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class UserChatsRoutingModule {
}
