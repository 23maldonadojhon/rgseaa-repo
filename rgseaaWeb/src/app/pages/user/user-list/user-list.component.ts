import {Component, OnInit} from "@angular/core";
import {firstValueFrom, skip, takeUntil} from "rxjs";
import {BaseListPageComponent} from "@base/shared/pages/list";
import {CrudImplService, RequestConfig} from "@libs/crud-api";
import {FilterService} from "@base/shared/filter";
import {AppContextService} from "@base/shared/app-context";
import {User} from "@libs/sdk/user";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'user-list',
    templateUrl: './user-list.component.html',
    styleUrls: ['./user-list.component.scss'],
})
export class UserListComponent extends BaseListPageComponent<User> implements OnInit{

    readonly resourceName = 'users';

    constructor(
        crudService: CrudImplService<User>,
        filterService: FilterService,
        route: ActivatedRoute,
        private sampleCtx: AppContextService,
    ) {
        super(crudService, filterService,route);
    }

    override async ngOnInit() {
        await super.ngOnInit();
        // this.monitorCtxChanges();
    }

    protected override async getRequestConfig(): Promise<RequestConfig> {
        const config = await super.getRequestConfig();
        const scope = (await firstValueFrom(this.sampleCtx.scope$)).scopeCode;
        console.log(this.sampleCtx.scope$);

        config.queryParams = {
            ...config.queryParams,
            scope,
        };
        return config;
    }

    protected getColumns(): string[] {
        return ['select', 'name', 'surnames', 'phone', 'email', 'profiles', 'actions'];
    }

    private monitorCtxChanges() {
        this.sampleCtx.scope$.pipe(takeUntil(this.destroyed$), skip(1)).subscribe(() => this.reloadData());
    }

}
