import {Dialog} from "@angular/cdk/dialog";
import {Component, Inject, OnInit} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogModule} from "@angular/material/dialog";
import {MatCardModule} from "@angular/material/card";
import {IndustryList} from "@libs/sdk/industry";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {NamedRoutesModule} from "@libs/named-routes";
import {RouterLinkWithHref} from "@angular/router";


@Component({
    selector: 'dialog-find-industry',
    templateUrl: './dialog-find.component.html',
    standalone: true,
    imports: [
        MatDialogModule,
        MatCardModule,
        MatTableModule,
        MatButtonModule,
        MatIconModule,
        NamedRoutesModule,
        RouterLinkWithHref
    ]
})
export class DialogFindComponent implements OnInit {

    protected dataList : IndustryList[] = []
    protected displayedColumns: string[] = ['format', 'name', 'nue', 'situation', 'action'];

    constructor(
        @Inject(MAT_DIALOG_DATA) public data: any
    ) {
    }

    ngOnInit() {
        this.dataList = this.data.response;
        console.log(this.dataList);
    }

}
