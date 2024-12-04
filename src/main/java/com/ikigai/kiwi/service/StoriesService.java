package com.ikigai.kiwi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikigai.kiwi.CustomObjectMapper;
import com.ikigai.kiwi.model.Stories;
import com.ikigai.kiwi.model.StoryData;
import com.ikigai.kiwi.repository.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StoriesService {
    @Autowired
    StoriesRepository storiesRepository;
    ObjectMapper objectMapper = CustomObjectMapper.getMapper();
    // CRUD: CREATE, READ, UPDATE, DELETE
    public Stories CreateStories(String mStoryId,String mStoryName, String mStoryData, String mStoryAvatarUrl, String mCateId, String areaStory) throws Exception {
            Map<String, String> mStoryNameMap = objectMapper.readValue(mStoryName, new TypeReference<>() {});
            List<StoryData> mStoryDataList = objectMapper.readValue(mStoryData, new TypeReference<>() {});

            Stories story = new Stories();
            story.setMStoryId(mStoryId);
            story.setMStoryName(mStoryNameMap);
            story.setMStoryData(mStoryDataList);
            story.setMStoryAvatarUrl(mStoryAvatarUrl);
            story.setMCateId(mCateId);
            story.setAreaStory(areaStory);
            story.set_id(UUID.randomUUID().toString().split("-")[0]);
            return storiesRepository.save(story);
    }

    public void updateStory(String id, Map<String, String> updates) throws Exception {
        Stories existingStory = storiesRepository.findById(id)
                .orElseThrow(() -> new Exception("Không tìm thấy câu chuyện"));
        updates.forEach((key, value) -> {
            try {
                switch (key) {
                    case "mStoryId" -> existingStory.setMStoryId(value);
                    case "mStoryName" -> existingStory.setMStoryName(objectMapper.readValue(value, new TypeReference<Map<String, String>>() {}));
                    case "mStoryData" -> existingStory.setMStoryData(objectMapper.readValue(value, new TypeReference<List<StoryData>>() {}));
                    case "mStoryAvatarUrl" -> existingStory.setMStoryAvatarUrl(value);
                    case "mCateId" -> existingStory.setMCateId(value);
                    case "areaStory" -> existingStory.setAreaStory(value);
                }
            } catch (Exception e) {
                throw new RuntimeException("Lỗi cập nhật: " + key, e);
            }
        });
        storiesRepository.save(existingStory);
    }

    public void deleteStory(String id) throws Exception {
        Stories story = storiesRepository.findById(id)
                .orElseThrow(() -> new Exception("Không tìm thấy câu chuyện để xóa."));
        story.setIsDeleted(true);
        storiesRepository.save(story);
    }

    public List<Stories> searchStoryByName(String name) {
        return storiesRepository.findByIsDeletedFalse().stream()
                .filter(story -> story.getMStoryName().values().stream()
                        .anyMatch(storyName -> storyName.toLowerCase().contains(name.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Stories> findAll() {
        return storiesRepository.findByIsDeletedFalse();
    }

    public Stories findStoriesByID(String _id) {
        return storiesRepository.findById(_id).orElse(null);
    }

    public List<Stories> findByCategoryId(String categoryId) {
        return storiesRepository.findByIsDeletedFalse().stream()
                .filter(story -> categoryId.equals(story.getMCateId()))
                .collect(Collectors.toList());
    }

//    public Stories findStoriesByName(String mStoryName) {
//        return storiesRepository.findById(mStoryName).orElse(null);
//    }

}


