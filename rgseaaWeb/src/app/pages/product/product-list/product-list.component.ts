import {Component, OnInit} from '@angular/core';
import {FilterService, TulsaQuery} from '@base/shared/filter';
import {BaseListPageComponent} from '@base/shared/pages/list';
import {CrudImplService} from '@libs/crud-api';
import {AuthContextService} from '@libs/security';
import {Observable} from 'rxjs';
import {AppAuthSubject} from "@base/shared/security/auth-subject";
import {Product} from "@libs/sdk/product";
import {ActivatedRoute} from "@angular/router";
import {AppQuery, AppQuerySource} from "@libs/commons";

@Component({
    selector: 'tsw-product-list-page',
    templateUrl: './product-list.component.html',
    styles: [],
})
export class ProductListComponent extends BaseListPageComponent<Product> implements OnInit {

    readonly resourceName = 'products';
    subject$: Observable<AppAuthSubject>;

    protected industryId : string = "";


    constructor(
        crudService: CrudImplService<Product>,
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

        const querySource: AppQuerySource = {
            industryId: this.industryId,
        };

        if(this.industryId!=undefined) {
            this.filter.query = (new TulsaQuery(querySource)) as AppQuery;
        }

        console.log("queryParams INIT="+ JSON.stringify(this.filter.query))
    }

    protected getColumns(): string[] {
        return ['select','reference','name','dv', 'ac','nameMarketing', 'situation', 'dateAnnotated', 'dateUpdate', 'actions'];
    }

}
