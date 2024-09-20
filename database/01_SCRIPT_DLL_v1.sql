create sequence SEQ_CATEGORIES START WITH 1 INCREMENT BY 1
/

create sequence SEQ_SUB_ACTIVITIES START WITH 10 INCREMENT BY 1
/

create sequence SEQ_ACTIVITIES START WITH 1 INCREMENT BY 1
/

create sequence SEQ_ACTIVITIES_KEYS_CATEGORIES START WITH 1 INCREMENT BY 1
/
create sequence SEQ_KEYS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_ACTIVITIES_KEYS START WITH 1 INCREMENT BY 1
/

create sequence SEQ_SITUATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_COUNTRIES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_CCAA START WITH 100 INCREMENT BY 1
/

create sequence SEQ_PROVINCES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_LOCATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_INDUSTRIES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_ESTABLISHMENTS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_RGSEAA START WITH 100 INCREMENT BY 1
/

create sequence SEQ_RGSEAA_ACTIVITIES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_PERMISSIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_PROFILES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_PROFILES_PERMISSIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_USERS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_USERS_MODULES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_USERS_PROFILES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_USERS_ENTITIES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_TYPES_ACTUATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_COMPANIES_ACTUATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_ACTIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_TYPES_DOCUMENTS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_DOCUMENTS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_TYPES_CHANGES_EXPEDIENTS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_DENOMINATION_SALES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_ENTITIES_TYPES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_ENTITIES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_MODULES_TYPES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_MODULES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_FORM_PRESENTATION START WITH 100 INCREMENT BY 1
/

create sequence SEQ_AUTHORIZATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_FEES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_RGSEAA_FEES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_COMPETENT_AUTHORITIES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_COMPANIES_AUTHORIZATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_RGSEAA_AUTHORIZATIONS START WITH 100 INCREMENT BY 1
/

create sequence SEQ_SEQ_SUBSTANCES START WITH 100 INCREMENT BY 1
/

create sequence SEQ_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES START WITH 1 INCREMENT BY 1;


create table USERS
(
    ID             NUMBER(12) default "SEQ_USERS"."NEXTVAL" not null
        constraint PK_USERS__ID
            primary key,
    NIF            VARCHAR2(9 char)
        constraint UK_USERS__NIF
            unique,
    NAME           VARCHAR2(255 char),
    FIRST_SURNAME  VARCHAR2(255 char),
    SECOND_SURNAME VARCHAR2(255 char),
    EMAIL          VARCHAR2(255 char),
    PHONE          VARCHAR2(255 char),
    CREATED_AT     TIMESTAMP(6),
    CREATED_BY     NUMBER(32),
    UPDATED_AT     TIMESTAMP(6),
    UPDATED_BY     NUMBER(32),
    STATE          NUMBER(1)  default 1                              not null
)
/

create table AUTHORIZATIONS
(
    ID         NUMBER(12) default "SEQ_AUTHORIZATIONS"."NEXTVAL" not null
        constraint PK_AUTHORIZATIONS__ID
            primary key,
    NAME       VARCHAR2(200)                                              not null,
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                       not null
)
/

create table PERMISSIONS
(
    ID          NUMBER(12) default "SEQ_PERMISSIONS"."NEXTVAL" not null
        constraint PK_PERMISSIONS__ID
            primary key,
    CODE        VARCHAR2(100 char),
    DESCRIPTION VARCHAR2(100 char),
    NAME        VARCHAR2(50 char)                                       not null,
    CREATED_AT  TIMESTAMP(6),
    CREATED_BY  NUMBER(32),
    UPDATED_AT  TIMESTAMP(6),
    UPDATED_BY  NUMBER(32),
    STATE       NUMBER(1)  default 1                                    not null
)
/

create table PROFILES
(
    ID         NUMBER(12) default "SEQ_PROFILES"."NEXTVAL" not null
        constraint PK_PROFILES__ID
            primary key,
    NAME       VARCHAR2(255 char)                                   not null,
    CREATED_AT TIMESTAMP(6),
    CREATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    STATE      NUMBER(1)  default 1                                 not null
)
/

