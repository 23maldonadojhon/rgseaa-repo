import {Version} from '@angular/core';
import {environment} from '@env';

const getVersion = () => {
  let version = '0.0.0';
  if (environment.name) {
    version += '-' + environment.name;
  }
  return version;
};

export const appName = 'RGSEAA';

export const version = new Version(getVersion());

export const isDevEnvironment = !environment.production;

export const government = {
  name: 'Gobierno de España',
  web: 'https://www.lamoncloa.gob.es',
  icon: './assets/images/logos/logo-gob-esp.png',
    fullName: 'Gobierno de España',
    webUrl: 'https://www.lamoncloa.gob.es',
    iconColor: './assets/images/logos/logo-gob-esp.png',
    iconPositive: '',
    iconNegative: '',
};

export const aesan = {
  name: 'Agencia española de seguridad alimentaria y nutrición',
  shortName: 'AESAN',
  web: 'https://www.aesan.gob.es/AECOSAN/web/home/aecosan_inicio.htm',
  icon: './assets/images/logos/logo-aesan.jpg',
    fullName: 'Agencia española de seguridad alimentaria y nutrición',
    webUrl: 'https://www.aesan.gob.es/AECOSAN/web/home/aecosan_inicio.htm',
    iconColor: './assets/images/logos/logo_aesan_color.svg',
    iconPositive: './assets/images/logos/logo_aesan_positive.svg',
    iconNegative: './assets/images/logos/logo_aesan_negative.svg',
};

export const ministry = {
  name: 'Ministerio de Consumo',
  web: 'https://www.consumo.gob.es/',
  icon: './assets/images/logos/logo-consumo.png',
    fullName: 'Ministerio de Consumo',
    webUrl: 'https://www.consumo.gob.es/',
    iconColor: './assets/images/logos/logo-consumo.png',
    iconPositive: '',
    iconNegative: '',
};


export const PRTR = {
    fullName: 'Plan de Recuperación, Transformación y Resiliencia',
    shortName: 'PRTR',
    webUrl: 'https://planderecuperacion.gob.es/',
    iconColor: './assets/images/logos/logo_prtr_color.png',
    iconPositive: './assets/images/logos/logo_prtr_negative.png',
    iconNegative: './assets/images/logos/logo_prtr_positive.png',
};
export const appOrigin = window.location.origin + environment.baseHref;

const { auth, app } = environment.srv;
export const appAppAPI = {
  srvPath: app.host,
  apiPath: app.host + app.api,
};

export const appAuthAPI = {
  srvPath: auth.host,
  apiPath: auth.host + auth.api,
};
