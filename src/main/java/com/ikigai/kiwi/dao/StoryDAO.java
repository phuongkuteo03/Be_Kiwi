package com.ikigai.kiwi.dao;

import com.ikigai.kiwi.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryDAO extends JpaRepository<Story, Integer> {
    @Query("SELECT o FROM Story o WHERE o.storyNameVietNam LIKE %?1% OR storyNameEnglish LIKE %?1% OR storyNameFrance LIKE %?1% OR storyNameDenmark LIKE %?1%" +
            "OR storyNameJapan LIKE %?1% OR storyNameKorea LIKE %?1% OR storyNameSq LIKE %?1% OR storyNameArgentina LIKE %?1% OR storyNameZh LIKE %?1% OR storyNameEstonia LIKE %?1% " +
            "OR storyNameEl LIKE %?1% OR storyNameIt LIKE %?1% OR storyNamePt LIKE %?1% OR storyNameRusia LIKE %?1% OR storyNameRs LIKE %?1% OR storyNameSo LIKE %?1% " +
            "OR storyNameThailand LIKE %?1% OR storyNameUkraine LIKE %?1%")
    List<Story> findByNameStory(String name);
}
