package com.ikigai.kiwi.repository;

import com.ikigai.kiwi.model.CategoryStories;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryStoriesRepository extends MongoRepository<CategoryStories, String> {
    List<CategoryStories> findByDelFlgFalse();
}
