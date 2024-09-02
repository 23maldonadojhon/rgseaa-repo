package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.entity.CompanyEstablishmentView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyEstablishmentViewRepository
    extends BaseRepository<CompanyEstablishmentView, Long>,
    QueryByCriteria<CompanyEstablishmentView, GeneralCriteria> {


    @Query( value = "SELECT COUNT(*) FROM ( " +
            "   SELECT " +
            "    'PRINCIPAL' AS TYPE, " +
            "    c.ID AS COMPANY_ID, " +
            "    c.NIF, " +
            "    c.NAME AS COMPANY_NAME, " +
            "    c.EMAIL AS COMPANY_EMAIL, " +
            "    c.PAGE_WEB AS COMPANY_PAGE_WEB, " +
            "    c.OBSERVATION AS COMPANY_OBSERVATION, " +
            "    c.ADDRESS AS COMPANY_ADDRESS, " +
            "    c.POSTAL_CODE AS COMPANY_POSTAL_CODE, " +
            "    c.COUNTRY_ID AS COMPANY_COUNTRY_ID, " +
            "    c.PROVINCE_ID AS COMPANY_PROVINCE_ID, " +
            "    c.LOCATION_ID AS COMPANY_LOCATION_ID, " +
            "    c.SITUATION_ID AS COMPANY_SITUATION_ID, " +
            "    c.STATE AS COMPANY_STATE, " +
            "    NULL AS ESTABLISHMENT_ID, " +
            "    NULL AS ESTABLISHMENT_ADDRESS, " +
            "    NULL AS ESTABLISHMENT_POSTAL_CODE, " +
            "    NULL AS ESTABLISHMENT_COUNTRY_ID, " +
            "    NULL AS ESTABLISHMENT_PROVINCE_ID, " +
            "    NULL AS ESTABLISHMENT_LOCATION_ID, " +
            "    NULL AS ESTABLISHMENT_SITUATION_ID, " +
            "    NULL AS ESTABLISHMENT_STATE " +
            "FROM " +
            "    COMPANIES c " +
            "UNION ALL " +
            "SELECT " +
            "    'ESTABLECIMIENTO' AS TYPE, " +
            "    c.ID AS COMPANY_ID, " +
            "    c.NIF, " +
            "    c.NAME AS COMPANY_NAME, " +
            "    c.EMAIL AS COMPANY_EMAIL, " +
            "    c.PAGE_WEB AS COMPANY_PAGE_WEB, " +
            "    c.OBSERVATION AS COMPANY_OBSERVATION, " +
            "    c.ADDRESS AS COMPANY_ADDRESS, " +
            "    c.POSTAL_CODE AS COMPANY_POSTAL_CODE, " +
            "    c.COUNTRY_ID AS COMPANY_COUNTRY_ID, " +
            "    c.PROVINCE_ID AS COMPANY_PROVINCE_ID, " +
            "    c.LOCATION_ID AS COMPANY_LOCATION_ID, " +
            "    c.SITUATION_ID AS COMPANY_SITUATION_ID, " +
            "    c.STATE AS COMPANY_STATE, " +
            "    e.ID AS ESTABLISHMENT_ID, " +
            "    e.ADDRESS AS ESTABLISHMENT_ADDRESS, " +
            "    e.POSTAL_CODE AS ESTABLISHMENT_POSTAL_CODE, " +
            "    e.COUNTRY_ID AS ESTABLISHMENT_COUNTRY_ID, " +
            "    e.PROVINCE_ID AS ESTABLISHMENT_PROVINCE_ID, " +
            "    e.LOCATION_ID AS ESTABLISHMENT_LOCATION_ID, " +
            "    e.SITUATION_ID AS ESTABLISHMENT_SITUATION_ID, " +
            "    e.STATE AS ESTABLISHMENT_STATE " +
            "FROM " +
            "    COMPANIES c " +
            "RIGHT JOIN " +
            "    ESTABLISHMENTS e ON c.ID = e.COMPANY_ID " +
            ") t " +
            "WHERE" +
            " (:#{#criteria.state} IS NULL OR t.COMPANY_STATE = :#{#criteria.state}) " +
            " AND (:#{#criteria.search} IS NULL OR  UPPER(t.COMPANY_NAME) LIKE(UPPER(:#{#criteria.search}))) ",
            nativeQuery = true)
    Long findListCount(@Param("criteria") GeneralCriteria criteria);

    @Query( value = "SELECT\n" +
            "    T.TYPE,\n" +
            "    T.NIF,\n" +
            "    T.COMPANY_ID,\n" +
            "    T.COMPANY_NAME,\n" +
            "    T.COMPANY_ADDRESS,\n" +
            "    T.COMPANY_POSTAL_CODE,\n" +
            "    C.NAME AS COMPANY_COUNTRY_NAME,\n" +
            "    CA.NAME AS COMPANY_CCAA_NAME,\n" +
            "    P.NAME AS COMPANY_PROVINCE_NAME,\n" +
            "    L.NAME AS COMPANY_LOCATION_NAME,\n" +
            "    S.NAME AS COMPANY_SITUATION_NAME,\n" +
            "    T.COMPANY_STATE,\n" +
            "    T.ESTABLISHMENT_ID,\n" +
            "    T.ESTABLISHMENT_ADDRESS,\n" +
            "    T.ESTABLISHMENT_POSTAL_CODE,\n" +
            "    EC.NAME AS ESTABLISHMENT_COUNTRY_NAME,\n" +
            "    ECA.NAME AS  ESTABLISHMENT_CCAA_NAME,\n" +
            "    EP.NAME AS ESTABLISHMENT_PROVINCE_NAME,\n" +
            "    EL.NAME AS ESTABLISHMENT_LOCATION_NAME,\n" +
            "    ES.NAME AS ESTABLISHMENT_SITUATION_NAME\n" +
            "FROM (\n" +
            "        SELECT\n" +
            "           'PRINCIPAL' AS TYPE,\n" +
            "           c.ID AS COMPANY_ID,\n" +
            "           c.NIF,\n" +
            "           c.NAME AS COMPANY_NAME,\n" +
            "           c.ADDRESS AS COMPANY_ADDRESS,\n" +
            "           c.POSTAL_CODE AS COMPANY_POSTAL_CODE,\n" +
            "           c.COUNTRY_ID AS COMPANY_COUNTRY_ID,\n" +
            "           c.CCAA_ID AS COMPANY_CCAA_ID,\n" +
            "           c.PROVINCE_ID AS COMPANY_PROVINCE_ID,\n" +
            "           c.LOCATION_ID AS COMPANY_LOCATION_ID,\n" +
            "           c.SITUATION_ID AS COMPANY_SITUATION_ID,\n" +
            "           c.STATE AS COMPANY_STATE,\n" +
            "           NULL AS ESTABLISHMENT_ID,\n" +
            "           NULL AS ESTABLISHMENT_ADDRESS,\n" +
            "           NULL AS ESTABLISHMENT_POSTAL_CODE,\n" +
            "           NULL AS ESTABLISHMENT_COUNTRY_ID,\n" +
            "           NULL AS ESTABLISHMENT_CCAA_ID,\n" +
            "           NULL AS ESTABLISHMENT_PROVINCE_ID,\n" +
            "           NULL AS ESTABLISHMENT_LOCATION_ID,\n" +
            "           NULL AS ESTABLISHMENT_SITUATION_ID,\n" +
            "           NULL AS ESTABLISHMENT_STATE\n" +
            "        FROM\n" +
            "           COMPANIES c\n" +
            "        UNION ALL\n" +
            "        SELECT\n" +
            "           'ESTABLECIMIENTO' AS TYPE,\n" +
            "           c.ID AS COMPANY_ID,\n" +
            "           c.NIF,\n" +
            "           c.NAME AS COMPANY_NAME,\n" +
            "           c.ADDRESS AS COMPANY_ADDRESS,\n" +
            "           c.POSTAL_CODE AS COMPANY_POSTAL_CODE,\n" +
            "           c.COUNTRY_ID AS COMPANY_COUNTRY_ID,\n" +
            "           c.CCAA_ID AS COMPANY_CCAA_ID,\n" +
            "           c.PROVINCE_ID AS COMPANY_PROVINCE_ID,\n" +
            "           c.LOCATION_ID AS COMPANY_LOCATION_ID,\n" +
            "           c.SITUATION_ID AS SITUATION_ID,\n" +
            "           c.STATE AS COMPANY_STATE,\n" +
            "           e.ID AS ESTABLISHMENT_ID,\n" +
            "           e.ADDRESS AS ESTABLISHMENT_ADDRESS,\n" +
            "           e.POSTAL_CODE AS ESTABLISHMENT_POSTAL_CODE,\n" +
            "           e.COUNTRY_ID AS ESTABLISHMENT_COUNTRY_ID,\n" +
            "           e.CCAA_ID AS ESTABLISHMENT_CCAA_ID,\n" +
            "           e.PROVINCE_ID AS ESTABLISHMENT_PROVINCE_ID,\n" +
            "           e.LOCATION_ID AS ESTABLISHMENT_LOCATION_ID,\n" +
            "           e.SITUATION_ID AS ESTABLISHMENT_SITUATION_ID,\n" +
            "           e.STATE AS ESTABLISHMENT_STATE\n" +
            "        FROM\n" +
            "           COMPANIES c\n" +
            "        RIGHT JOIN\n" +
            "           ESTABLISHMENTS e ON c.ID = e.COMPANY_ID\n" +
            ") T\n" +
            "INNER JOIN SITUATIONS S ON S.ID = T.COMPANY_SITUATION_ID\n" +
            "LEFT JOIN COUNTRIES C ON C.ID = T.COMPANY_COUNTRY_ID\n" +
            "LEFT JOIN CCAA CA ON CA.ID = T.COMPANY_CCAA_ID\n" +
            "LEFT JOIN PROVINCES P ON P.ID = T.COMPANY_PROVINCE_ID\n" +
            "LEFT JOIN LOCATIONS L ON L.ID = T.COMPANY_LOCATION_ID\n" +
            "LEFT JOIN SITUATIONS ES ON ES.ID = T.ESTABLISHMENT_SITUATION_ID\n" +
            "LEFT JOIN COUNTRIES EC ON EC.ID = T.ESTABLISHMENT_COUNTRY_ID\n" +
            "LEFT JOIN CCAA ECA ON ECA.ID = T.ESTABLISHMENT_CCAA_ID\n" +
            "LEFT JOIN PROVINCES EP ON EP.ID = T.ESTABLISHMENT_PROVINCE_ID\n" +
            "LEFT JOIN LOCATIONS EL ON EL.ID = T.ESTABLISHMENT_LOCATION_ID " +
            "WHERE" +
            " (:#{#criteria.state} IS NULL OR t.COMPANY_STATE = :#{#criteria.state}) " +
            " AND (:#{#criteria.search} IS NULL OR  UPPER(t.COMPANY_NAME) LIKE(UPPER(:#{#criteria.search}))) " +
            " AND (:#{#criteria.search} IS NULL OR  UPPER(t.COMPANY_ADDRESS) LIKE(UPPER(:#{#criteria.search}))) " +
            " AND (:#{#criteria.search} IS NULL OR  UPPER(t.ESTABLISHMENT_ADDRESS) LIKE(UPPER(:#{#criteria.search}))) " +
            " ORDER BY t.COMPANY_NAME " +
            " OFFSET (:#{#criteria.size}*:#{#criteria.page}) ROWS FETCH NEXT :#{#criteria.size} ROWS ONLY ",
            nativeQuery = true)
    List<CompanyEstablishmenInterface> findList(@Param("criteria") GeneralCriteria criteria);
}