create table PROFILES_PERMISSIONS
(
    ID            NUMBER(12) default "SEQ_PROFILES_PERMISSIONS"."NEXTVAL" not null
        constraint PK_PROFILES_PERMISSIONS__ID
            primary key,
    PERMISSION_ID NUMBER(32)                                                       not null
        constraint FK_PROFILES_PERMISSIONS__PERMISSION_ID
            references PERMISSIONS,
    PROFILE_ID    NUMBER(32)                                                       not null
        constraint FK_PROFILES_PERMISSIONS__PROFILE_ID
            references PROFILES,
    CREATED_AT    TIMESTAMP(6),
    CREATED_BY    NUMBER(32),
    UPDATED_AT    TIMESTAMP(6),
    UPDATED_BY    NUMBER(32),
    STATE         NUMBER(1)  default 1                                             not null,
    constraint UK_PROFILES_PERMISSIONS__PERMISSION_ID__PROFILE_ID_UNIQUE
        unique (PERMISSION_ID, PROFILE_ID)
)
/

create table ENTITIES_TYPES
(
    ID          NUMBER(12) default "SEQ_ENTITIES_TYPES"."NEXTVAL" not null
        constraint PK_ENTITIES_TYPES__ID
            primary key,
    DESCRIPTION VARCHAR2(255 char),
    NAME        VARCHAR2(255 char)                                         not null,
    CREATED_AT  TIMESTAMP(6),
    CREATED_BY  NUMBER(32),
    UPDATED_AT  TIMESTAMP(6),
    UPDATED_BY  NUMBER(32),
    STATE       NUMBER(1)  default 1                                       not null
)
/

create table ENTITIES
(
    ID             NUMBER(12) default "SEQ_ENTITIES"."NEXTVAL" not null
        constraint PK_ENTITIES__ID
            primary key,
    NAME           VARCHAR2(100 char)                                   not null,
    DESCRIPTION    VARCHAR2(100 char)                                   not null,
    CODE           VARCHAR2(6 char)                                     not null
        constraint UK_ENTITIES__CODE
            unique,
    TYPE_ID        NUMBER(32)                                           not null
        constraint FK_ENTITIES__ID_TYPE
            references ENTITIES_TYPES,
    ADDRESS        VARCHAR2(255 char),
    CONTACT_PERSON VARCHAR2(255 char),
    EMAIL          VARCHAR2(255 char),
    PHONE          VARCHAR2(255 char),
    POSTAL_CODE    VARCHAR2(255 char),
    ROOT_ENTITY    NUMBER(1),
    CREATED_AT     TIMESTAMP(6),
    CREATED_BY     NUMBER(32),
    UPDATED_AT     TIMESTAMP(6),
    UPDATED_BY     NUMBER(32),
    STATE          NUMBER(1)  default 1                                 not null
)
/

create table USERS_ENTITIES
(
    ID         NUMBER(12) default "SEQ_USERS_ENTITIES"."NEXTVAL" not null
        constraint PK_USERS_ENTITIES__ID
            primary key,
    ENTITY_ID  NUMBER(12)                                                 not null
        constraint FK_USERS_ENTITIES__ENTITY_ID
            references ENTITIES,
    USER_ID    NUMBER(12)                                                 not null
        constraint FK_USERS_ENTITIES__USER_ID
            references USERS,
    SCOPE_CODE VARCHAR2(20 char)                                          not null,
    STATE      NUMBER(1)  default 1                                       not null,
    constraint UK_USERS_ENTITIES__ENTITY_ID__USER_ID_UNIQUE
        unique (ENTITY_ID, USER_ID)
)
/

create table MODULES_TYPES
(
    ID          NUMBER(12) default "SEQ_MODULES_TYPES"."NEXTVAL" not null
        constraint PK_MODULES_TYPES__ID
            primary key,
    NAME        VARCHAR2(100),
    DESCRIPTION VARCHAR2(200),
    CREATED_AT  TIMESTAMP(6),
    CREATED_BY  NUMBER(32),
    UPDATED_AT  TIMESTAMP(6),
    UPDATED_BY  NUMBER(32),
    STATE       NUMBER(1)  default 1                                      not null
)
/

