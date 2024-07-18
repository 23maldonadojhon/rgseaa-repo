import {MenuItem} from './model';


export const SIDEBAR_ITEMS: MenuItem[] = [
    {
        text: 'pages.home',
        path: 'home',
        icon: 'home',
    },{
        text: 'Gestion de Usuarios',
        icon: 'library_books',
        expanded:false,
        requireAccess: 'RUser',
        children: [
        {
            text: 'Alta de Usuario',
            expanded:false,
            path:'userManagementCreate',
            requireAccess :'WUser'
        },{
            text: 'Lista de Usuarios',
            expanded:false,
            path:'userManagementList'
        }]
    },{
        text: 'Gestion de Perfiles',
        icon: 'library_books',
        expanded:false,
        requireAccess: 'RProfile',
        children: [{
            text: 'Alta de Perfil',
            expanded:false,
            path:'profileManagementCreate'
        },{
            text: 'Lista de Perfiles',
            expanded:false,
            path:'profileManagementList'
        }]
    },{
        text: 'Gestion de Entidades',
        icon: 'library_books',
        expanded:false,
        requireAccess: 'REntity',
        children: [{
            text: 'Alta de Entidades',
            expanded:false,
            path:'entityManagementCreate',
            requireAccess: 'WEntity',
        },{
            text: 'Lista de Entidades',
            expanded:false,
            path:'entityManagementList'
        }]
    },{
        text: 'Gestion de Productos',
        icon: 'library_books',
        expanded:false,
        requireAccess: 'RProduct',
        children: [{
            text: 'Alta de Producto',
            expanded:false,
            path:'productManagementCreate',
            requireAccess :'WProduct'
        },{
            text: 'Lista de Productos',
            expanded:false,
            path:'productManagementList',
        }]
    },{
        text: 'Gestion de Empresas',
        icon: 'library_books',
        expanded:false,
        requireAccess: 'RIndustry',
        children: [{
            text: 'Alta de Empresa',
            expanded:false,
            path:'industryManagementCreate',
            requireAccess :'WIndustry'
        },{
            text: 'Lista de Empresas',
            expanded:false,
            path:'industryManagementList',
        }]
    },{
        text: 'Gestion de Listados',
        icon: 'library_books',
        expanded:false,
        requireAccess: 'RList',
        children: [{
            text: 'Autorizaciones Industria',
            expanded:false,
            path:'authIndustryAdminList',
            requireAccess :'WList'
        },{
            text: 'Claves',
            expanded:false,
            path:'keyAdminList',
            requireAccess :'WList'
        },{
            text: 'Denominación de Venta',
            expanded:false,
            path:'denominationAdminList',
            requireAccess :'WList'
        }]
    }
];
