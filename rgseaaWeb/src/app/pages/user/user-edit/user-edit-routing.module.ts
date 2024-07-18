import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UserEditComponent} from "@base/pages/user/user-edit/user-edit.component";


const routes: Routes = [
    {
        path: '',
        component: UserEditComponent,
        title: 'pages.user.edit',
        data: {breadcrumb: 'generic.actions.edit'}
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserEditRoutingModule {
}
