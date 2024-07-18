import {Component, OnInit} from "@angular/core";
import {BaseListPageComponent} from "@base/shared/pages/list";
import {Industry} from "@libs/sdk/industry";
import {Observable} from "rxjs";
import {AppAuthSubject} from "@base/shared/security";
import {CrudImplService} from "@libs/crud-api";
import {FilterService} from "@base/shared/filter";
import {AuthContextService} from "@libs/security";
import {ColumnSrc} from "@base/shared/collections";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'tsw-industry-list-page',
    templateUrl: './industry-list.component.html',
    styles: [],
})
export class IndustryListComponent extends BaseListPageComponent<Industry> implements OnInit {

    readonly resourceName = 'industries';
    subject$: Observable<AppAuthSubject>;

    constructor(
        crudService: CrudImplService<Industry>,
        filterService: FilterService,
        route: ActivatedRoute,
        private authContext: AuthContextService<AppAuthSubject>,
    ) {
        super(crudService, filterService,route);
        this.subject$ = authContext.get();
    }

    protected getColumns(): ColumnSrc[] | Observable<ColumnSrc[]> {
        return ['rgseaanue','rgseaa','name','situation','actions'];
    }
}
