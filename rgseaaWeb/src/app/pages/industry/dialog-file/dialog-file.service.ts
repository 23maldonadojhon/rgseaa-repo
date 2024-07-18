import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {CrudImplService} from "@libs/crud-api";
import {Document} from "@libs/sdk/document";

@Injectable({
    providedIn: 'root'
})
export class DialogService {

    resourceName = "industriesDocument";

    constructor(
        protected crudService: CrudImplService<Document>
    ) {}

    getDocumentList(id: number): Observable<Document[]> {

        console.log("Industry list="+id)
        return this.crudService.findAny<Document[]>({
            resourceName: this.resourceName,
            queryParams: {
                actionId: id,
            }
        });

    }

}
