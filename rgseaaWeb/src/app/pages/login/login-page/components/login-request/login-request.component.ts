import {Component, OnDestroy} from '@angular/core';
import {isDevEnvironment} from '@base/config/app';
import {HiddenFormData} from '@base/shared/components/form';
import {ComponentStatus} from '@libs/commons';
import {Observable, ReplaySubject} from 'rxjs';
import {AuthProcessState} from "@base/shared/security/models";
import {AuthManagerService} from "@base/shared/security/auth-manager.service";


@Component({
  selector: 'tsw-login-request',
  templateUrl: './login-request.component.html',
})
export class LoginRequestComponent implements OnDestroy {

  readonly status: ComponentStatus<AuthProcessState>;
  readonly processMessage$: Observable<string>;

  authForm: HiddenFormData | undefined;

  // Elementos necesarios solamente para el entorno de desarrollo
  // para saltarse clave
  isDevEnvironment = isDevEnvironment;
  fakeLogin = false;
  gcForm: HiddenFormData | undefined;

  private readonly destroyed$ = new ReplaySubject<boolean>(1);

  constructor(private authManager: AuthManagerService) {
    this.status = authManager.processStatus;
    this.processMessage$ = authManager.processMessage$;
  }

  ngOnDestroy(): void {
    this.destroyed$.next(true);
  }

  async requestLogin() {
    try {
      this.authForm = await this.authManager.requestSignIn();
    } catch (e) {
      // ignored
    }
  }

  // Gracias cl@ve
  // Eliminar al poner en producción

  async doFakeLogin(nif: string, pass: string) {
    try {
      await this.authManager.fakeLogin(nif, pass);
    } catch (e) {
      this.fakeLogin = false;
    }
  }

}
