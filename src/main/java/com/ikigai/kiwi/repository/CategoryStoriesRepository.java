package com.ikigai.kiwi.repository;

import com.ikigai.kiwi.model.CategoryStories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryStoriesRepository extends MongoRepository<CategoryStories, String> {
}
