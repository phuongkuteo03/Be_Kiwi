package com.ikigai.kiwi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Content")
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(155)")
    String contentAvatarUrl;

    @Column(columnDefinition = "nvarchar(1000)")
    String contentVietNam;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentEnglish;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentFrance;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentDenmark;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentJapan;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentKorea;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentSq;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentArgentina;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentZh;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentEstonia;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentEl;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentIt;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentPt;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentRusia;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentRs;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentSo;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentThailand;
    @Column(columnDefinition = "nvarchar(1000)")
    String contentUkraine;


    @ManyToOne @JoinColumn(name = "storyId")
    private Story story;
}
