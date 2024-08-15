import {NgModule} from "@angular/core";
import {
    AuthIndustryListComponent
} from "@base/pages/autoritation-industry/auth-industry-list/auth-industry-list.component";
import {CommonModule} from "@angular/common";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {StateToggleModule} from "@base/shared/components/state-toggle";
import {
    AuthIndustryListRoutingModule
} from "@base/pages/autoritation-industry/auth-industry-list/auth-industry-list.routing.module";
import {UserListModule} from "@base/pages/user";

@NgModule({
    imports: [
        AuthIndustryListRoutingModule,

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
    declarations: [
        AuthIndustryListComponent
    ]
})
export class AuthIndustryListModule {

}
