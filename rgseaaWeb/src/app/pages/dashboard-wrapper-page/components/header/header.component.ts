import {Component} from '@angular/core';
import {aesan, government, ministry} from '@base/config/app';
import {Observable} from "rxjs";
import {AppAuthSubject} from "@base/shared/security";
import {AuthContextService} from "@libs/security";
// import { SampleContextService } from '@tulsa/app/shared/sample/sample-context.services';
// import { TulsaAuthSubject } from '@tulsa/app/shared/security';
// import { TulsaLanguage } from '@libs/sdk/language';
// import { AuthContextService } from '@tulsa/libs/security';

@Component({
  selector: 'tsw-header, nav[tsw-header]',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {

    logos = [government, ministry, aesan];
    readonly subject$: Observable<AppAuthSubject>;

  constructor(
    // public sampleContext: SampleContextService,
    // private crudService: CrudImplService,
    // private translateService: TranslateService,
    private authContext: AuthContextService<AppAuthSubject>,
  ) {
      this.subject$ = authContext.get();
  }

}