create table MODULES
(
    ID         NUMBER(12) default "SEQ_MODULES"."NEXTVAL" not null
        constraint PK_MODULES__ID
            primary key,
    CODE       VARCHAR2(6 char)                                    not null
        constraint UK_MODULES__CODE
            unique,
    NAME       VARCHAR2(100),
    TYPE_ID    NUMBER(12)
        constraint FK_MODULES__ID_TYPE
            references MODULES_TYPES,
    CREATED_AT TIMESTAMP(6),
    CREATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    STATE      NUMBER(1)  default 1                                not null
)
/

create table USERS_MODULES
(
    ID         NUMBER(12) default "SEQ_USERS_MODULES"."NEXTVAL" not null
        constraint PK_USERS_MODULES_ID
            primary key,
    MODULE_ID  NUMBER(12)
        constraint FK_USERS_MODULES__MODULE_ID
            references MODULES,
    USER_ID    NUMBER(12)
        constraint FK_USERS_MODULES__USER_ID
            references USERS,
    CREATED_AT TIMESTAMP(6),
    CREATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    STATE      NUMBER(1)  default 1                                      not null,
    constraint UK_USERS_MODULES__MODULE_ID__USER_ID_UNIQUE
        unique (MODULE_ID, USER_ID)
)
/

create table USERS_PROFILES
(
    ID         NUMBER(12) default "SEQ_USERS_PROFILES"."NEXTVAL" not null
        constraint PK_USERS_PROFILES_ID
            primary key,
    PROFILE_ID NUMBER(12)
        constraint FK_USERS_PROFILES__PROFILE_ID
            references PROFILES,
    USER_ID    NUMBER(12)
        constraint FK_USERS_PROFILES__USER_ID
            references USERS,
    CREATED_AT TIMESTAMP(6),
    CREATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(12),
    STATE      NUMBER(1)  default 1                                       not null,
    constraint UK_USERS_PROFILES__PROFILE_ID__USER_ID_UNIQUE
        unique (PROFILE_ID, USER_ID)
)
/

create table COUNTRIES
(
    ID         NUMBER(32) default "SEQ_COUNTRIES"."NEXTVAL" not null
        constraint PK_COUNTRIES__ID
            primary key,
    NAME       VARCHAR2(50),
    ENROLLMENT VARCHAR2(3),
    NO_DELETE  NUMBER,
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                  not null
)
/

create table CCAA
(
    ID         NUMBER(32) default "SEQ_CCAA"."NEXTVAL" not null
        constraint PK_CCAA__ID
            primary key,
    NAME       VARCHAR2(50),
    ENROLLMENT VARCHAR2(3),
    COUNTRY_ID NUMBER(32)                                       not null
        constraint FK_CCAA__COUNTRY_ID
            references COUNTRIES,
    NO_DELETE  NUMBER,
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                             not null
)
/

create table PROVINCES
(
    ID              NUMBER(12) default "SEQ_PROVINCES"."NEXTVAL" not null
        constraint PK_PROVINCES__ID
            primary key,
    NAME            VARCHAR2(30),
    ENROLLMENT      VARCHAR2(3),
    PRE_POSTAL_CODE NUMBER(2),
    ADDRESS         VARCHAR2(500),
    CCAA_ID         NUMBER(12)
        constraint FK_PROVINCES__CCAA_ID
            references CCAA,
    CREATED_AT      TIMESTAMP(6),
    CREATED_BY      NUMBER(32),
    UPDATED_AT      TIMESTAMP(6),
    UPDATED_BY      NUMBER(32),
    STATE           NUMBER(1)  default 1                                  not null
)
/

create table LOCATIONS
(
    ID                NUMBER(12) default "SEQ_LOCATIONS"."NEXTVAL" not null
        constraint PK_LOCATIONS__ID
            primary key,
    NAME              VARCHAR2(200),
    DESCRIPTION_PADRE VARCHAR2(200),
    COMBO             NUMBER,
    PROVINCE_ID       NUMBER(12)
        constraint FK_LOCATIONS__PROVINCE_ID
            references PROVINCES,
    PADRE_ID          NUMBER(12),
    INE_CODE          VARCHAR2(12),
    CREATED_AT        TIMESTAMP(6),
    CREATED_BY        NUMBER(32),
    UPDATED_AT        TIMESTAMP(6),
    UPDATED_BY        NUMBER(32),
    STATE             NUMBER(1)  default 1                                  not null
)
/

