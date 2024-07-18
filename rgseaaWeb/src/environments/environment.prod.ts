export const environment = {
  name: 'local',
  production: true,
  baseHref: './',
  srv: {
    app: {
      host: 'http://localhost:8082',
      api: '/api/v1',
    },
    auth: {
      host: 'http://localhost:9090/tulsajwtrest',
      api: '/api/v1',
    },
  },
};
