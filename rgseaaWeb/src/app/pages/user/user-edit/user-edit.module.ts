import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {MatDialogModule} from '@angular/material/dialog';
import {TableModule} from '@base/shared/components/table';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from '@base/shared/pages/edit-page.module';


import {UserEditComponent} from "@base/pages/user/user-edit/user-edit.component";
import {UserEditRoutingModule} from "@base/pages/user/user-edit/user-edit-routing.module";
import {
    UserEditScopeFormComponent
} from "@base/pages/user/components/user-edit-scope-form/user-edit-scope-form.component";
import {
    UserEditScopeListComponent
} from "@base/pages/user/components/user-edit-scope-list/user-edit-scope-list.component";
import {StateToggleModule} from "@base/shared/components/state-toggle";


@NgModule({
    imports: [
        CommonModule,
        UserEditRoutingModule,
        AppCommonsModule,
        EditPageModule,
        TableModule,
        MatDialogModule,
        StateToggleModule,
    ],
    declarations: [
        UserEditComponent,
        UserEditScopeFormComponent,
        UserEditScopeListComponent
    ],
})
export class UserEditModule {
}
