import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileListComponent} from './profile-list.component';


const routes: Routes = [
    {
        path: '',
        component: ProfileListComponent,
        title: 'pages.profile.list',
        data: { breadcrumb: 'generic.actions.list' }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ProfileListRoutingModule {
}
