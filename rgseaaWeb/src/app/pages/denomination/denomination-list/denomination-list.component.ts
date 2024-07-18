import {BaseListPageComponent} from "@base/shared/pages/list";
import {Component, OnInit} from "@angular/core";
import {CrudImplService} from "@libs/crud-api";
import {FilterService} from "@base/shared/filter";
import {ActivatedRoute} from "@angular/router";
import {AppContextService} from "@base/shared/app-context";
import {ColumnSrc} from "@base/shared/collections";
import {Observable} from "rxjs";
import {DenominationSale} from "@libs/sdk/denomination-sale";

@Component({
    selector: "tsw-auth-industry-list-page",
    templateUrl: "./denomination-list.component.html",
})
export class DenominationListComponent extends BaseListPageComponent<DenominationSale> implements OnInit {

    readonly resourceName: string = "denominationOperations";

    constructor(
        crudService: CrudImplService<DenominationSale>,
        filterService: FilterService,
        route: ActivatedRoute,
        private sampleCtx: AppContextService,
    ) {
        super(crudService, filterService,route);
    }

    protected getColumns(): ColumnSrc[] | Observable<ColumnSrc[]> {
        return ['id', 'name','idKey','fileType','isPublic','actions'];
    }
}
