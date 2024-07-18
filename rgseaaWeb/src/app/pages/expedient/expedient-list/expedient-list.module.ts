import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ExpedientListRoutingModule} from "@base/pages/expedient/expedient-list/expedient-list-routing.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {MatInputModule} from "@angular/material/input";
import {ExpedientListComponent} from "@base/pages/expedient/expedient-list/expedient-list.component";

@NgModule({
    imports: [
        CommonModule,
        ExpedientListRoutingModule,
        ListPageModule,
        AppCommonsModule,
        MatInputModule,
    ],
    exports : [],
    declarations : [
        ExpedientListComponent
    ]
})
export class ExpedientListModule {

}