create table COMPETENT_AUTHORITIES
(
    ID         NUMBER(12) default "SEQ_COMPETENT_AUTHORITIES"."NEXTVAL" not null
        constraint PK_COMPETENT_AUTHORITIES__ID
            primary key,
    CODE       VARCHAR2(10),
    NAME       VARCHAR2(50),
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                              not null
)
/

create table SITUATIONS
(
    ID                    NUMBER(12) default "SEQ_SITUATIONS"."NEXTVAL" not null
        constraint PK_SITUATION__ID
            primary key,
    CODE                  VARCHAR2(3),
    NAME                  VARCHAR2(50),
    TYPE_INDUSTRY_PRODUCT NUMBER(1),
    VISIBLE_RGSA          NUMBER     default 1,
    VISIBLE_UE            NUMBER     default 1,
    CREATED_BY            NUMBER(32),
    CREATED_AT            TIMESTAMP(6),
    UPDATED_BY            NUMBER(32),
    UPDATED_AT            TIMESTAMP(6),
    STATE                 NUMBER(1)  default 1                                   not null
)
/

create table COMPANIES
(
    ID           NUMBER(12) default "SEQ_INDUSTRIES"."NEXTVAL" not null
        constraint PK_INDUSTRIES__ID
            primary key,
    NIF          VARCHAR2(20),
    NAME         VARCHAR2(200),
    EMAIL        VARCHAR2(50),
    PAGE_WEB     VARCHAR2(200),
    OBSERVATION  VARCHAR2(2000),
    SITUATION_ID NUMBER(12)
        constraint FK_INDUSTRIES__SITUATION_ID
            references SITUATIONS,
    ADDRESS      VARCHAR2(500),
    POSTAL_CODE  VARCHAR2(20),
    COUNTRY_ID   NUMBER(12)
        constraint FK_INDUSTRIES__COUNTRY_ID
            references COUNTRIES,
    CCAA_ID      NUMBER(32)
        constraint FK_INDUSTRIES__CCAA_ID
            references CCAA,
    PROVINCE_ID  NUMBER(12)
        constraint FK_INDUSTRIES__PROVINCE_ID
            references PROVINCES,
    LOCATION_ID  NUMBER(12)
        constraint FK_INDUSTRIES__LOCATION_ID
            references LOCATIONS,
    CREATED_BY   NUMBER(12),
    CREATED_AT   TIMESTAMP(6),
    UPDATED_BY   NUMBER(12),
    UPDATED_AT   TIMESTAMP(6),
    STATE        NUMBER(1)  default 1                                   not null
)
/

create table ESTABLISHMENTS
(
    ID           NUMBER(12) default "SEQ_ESTABLISHMENTS"."NEXTVAL" not null
        constraint PK_ESTABLISHMENTS__ID
            primary key,
    COMPANY_ID   NUMBER(12)                                                 not null,
    ADDRESS      VARCHAR2(500),
    POSTAL_CODE  VARCHAR2(20),
    COUNTRY_ID   NUMBER(12)
        constraint FK_ESTABLISHMENTS__COUNTRY_ID
            references COUNTRIES,
    CCAA_ID      NUMBER(32)
        constraint FK_ESTABLISHMENTS__CCAA_ID
            references CCAA,
    PROVINCE_ID  NUMBER(12)
        constraint FK_ESTABLISHMENTS__PROVINCE_ID
            references PROVINCES,
    LOCATION_ID  NUMBER(12)
        constraint FK_ESTABLISHMENTS__LOCATION_ID
            references LOCATIONS,
    SITUATION_ID NUMBER(12)
        constraint FK_ESTABLISHMENTS__SITUATION_ID
            references SITUATIONS,
    CREATED_BY   NUMBER(12),
    CREATED_AT   TIMESTAMP(6),
    UPDATED_BY   NUMBER(12),
    UPDATED_AT   TIMESTAMP(6),
    STATE        NUMBER(1)  default 1                                       not null
)
/

