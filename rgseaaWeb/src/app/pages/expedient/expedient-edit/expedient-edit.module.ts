import {EditPageBaseComponent} from "@base/shared/pages/edit-page-base.component";
import {Expedient, ExpedientCreate} from "@libs/sdk/expedient";
import {FormGroup} from "@angular/forms";
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ExpedientEditComponent} from "@base/pages/expedient/expedient-edit/expedient-edit.component";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {ExpedientEditRoutingModule} from "@base/pages/expedient/expedient-edit/expedient-edit-routing.module";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatNativeDateModule} from "@angular/material/core";
import {MatTableModule} from "@angular/material/table";
import {MatRadioModule} from "@angular/material/radio";


@NgModule({
    imports: [
        ExpedientEditRoutingModule,
        CommonModule,
        AppCommonsModule,
        EditPageModule,
        MatCheckboxModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatTableModule,
        MatRadioModule
    ],
    declarations: [
        ExpedientEditComponent
    ]
})
export class ExpedientEditModule {
}
