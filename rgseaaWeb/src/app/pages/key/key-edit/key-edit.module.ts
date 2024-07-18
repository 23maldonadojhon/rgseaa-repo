import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {NamedRoutesModule} from "@libs/named-routes";
import {TswSelectModule} from "@base/shared/select";
import {KeyEditComponent} from "@base/pages/key/key-edit/key-edit.component";
import {KeyEditRoutingModule} from "@base/pages/key/key-edit/key-edit.routing.module";

@NgModule({
    imports : [
        KeyEditRoutingModule,

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
        KeyEditComponent
    ]
})
export class KeyEditModule {
}
