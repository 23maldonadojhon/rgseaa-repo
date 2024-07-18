import {Component, Input} from '@angular/core';

@Component({
  selector: 'tsw-section-label, section[tsw-section-label], div[tsw-section-label]',
  styles: [`:host {
    display: inline-block;
  }`],
  template: `
    <div [ngClass]="[marginClass]">
      <span class="uppercase text-sm text-gray-500">
        {{ label | translate: labelParams }}
      </span>
    </div>
  `
})
export class SectionLabelComponent {
  @Input() label = '';
  @Input() labelParams: Record<string, any> | undefined;

  @Input() marginClass = 'mt-1 mb-4';
}
