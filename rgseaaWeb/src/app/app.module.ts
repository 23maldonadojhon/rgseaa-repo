import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {routes} from './pages/routes';
import {NamedRoutesConfig} from "@base/config/named-routes.config";
import {ConfirmationModule} from "@base/shared/confirmation";
import {NotificationModule} from "@base/shared/notification";
import {LocaleConfig} from "@base/config/locale.config";
import {TranslateConfig} from "@base/config/translate.config";
import {TitleConfig} from "@base/config/title.config";
import {FormConfig} from "@base/config/form.config";
import {CrudApiConfig} from "@base/config/crud-api.config";
import {AuthorizationConfig} from "@base/config/authorization.config";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
      BrowserAnimationsModule,
      AuthorizationConfig,
      RouterModule.forRoot(routes, {initialNavigation: 'enabledNonBlocking'}),
      NamedRoutesConfig,
      HttpClientModule,
      CrudApiConfig,
      TranslateConfig,
      TitleConfig,
      ConfirmationModule.forRoot(),
      NotificationModule.forRoot(),
      FormConfig,
      LocaleConfig,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
