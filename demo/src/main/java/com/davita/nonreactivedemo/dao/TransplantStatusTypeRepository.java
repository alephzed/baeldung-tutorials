package com.davita.nonreactivedemo.dao;

import com.davita.nonreactivedemo.model.TransplantStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransplantStatusTypeRepository extends JpaRepository<TransplantStatusType, String> {

    @Query(value = "SELECT trnsp_sts_type_cd, descr FROM transplant_status_types " +
            "WHERE trnsp_sts_type_cd <> 'UNSPECIFIED' " +
            "order by descr asc", nativeQuery = true)
    List<TransplantStatusType> activeTypesNotUnspecified();
}