create table TYPES_ACTUATIONS
(
    ID                    NUMBER(12) default "SEQ_TYPES_ACTUATIONS"."NEXTVAL" not null constraint PK_TYPES_ACTUATIONS__ID primary key,
    NAME                  VARCHAR2(250),
    TYPE_INDUSTRY_PRODUCT NUMBER(1),
    VISIBLE_CCAA          NUMBER,
    CREATED_BY            NUMBER(32),
    CREATED_AT            TIMESTAMP(6),
    UPDATED_BY            NUMBER(32),
    UPDATED_AT            TIMESTAMP(6),
    STATE                 NUMBER(1)  default 1                                         not null
)
/

create table ACTUATIONS
(
    ID               NUMBER(12) default "SEQ_COMPANIES_ACTUATIONS"."NEXTVAL" not null constraint PK_ACTUATIONS__ID primary key,
    COMPANY_ID       NUMBER(12) constraint FK_ACTUATIONS__COMPANY_ID references COMPANIES,
    ESTABLISHMENT_ID NUMBER(12) constraint FK_ACTUATIONS__ESTABLISHMENT_ID references ESTABLISHMENTS,
    TYPE_ACTUATION_ID NUMBER(12) not null constraint FK_ACTUATIONS__ACTUATION_ID references TYPES_ACTUATIONS,
    PRODUCT_ID       NUMBER(12),
    CREATED_BY       NUMBER(32),
    CREATED_AT       TIMESTAMP(6),
    UPDATED_BY       NUMBER(32),
    UPDATED_AT       TIMESTAMP(6),
    STATE            NUMBER(1)  default 1                                             not null
)
/

create table TYPES_DOCUMENTS
(
    ID                      NUMBER(12) default "SEQ_TYPES_DOCUMENTS"."NEXTVAL" not null constraint PK_TYPES_DOCUMENTS__ID primary key,
    TYPE                    VARCHAR2(20),
    NAME                    VARCHAR2(200),
    TYPE_COMPANY_PRODUCT    NUMBER(1),
    VISIBLE_CCAA            NUMBER,
    NO_DELETE               NUMBER,
    CREATED_BY              NUMBER(32),
    CREATED_AT              TIMESTAMP(6),
    UPDATED_BY              NUMBER(32),
    UPDATED_AT              TIMESTAMP(6),
    STATE                   NUMBER(1)  default 1                                        not null
)
/

create table DOCUMENTS
(
    ID               NUMBER(32) default "SEQ_DOCUMENTS"."NEXTVAL" not null constraint PK_DOCUMENTS__ID primary key,
    NAME             VARCHAR2(200),
    TYPE_FILE_ID     NUMBER(12),
    COMPANY_ID       NUMBER(12) constraint FK_DOCUMENTS__COMPANY_ID references COMPANIES,
    ACTUATION_ID     NUMBER(12) constraint FK_DOCUMENTS__ACTUATION_ID references ACTUATIONS,
    TYPE_DOCUMENT_ID NUMBER(12) constraint FK_DOCUMENTS__TYPE_DOCUMENT_ID references TYPES_DOCUMENTS,
    PRODUCT_ID       NUMBER(12),
    CASE_FILE_ID     NUMBER(12),
    NUMBER_EXIT      VARCHAR2(25),
    PATH_FILE        VARCHAR2(200),
    PATH_FILE_OLD    VARCHAR2(200),
    NAME_FILE        VARCHAR2(1000),
    CREATED_BY       NUMBER(32),
    CREATED_AT       TIMESTAMP(6),
    UPDATED_BY       NUMBER(32),
    UPDATED_AT       TIMESTAMP(6),
    STATE            NUMBER(1)  default 1                                  not null
)
/

create table TYPES_CHANGES_EXPEDIENTS
(
    ID         NUMBER(12) default "SEQ_TYPES_CHANGES_EXPEDIENTS"."NEXTVAL" not null constraint PK_TYPES_CHANGES_EXPEDIENTS__ID primary key,
    NAME       VARCHAR2(250),
    CREATED_AT TIMESTAMP(6),
    CREATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    STATE      NUMBER(1)  default 1 not null
)
/

create table CATEGORIES
(
    ID         NUMBER(12) default "SEQ_CATEGORIES"."NEXTVAL" not null
        constraint PK_CATEGORIES__ID
            primary key,
    CODE       VARCHAR2(3),
    NAME       VARCHAR2(200),
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                   not null
)
/

