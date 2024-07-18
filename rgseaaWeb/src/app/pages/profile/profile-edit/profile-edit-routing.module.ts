import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileEditComponent} from './profile-edit.component';

const routes: Routes = [
    {
        path: '',
        component: ProfileEditComponent,
        title: 'pages.profile.edit',
        data: { breadcrumb: 'generic.actions.edit' }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ProfileEditRoutingModule {
}
