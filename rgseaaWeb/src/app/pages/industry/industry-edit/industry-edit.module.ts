import {NgModule} from "@angular/core";
import {IndustryEditComponent} from "@base/pages/industry/industry-edit/industry-edit.component";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {CommonModule} from "@angular/common";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {IndustryEditRoutingModule} from "@base/pages/industry/industry-edit/industry-edit-routing.module";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatTableModule} from "@angular/material/table";
import {MatNativeDateModule} from "@angular/material/core";

@NgModule({
    imports: [
        IndustryEditRoutingModule,
        CommonModule,
        AppCommonsModule,
        EditPageModule,
        MatCheckboxModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatTableModule
    ],
    declarations : [
        IndustryEditComponent
    ]
})
export class IndustryEditModule {
}
