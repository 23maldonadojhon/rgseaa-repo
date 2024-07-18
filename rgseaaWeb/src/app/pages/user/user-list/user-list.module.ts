import {NgModule} from "@angular/core";
import {UserListComponent} from "@base/pages/user/user-list/user-list.component";
import {UserListRoutingModule} from "@base/pages/user/user-list/user-list-routing.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {UserListPageFilterComponent} from "@base/pages/user/components";
import {CommonModule} from "@angular/common";


@NgModule({
    imports: [
        CommonModule,
        UserListRoutingModule,
        AppCommonsModule,
        ListPageModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSlideToggleModule,
        StateToggleModule,
    ],
    exports: [
        UserListPageFilterComponent
    ],
    declarations: [
        UserListComponent,
        UserListPageFilterComponent
    ]
})
export class UserListModule {}
