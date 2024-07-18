import {Component, OnInit} from '@angular/core';
import {FilterService} from '@base/shared/filter';
import {BaseListPageComponent} from '@base/shared/pages/list';
import {CrudImplService} from '@libs/crud-api';
import {AuthContextService} from '@libs/security';
import {Observable} from 'rxjs';
import {AppAuthSubject} from "@base/shared/security/auth-subject";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'tsw-entity-type-list-page',
    templateUrl: './entity-type-list.component.html',
    styles: [],
})
export class EntityTypeListComponent extends BaseListPageComponent implements OnInit {
    readonly resourceName = 'entityTypes';
    subject$: Observable<AppAuthSubject>;

    constructor(
        crudService: CrudImplService<any, number>,
        filterService: FilterService,
        route: ActivatedRoute,
        private authContext: AuthContextService<AppAuthSubject>,
    ) {
        super(crudService, filterService,route);
        this.subject$ = authContext.get();
    }

    protected getColumns(): string[] {
        return ['select', 'name', 'description', 'actions'];
    }
}