create table AUTH_USER_REQUEST
(
    PETITION_ID        VARCHAR2(36)   not null
        constraint PK_AUTH_USER_REQUEST__PETITION_ID
            primary key,
    RELAY_ID           VARCHAR2(20)   not null,
    TOKEN              VARCHAR2(4000) not null,
    EXP                NUMBER(38)     not null,
    PROCESS_RETURN_URL VARCHAR2(4000) not null,
    constraint UK_AUTH_USER_REQUEST__PETITION_ID__RELAY_ID_UNIQUE
        unique (PETITION_ID, RELAY_ID)
)
/

create table AUTH_USER_TOKEN
(
    PETITION_ID VARCHAR2(36)   not null
        constraint PK_AUTH_USER_TOKEN__PETITION_ID
            primary key,
    RELAY_ID    VARCHAR2(20)   not null,
    DOC_NUM     VARCHAR2(50)   not null,
    TOKEN       VARCHAR2(4000) not null,
    EXP         NUMBER(38)     not null,
    constraint UK_AUTH_USER_TOKEN__PETITION_ID__RELAY_ID_UNIQUE
        unique (PETITION_ID, RELAY_ID)
)
/

create table KEYS
(
    ID              NUMBER(12) default "SEQ_KEYS"."NEXTVAL" not null
        constraint PK_KEYS__ID
            primary key,
    CODE            NUMBER(3),
    NAME            VARCHAR2(200),
    DATE_REGISTER   DATE,
    DATE_UNREGISTER DATE,
    ALLOW_PRODUCT   NUMBER,
    IS_OLD          NUMBER     default 0,
    IS_PUBLIC       NUMBER     default 1,
    CREATED_BY      NUMBER(32),
    CREATED_AT      TIMESTAMP(6),
    UPDATED_BY      NUMBER(32),
    UPDATED_AT      TIMESTAMP(6),
    STATE           NUMBER(1)  default 1                             not null
)
/

create table ACTIVITIES
(
    ID         NUMBER(12) default "SEQ_ACTIVITIES"."NEXTVAL" not null
        constraint PK_ACTIVITIES__ID
            primary key,
    CODE       NUMBER(3),
    NAME       VARCHAR2(250),
    IS_PUBLIC  NUMBER     default 1                                   not null,
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                   not null
)
/

create table DENOMINATION_SALES
(
    ID              NUMBER(12) default "SEQ_DENOMINATION_SALES"."NEXTVAL" not null
        constraint PK_DENOMINATION_SALES__ID
            primary key,
    NAME            VARCHAR2(200),
    KEY_ID          NUMBER(12)
        constraint FK_DENOMINATION_SALES__KEY_ID
            references KEYS,
    ACTIVITY_ID     NUMBER(12)
        constraint FK_DENOMINATION_SALES__ACTIVITY_ID
            references ACTIVITIES,
    FILE_TYPE       VARCHAR2(5),
    IS_PUBLIC       NUMBER(1)  default 0,
    DATE_REGISTER   DATE,
    DATE_UNREGISTER DATE,
    CREATED_BY      NUMBER(32),
    CREATED_AT      TIMESTAMP(6),
    UPDATED_BY      NUMBER(32),
    UPDATED_AT      TIMESTAMP(6),
    STATE           NUMBER(1)  default 1                                           not null,
    constraint UK_DENOMINATION_SALES__KEY_ID__ACTIVITY_ID_UNIQUE
        unique (KEY_ID, ACTIVITY_ID)
)
/

create table SUB_ACTIVITIES
(
    ID         NUMBER(12) default "SEQ_SUB_ACTIVITIES"."NEXTVAL" not null
        constraint PK_SUB_ACTIVITIES__ID
            primary key,
    CODE       VARCHAR2(20),
    NAME       VARCHAR2(250),
    CREATED_BY NUMBER(32),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(32),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                       not null
)
/

