package com.ikigai.kiwi.dao;

import com.ikigai.kiwi.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentDAO extends JpaRepository<Content, Integer> {
}
