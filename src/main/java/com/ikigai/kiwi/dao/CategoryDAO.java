package com.ikigai.kiwi.dao;

import com.ikigai.kiwi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
