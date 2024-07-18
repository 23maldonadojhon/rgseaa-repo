import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {ListPageModule} from '@base/shared/pages/list';
import {NamedRoutesModule} from '@libs/named-routes';
import {ProfileListRoutingModule} from './profile-list-routing.module';
import {ProfileListComponent} from './profile-list.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";


@NgModule({
    imports: [
        ProfileListRoutingModule,
        CommonModule,
        AppCommonsModule,
        ListPageModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        NamedRoutesModule,
        StateToggleModule,
    ],
    declarations: [
        ProfileListComponent
    ],
})
export class ProfileListModule {
}
