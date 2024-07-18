// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

import {EnvironmentData} from './models';


export const environment: EnvironmentData = {
  name: 'local',
  production: false,
  baseHref: '',
  srv: {
    app: {
      host: 'http://localhost:8082/rest',
      api: '/api',
    },
    auth: {
      host: 'http://localhost:8085/jwtrest',
      api: '/api',
    },
  },
};
