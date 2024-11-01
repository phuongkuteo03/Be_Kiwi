package com.ikigai.kiwi.service;

import com.ikigai.kiwi.model.Stories;
import com.ikigai.kiwi.repository.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StoriesService {
    @Autowired
    StoriesRepository storiesRepository;

    //CRUD: CREATE, READ, UPDATE, DELELTE
    public Stories CreateStories(Stories stories){
        stories.set_id(UUID.randomUUID().toString().split("-")[0]);
        return storiesRepository.save(stories);
    }

    public List<Stories> findAll(){
        return storiesRepository.findAll();
    }

    public Stories findStoriesByID(String _id){
        return storiesRepository.findById(_id).get();
    }

    public Stories updateStories(Stories stories){
        return storiesRepository.save(stories);
    }

    // Delete logic
    public void deleteStory(String _id){
        storiesRepository.deleteById(_id);
    }
}