create table ACTIVITIES_KEYS
(
    ID          NUMBER(12) default "SEQ_ACTIVITIES_KEYS"."NEXTVAL" not null
        constraint PK_ACTIVITIES_KEYS__ID
            primary key,
    KEY_ID      NUMBER(12)                                                  not null
        constraint FK_ACTIVITIES_KEYS__KEY_ID
            references KEYS,
    ACTIVITY_ID NUMBER(12)                                                  not null
        constraint FK_ACTIVITIES_KEYS__ACTIVITY_ID
            references ACTIVITIES,
    CREATED_BY  NUMBER(32),
    CREATED_AT  TIMESTAMP(6),
    UPDATED_BY  NUMBER(32),
    UPDATED_AT  TIMESTAMP(6),
    STATE       NUMBER(1)  default 1                                        not null,
    constraint UK_ACTIVITIES_KEYS__KEY_ID__ACTIVITY_ID_UNIQUE
        unique (KEY_ID, ACTIVITY_ID)
)
/

create table ACTIVITIES_KEYS_CATEGORIES
(
    ID              NUMBER(12) default "SEQ_ACTIVITIES_KEYS_CATEGORIES"."NEXTVAL" not null
        constraint PK_ACTIVITIES_KEYS_CATEGORIES__ID
            primary key,
    ACTIVITY_KEY_ID NUMBER(12)                                                             not null
        constraint FK_ACTIVITIES_KEYS_CATEGORIES__ACTIVITY_KEY_ID
            references ACTIVITIES_KEYS,
    CATEGORY_ID     NUMBER(12)                                                             not null
        constraint FK_ACTIVITIES_KEYS_CATEGORIES__CATEGORY_ID
            references CATEGORIES,
    CREATED_BY      NUMBER(32),
    CREATED_AT      TIMESTAMP(6),
    UPDATED_BY      NUMBER(32),
    UPDATED_AT      TIMESTAMP(6),
    STATE           NUMBER(1)  default 1                                                   not null,
    constraint UK_ACTIVITIES_KEYS_CATEGORIES__CATEGORY_ID__ACTIVITY_KEY_ID_UNIQUE
        unique (CATEGORY_ID, ACTIVITY_KEY_ID)
)
/

create table ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES
(
    ID                       NUMBER(12) default "SEQ_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES"."NEXTVAL" not null constraint PK_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES__ID primary key,
    ACTIVITY_KEY_CATEGORY_ID NUMBER(12) not null constraint FK_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES__ACTIVITY_KEY_CATEGORY_ID references ACTIVITIES_KEYS_CATEGORIES,
    SUB_ACTIVITY_ID          NUMBER(12) not null constraint FK_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES__SUB_ACTIVITY_ID references SUB_ACTIVITIES,
    CREATED_BY               NUMBER(32),
    CREATED_AT               TIMESTAMP(6),
    UPDATED_BY               NUMBER(32),
    UPDATED_AT               TIMESTAMP(6),
    STATE                    NUMBER(1)  default 1  not null,
    constraint UK_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES__SUB_ACTIVITY_ID__ACTIVITY_KEY_CATEGORY_ID_UNIQUE unique (SUB_ACTIVITY_ID, ACTIVITY_KEY_CATEGORY_ID)
)
/

create table FORM_PRESENTATION
(
    ID              NUMBER(12) default "SEQ_FORM_PRESENTATION"."NEXTVAL" not null
        constraint PK_FORM_PRESENTATION__ID
            primary key,
    NAME            VARCHAR2(200),
    TYPE            VARCHAR2(5),
    DATE_REGISTER   DATE,
    DATE_UNREGISTER DATE,
    CREATED_BY      NUMBER(32),
    CREATED_AT      TIMESTAMP(6),
    UPDATED_BY      NUMBER(32),
    UPDATED_AT      TIMESTAMP(6),
    STATE           NUMBER(1)  default 1                                          not null
)
/

create table FEES
(
    ID          NUMBER(12) default "SEQ_FEES"."NEXTVAL" not null
        constraint PK_FEES__ID
            primary key,
    NAME        VARCHAR2(100),
    DESCRIPTION VARCHAR2(200),
    AMOUNT      NUMBER(12),
    CREATED_BY  NUMBER(12),
    CREATED_AT  TIMESTAMP(6),
    UPDATED_BY  NUMBER(12),
    UPDATED_AT  TIMESTAMP(6),
    STATE       NUMBER(1)  default 1                             not null
)
/

