package com.davita.nonreactivedemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "transplant_status_types")
@Entity
public class TransplantStatusType {

    @Id
    @Column(name="trnsp_sts_type_cd")
    private String code;

    private String descr;
}


