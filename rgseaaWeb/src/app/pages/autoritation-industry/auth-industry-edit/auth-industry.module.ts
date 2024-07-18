import {NgModule} from "@angular/core";
import {AuthIndustryEditComponent} from "@base/pages/autoritation-industry/auth-industry-edit/auth-industry-edit.component";
import {CommonModule} from "@angular/common";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {NamedRoutesModule} from "@libs/named-routes";
import {TswSelectModule} from "@base/shared/select";
import {
    AuthIndustryRoutingModule
} from "@base/pages/autoritation-industry/auth-industry-edit/auth-industry.routing.module";

@NgModule({
    imports : [
        AuthIndustryRoutingModule,

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
        AuthIndustryEditComponent
    ]
})
export class AuthIndustryModule {
}
