import {ACLCheckMode} from './models';

export abstract class AuthSubject<T> {
  protected constructor(private readonly details: T) {
  }

  getDetails(): T {
    return this.details;
  }

  hasRole(roles: string[] | string, check: ACLCheckMode = 'ALL'): boolean {
    const checkList = Array.isArray(roles) ? roles : [roles];
    switch (check) {
      case 'ALL':
        return checkList.every(r => this.getRoles().includes(r));
      default:
        return checkList.some(r => this.getRoles().includes(r));
    }
  }

  abstract isAuthenticated(): boolean;

  abstract getRoles(): string[];

  abstract getProfile(): string;

  abstract equals(value: unknown): boolean;

}

export class UnauthenticatedSubject extends AuthSubject<Record<string, unknown>> {
  constructor() {
    super({});
  }

  isAuthenticated() {
    return false;
  }

  getRoles(): string[] {
    return [];
  }

  getProfile(): string {
    return "";
  }

  getSurnames(): string {
    return "";
  }

  equals(): boolean {
    return false;
  }
}
