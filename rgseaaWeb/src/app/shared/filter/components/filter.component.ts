import {Directive, EventEmitter, OnDestroy, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {SearchMode} from '@base/shared/filter';
import {AppQuerySource, ControlsOf} from '@libs/commons';
import {firstValueFrom, ReplaySubject} from 'rxjs';
import {FilterService} from '../filter.service';
import {ActivatedRoute} from "@angular/router";


@Directive()
export abstract class FilterComponent<T extends AppQuerySource = AppQuerySource> implements OnInit, OnDestroy {

  @Output() filter = new EventEmitter<void>();

  abstract readonly resourceName: string;
  readonly searchMode: SearchMode = SearchMode.FILTER;
  public form: FormGroup<ControlsOf<T>>;

  protected destroyed$ = new ReplaySubject<boolean>(1);

  constructor(
    protected filterService: FilterService,
    protected fb: FormBuilder,
    protected route: ActivatedRoute,
  ) {
    this.form = this.buildQueryForm();
  }

  async ngOnInit() {
    await this.loadData();
  }

  ngOnDestroy(): void {
    this.destroyed$.next(true);
  }


  protected abstract moreData() : void;

  search() {

      this.moreData();

    this.filterService.set({
      name: this.resourceName,
      mode: this.searchMode,
      source: this.getQuerySource(),
      useParams: { handling: '' }
    });
  }

  clear() {
    this.form.reset();
    this.filterService.clear();
  }

  protected getQuerySource(): T {

      let industryId = "10";
      console.log("FILTER industryId="+industryId)

      // @ts-ignore
      this.form.get("industryId")?.setValue(industryId);

      console.log("VALORES ="+JSON.stringify(this.form.getRawValue(), null, 2));
    const obj: any = this.form.getRawValue();
    return { ...obj };
  }

  protected updateSource(value: T | AppQuerySource) {
    const obj = this.form.getRawValue();
    const sourceKeys = Object.keys(obj);
    const sourceUpdate = { ...obj } as AppQuerySource;
    Object.entries(value).forEach(([key, value]) => {
      if (sourceKeys.includes(key)) {
        sourceUpdate[key] = value || undefined;
      }
    });
    const update = { ...sourceUpdate } as any;
    this.form.patchValue(update, { emitEvent: false });
  }

  private async loadData() {
    try {
      const external = await firstValueFrom(this.filterService.get(this.resourceName));
      this.updateSource(external.query.getSource());
    } catch (e) {
      this.form.reset();
    }
  }

  protected abstract buildQueryForm(): FormGroup;
}
