import {Component, OnInit} from "@angular/core";
import {BaseListPageComponent} from "@base/shared/pages/list";
import {ColumnSrc} from "@base/shared/collections";
import {Observable} from "rxjs";
import {AuthIndustry} from "@libs/sdk/AuthIndustry";
import {CrudImplService} from "@libs/crud-api";
import {FilterService} from "@base/shared/filter";
import {ActivatedRoute} from "@angular/router";
import {AppContextService} from "@base/shared/app-context";

@Component({
    selector: "tsw-auth-industry-list-page",
    templateUrl: "./auth-industry-list.component.html",
})
export class AuthIndustryListComponent extends BaseListPageComponent<AuthIndustry> implements OnInit{

    readonly resourceName: string = "authIndustry";

    constructor(
        crudService: CrudImplService<AuthIndustry>,
        filterService: FilterService,
        route: ActivatedRoute,
        private sampleCtx: AppContextService,
    ) {
        super(crudService, filterService,route);
    }

    protected getColumns(): ColumnSrc[] | Observable<ColumnSrc[]> {
        return ['id', 'name', 'actions'];
    }



}
