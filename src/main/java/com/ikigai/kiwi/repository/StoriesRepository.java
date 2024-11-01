package com.ikigai.kiwi.repository;

import com.ikigai.kiwi.model.Stories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoriesRepository extends MongoRepository<Stories, String>{
}