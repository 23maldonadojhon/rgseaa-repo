import {EnvironmentData} from './models';


export const environment: EnvironmentData = {
    name: 'pre',
    production: false,
    baseHref: '',
    srv: {
        app: {
            host: 'https://rgseaa-web-jee-r01a-iq-vs-1.msc.es/rest',
            api: '/api',
        },
        auth: {
            host: 'https://rgseaa-web-jee-r01a-iq-vs-1.msc.es/jwtrest',
            api: '/api',
        },
    },
};
