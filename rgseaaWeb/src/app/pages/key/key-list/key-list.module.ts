import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {StateToggleModule} from "@base/shared/components/state-toggle";
import {UserListModule} from "@base/pages/user";
import {KeyListComponent} from "@base/pages/key/key-list/key-list.component";
import {KeyListRoutingModule} from "@base/pages/key/key-list/key-list.routing.module";

@NgModule({
    imports : [
        KeyListRoutingModule,
        CommonModule,
        AppCommonsModule,
        ListPageModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSlideToggleModule,
        StateToggleModule,
        UserListModule,
    ],
    declarations : [
        KeyListComponent
    ]
})
export class KeyListModule {

}
