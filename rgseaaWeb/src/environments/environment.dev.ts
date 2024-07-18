import {EnvironmentData} from './models';


export const environment: EnvironmentData = {
    name: 'dev',
    production: false,
    baseHref: '',
    //baseHref: '/rgseaa',
    srv: {
        app: {
            //host: 'https://rgseaa-web-jee-r01a-id-vs-1.msc.es/rest',
            //host: 'https://rgseaa-web-jee-r01a-iq-vs-1.msc.es/rest',
            host: 'http://localhost:8082/rest',
            //host: 'http://localhost:7001/rest',
            api: '/api',
        },
        auth: {
            //host: 'https://rgseaa-web-jee-r01a-id-vs-1.msc.es/jwtrest',
            //host: 'https://rgseaa-web-jee-r01a-iq-vs-1.msc.es/jwtrest',
            host: 'http://localhost:8085/jwtrest',
            //host: 'http://localhost:7001/jwtrest',
            api: '/api',
        },
    },
};
