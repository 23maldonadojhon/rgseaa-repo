import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {TswSelectModule} from '@base/shared/select';
import {NamedRoutesModule} from '@libs/named-routes';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {ProfileEditRoutingModule} from "@base/pages/profile/profile-edit/profile-edit-routing.module";
import {ProfileEditComponent} from "@base/pages/profile/profile-edit/profile-edit.component";

@NgModule({
    imports: [
        ProfileEditRoutingModule,
        CommonModule,
        AppCommonsModule,
        EditPageModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        NamedRoutesModule,
        TswSelectModule,
    ],
    declarations: [
        ProfileEditComponent
    ],
})
export class ProfileEditModule {
}