create table SUBSTANCES
(
    ID         NUMBER(12) default "SEQ_SEQ_SUBSTANCES"."NEXTVAL" not null
        constraint SUBSTANCES__ID
            primary key,
    NAME       VARCHAR2(200)                                              not null,
    CREATED_BY NUMBER(12),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(12),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                       not null
)
/

create table RGSEAA
(
    ID                NUMBER(12) default "SEQ_RGSEAA"."NEXTVAL" not null
        constraint PK_RGSEAA__ID
            primary key,
    COMPANY_ID        NUMBER(12)
        constraint FK_RGSEAA__COMPANY_ID
            references COMPANIES,
    ESTABLISHMENT_ID  NUMBER(12)
        constraint FK_RGSEAA__ESTABLISHMENT_ID
            references ESTABLISHMENTS,
    KEY_ID            NUMBER(12)                                         not null
        constraint FK_RGSEAA__KEY_ID
            references KEYS,
    NUM_RGSEAA        NUMBER(12),
    ENROLLMENT        VARCHAR2(3),
    DATE_REGISTER     DATE,
    DATE_ANNOTATION   DATE,
    DATE_MODIFICATION DATE,
    CREATED_BY        NUMBER(12),
    CREATED_AT        TIMESTAMP(6),
    UPDATED_BY        NUMBER(12),
    UPDATED_AT        TIMESTAMP(6),
    STATE             NUMBER(1)  default 1                               not null
)
/

create table RGSEAA_ACTIVITIES
(
    ID              NUMBER(12) default "SEQ_RGSEAA_ACTIVITIES"."NEXTVAL" not null
        constraint PK_RGSEAA_ACTIVITIES__ID
            primary key,
    RGSEAA_ID       NUMBER(12)                                                    not null
        constraint FK_RGSEAA_ACTIVITIES__RGSEAA_ID
            references RGSEAA,
    ACTIVITY_ID     NUMBER(12)                                                    not null
        constraint FK_RGSEAA_ACTIVITIES__ACTIVITY_ID
            references ACTIVITIES,
    CATEGORY_ID     NUMBER(12)                                                    not null
        constraint FK_RGSEAA_ACTIVITIES__CATEGORY_ID
            references CATEGORIES,
    SUB_ACTIVITY_ID NUMBER(12)                                                    not null
        constraint FK_RGSEAA_ACTIVITIES__SUB_ACTIVITY_ID
            references SUB_ACTIVITIES,
    CREATED_BY      NUMBER(12),
    CREATED_AT      TIMESTAMP(6),
    UPDATED_BY      NUMBER(12),
    UPDATED_AT      TIMESTAMP(6),
    STATE           NUMBER(1)  default 1                                          not null
)
/

create table RGSEAA_FEES
(
    ID         NUMBER(12) default "SEQ_RGSEAA_FEES"."NEXTVAL" not null
        constraint PK_RGSEAA_FEES__ID
            primary key,
    RGSEAA_ID  NUMBER(12)                                              not null
        constraint FK_RGSEAA_FEES__RGSEAA_ID
            references RGSEAA,
    FEE_ID     NUMBER(12)                                              not null
        constraint FK_RGSEAA_FEES__FEE_ID_ID
            references FEES,
    CREATED_BY NUMBER(12),
    CREATED_AT TIMESTAMP(6),
    UPDATED_BY NUMBER(12),
    UPDATED_AT TIMESTAMP(6),
    STATE      NUMBER(1)  default 1                                    not null
)
/

create table RGSEAA_AUTHORIZATIONS
(
    ID               NUMBER(12) default "SEQ_RGSEAA_AUTHORIZATIONS"."NEXTVAL" not null
        constraint RGSEAA_AUTHORIZATIONS__ID
            primary key,
    AUTHORIZATION_ID NUMBER(12)                                                        not null
        constraint RGSEAA_AUTHORIZATIONS__AUTHORIZATION_ID
            references AUTHORIZATIONS,
    RGSEAA_ID        NUMBER(12)                                                        not null
        constraint RGSEAA_AUTHORIZATIONS__RGSEAA_ID
            references RGSEAA,
    CREATED_BY       NUMBER(12),
    CREATED_AT       TIMESTAMP(6),
    UPDATED_BY       NUMBER(12),
    UPDATED_AT       TIMESTAMP(6),
    STATE            NUMBER(1)  default 1                                              not null
)
/

