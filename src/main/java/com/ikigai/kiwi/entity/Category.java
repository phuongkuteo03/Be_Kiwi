package com.ikigai.kiwi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cateId;

    @Column(columnDefinition = "nvarchar(255)")
    String cateNameVietNam;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameEnglish;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameFrance;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameDenmark;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameJapan;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameKorea;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameSq;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameArgentina;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameZh;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameEstonia;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameEl;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameIt;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNamePt;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameRusia;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameRs;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameSo;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameThailand;
    @Column(columnDefinition = "nvarchar(255)")
    String cateNameUkraine;

    @JsonIgnore
    @OneToOne(mappedBy = "category")
    Story story;
}
