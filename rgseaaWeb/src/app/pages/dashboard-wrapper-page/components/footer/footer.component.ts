import {Component} from '@angular/core';
import {aesan, appName, version} from '@base/config/app';


@Component({
  selector: 'tsw-footer, footer[tsw-footer]',
  template: `
    <div>&nbsp;</div>
    <div class="text-center">
      {{ appName }} ({{ version }}) &copy; {{ currentYear }}
      <a [href]="aesan.webUrl" target="_blank" class="font-bold">{{ aesan.shortName }}</a>
    </div>
  `,
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent {
  appName = appName;
  currentYear = new Date().getFullYear();
  aesan = aesan;
  version = version.full;
}
