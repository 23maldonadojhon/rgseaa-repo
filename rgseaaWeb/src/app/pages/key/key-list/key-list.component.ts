import {BaseListPageComponent} from "@base/shared/pages/list";
import {Key} from "@libs/sdk/key";
import {Component, OnInit} from "@angular/core";
import {CrudImplService} from "@libs/crud-api";
import {AuthIndustry} from "@libs/sdk/AuthIndustry";
import {FilterService} from "@base/shared/filter";
import {ActivatedRoute} from "@angular/router";
import {AppContextService} from "@base/shared/app-context";
import {ColumnSrc} from "@base/shared/collections";
import {Observable} from "rxjs";

@Component({
    selector: "tsw-auth-industry-list-page",
    templateUrl: "./key-list.component.html",
})
export class KeyListComponent extends BaseListPageComponent<Key> implements OnInit {

    readonly resourceName: string = "keysOperations";

    constructor(
        crudService: CrudImplService<Key>,
        filterService: FilterService,
        route: ActivatedRoute,
        private sampleCtx: AppContextService,
    ) {
        super(crudService, filterService,route);
    }

    protected getColumns(): ColumnSrc[] | Observable<ColumnSrc[]> {
        return ['id', 'name','allowProduct','public','actions'];
    }
}
