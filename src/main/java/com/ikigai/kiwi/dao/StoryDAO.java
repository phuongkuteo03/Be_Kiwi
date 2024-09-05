package com.ikigai.kiwi.dao;

import com.ikigai.kiwi.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryDAO extends JpaRepository<Story, Integer> {

}
