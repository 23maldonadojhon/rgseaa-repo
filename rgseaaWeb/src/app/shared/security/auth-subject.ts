import {AuthUserDetails} from '@libs/sdk/auth';
import {AuthSubject} from '@libs/security';


export class AppAuthSubject extends AuthSubject<AuthUserDetails> {

  constructor(details: AuthUserDetails) {
    super(details);
  }

  equals(value: AuthUserDetails | string | number | null | undefined): boolean {
    if (value == null) return false;

    const { userId, docNum } = this.getDetails();

    if (typeof value === 'number') {
      return userId === value;
    } else if (typeof value === 'string') {
      return [docNum].includes(value);
    }

    return value.userId === userId
      || value.docNum === docNum;
  }

  getRoles(): string[] {
    return this.getDetails().roles || [];
  }

  getProfile(): string {
    return this.getDetails().profile || "";
  }

  isAuthenticated(): boolean {
    return !!this.getDetails();
  }
}
