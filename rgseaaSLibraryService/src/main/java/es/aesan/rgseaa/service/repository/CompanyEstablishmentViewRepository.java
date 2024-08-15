package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.entity.CompanyEstablishmentView;
import org.springframework.data.domain.Page;
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

    @Query( value = "SELECT * FROM ( " +
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
            " AND (:#{#criteria.search} IS NULL OR  UPPER(t.COMPANY_NAME) LIKE(UPPER(:#{#criteria.search}))) " +
            " ORDER BY t.COMPANY_NAME " +
            " OFFSET (:#{#criteria.size}*:#{#criteria.page}) ROWS FETCH NEXT :#{#criteria.size} ROWS ONLY ",
            nativeQuery = true)
    List<CompanyEstablishmenInterface> findList(@Param("criteria") GeneralCriteria criteria);
}
