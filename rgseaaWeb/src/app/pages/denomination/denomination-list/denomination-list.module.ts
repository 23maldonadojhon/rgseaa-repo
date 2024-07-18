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
import {
    DenominationListRoutingModule
} from "@base/pages/denomination/denomination-list/denomination-list.routing.module";
import {DenominationListComponent} from "@base/pages/denomination/denomination-list/denomination-list.component";

@NgModule({
    imports : [
        DenominationListRoutingModule,
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
        DenominationListComponent
    ]
})
export class DenominationListModule {

}
