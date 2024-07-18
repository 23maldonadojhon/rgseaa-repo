import {NgModule} from "@angular/core";
import {IndustryListComponent} from "@base/pages/industry/industry-list/industry-list.component";
import {IndustryListRoutingModule} from "@base/pages/industry/industry-list/industry-list-routing.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {CommonModule} from "@angular/common";
import {IndustryListFilterComponent} from "@base/pages/industry/industry-list-filter";
import {MatInputModule} from "@angular/material/input";

@NgModule({
    imports: [
        CommonModule,
        IndustryListRoutingModule,
        ListPageModule,
        AppCommonsModule,
        MatInputModule,
    ],
    exports : [],
    declarations : [
        IndustryListComponent,
        IndustryListFilterComponent,
    ]
})
export class IndustryListModule {

}
