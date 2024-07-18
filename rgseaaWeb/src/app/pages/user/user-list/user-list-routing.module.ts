import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UserListComponent} from "@base/pages/user/user-list/user-list.component";


const routes: Routes = [
    {
        path: '',
        component: UserListComponent,
        title: 'pages.user.list',
        data: {breadcrumb: 'generic.actions.list'}
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserListRoutingModule {
}
