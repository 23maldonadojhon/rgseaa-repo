import {Component, OnInit} from "@angular/core";
import {BaseListPageComponent} from "@base/shared/pages/list";
import {Expedient} from "@libs/sdk/expedient";
import {ColumnSrc} from "@base/shared/collections";
import {Observable} from "rxjs";
import {AppAuthSubject} from "@base/shared/security";
import {CrudImplService} from "@libs/crud-api";
import {FilterService} from "@base/shared/filter";
import {AuthContextService} from "@libs/security";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'tsw-expedient-list-page',
    templateUrl: './expedient-list.component.html',
    styles: [],
})
export class ExpedientListComponent extends BaseListPageComponent<Expedient> implements OnInit {

    readonly resourceName: string = 'expedients';
    subject$: Observable<AppAuthSubject>;

    protected industryId : string = "";

    constructor(
        crudService: CrudImplService<Expedient>,
        filterService: FilterService,
        route: ActivatedRoute,
        private authContext: AuthContextService<AppAuthSubject>,
    ) {
        super(crudService, filterService,route);
        this.subject$ = authContext.get();
    }


    override onInit() {
        this.industryId = this.route.snapshot.params['idIndustry'];
        console.log("this.industryId="+this.industryId)
    }

    protected getColumns(): ColumnSrc[] | Observable<ColumnSrc[]> {
        return ['select', 'brand', 'actions'];
    }


}
