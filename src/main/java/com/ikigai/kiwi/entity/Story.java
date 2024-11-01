package com.ikigai.kiwi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Story")
public class Story implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer storyId;

    @Column(columnDefinition = "nvarchar(255)")
    String storyNameVietNam;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameEnglish;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameFrance;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameDenmark;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameJapan;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameKorea;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameSq;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameArgentina;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameZh;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameEstonia;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameEl;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameIt;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNamePt;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameRusia;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameRs;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameSo;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameThailand;
    @Column(columnDefinition = "nvarchar(255)")
    String storyNameUkraine;
    @Column(columnDefinition = "nvarchar(255)")
    String storyAvatarUrl;
    @Column(columnDefinition = "nvarchar(50)")
    String storyData;
    @Column(columnDefinition = "nvarchar(50)")
    String areaStory;

    boolean isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "story")
    List<Content> content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cateId")
    private Category category;
}
