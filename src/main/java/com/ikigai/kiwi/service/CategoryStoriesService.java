package com.ikigai.kiwi.service;

import com.ikigai.kiwi.model.CategoryStories;
import com.ikigai.kiwi.repository.CategoryStoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryStoriesService {
    @Autowired
    CategoryStoriesRepository categoryStoriesRepository;

    //CRUD: CREATE, READ, UPDATE, DELELTE
    public CategoryStories CreateStories(CategoryStories categoryStories){
        categoryStories.set_id(UUID.randomUUID().toString().split("-")[0]);
        return categoryStoriesRepository.save(categoryStories);
    }

    public List<CategoryStories> findAll(){
        return categoryStoriesRepository.findAll();
    }

    public CategoryStories findStoriesByID(String _id){
        return categoryStoriesRepository.findById(_id).get();
    }

    public CategoryStories updateStories(CategoryStories stories){
        return categoryStoriesRepository.save(stories);
    }

    // Delete logic
    public void deleteStory(String _id){
        categoryStoriesRepository.deleteById(_id);
    }
}
