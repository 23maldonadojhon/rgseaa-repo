import {Component, OnInit} from '@angular/core';
import {FilterService} from '@base/shared/filter';
import {BaseListPageComponent} from '@base/shared/pages/list';
import {CrudImplService} from '@libs/crud-api';
import {AuthContextService} from '@libs/security';
import {Observable} from 'rxjs';
import {AppAuthSubject} from "@base/shared/security/auth-subject";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'tsw-profile-list-page',
    templateUrl: './profile-list.component.html',
})
export class ProfileListComponent extends BaseListPageComponent implements OnInit {

    readonly resourceName = 'profiles';

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

    protected getColumns() {
        return ['select', 'element', 'actions'];
    }

}
