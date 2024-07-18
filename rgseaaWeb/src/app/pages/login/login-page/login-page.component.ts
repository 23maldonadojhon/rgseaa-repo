import {Component, OnInit} from '@angular/core';
import {aesan, appName, government, ministry, version} from '@base/config/app';
import {ComponentStatus} from '@libs/commons';
import {AuthProcessState} from "@base/shared/security/models";
import {AuthManagerService} from "@base/shared/security/auth-manager.service";


@Component({
  selector: 'tsw-login-page',
  templateUrl: './login-page.component.html',
  styles: [`
    .footer {
      background-color: var(--footer-bg);
      color: var(--footer-color);
    }
  `],
})
export class LoginPageComponent implements OnInit {

  readonly currentYear = new Date().getFullYear();
  readonly organizations = [government, ministry];
  readonly aesan = aesan;
  readonly version = version.full;
  readonly appName = appName;

  readonly status: ComponentStatus<AuthProcessState>;

  constructor(private authManager: AuthManagerService) {
    this.status = authManager.processStatus;
  }

  ngOnInit(): void {
    this.authManager.initProcess();
  }

}
