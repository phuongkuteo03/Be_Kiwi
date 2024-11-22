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

@Service
public class StoriesService {
    @Autowired
    StoriesRepository storiesRepository;
    ObjectMapper objectMapper = CustomObjectMapper.getMapper();
    // CRUD: CREATE, READ, UPDATE, DELETE
    public Stories CreateStories(String mStoryName, String mStoryData, String mStoryAvatarUrl, String mCateId, String areaStory) throws Exception {
            Map<String, String> mStoryNameMap = objectMapper.readValue(mStoryName, new TypeReference<>() {});
            List<StoryData> mStoryDataList = objectMapper.readValue(mStoryData, new TypeReference<>() {});

            Stories story = new Stories();
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
                    case "mStoryName" -> existingStory.setMStoryName(
                            objectMapper.readValue(value, new TypeReference<Map<String, String>>() {}));
                    case "mStoryData" -> existingStory.setMStoryData(
                            objectMapper.readValue(value, new TypeReference<List<StoryData>>() {}));
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
        storiesRepository.delete(story);
    }

    public List<Stories> findAll() {
        return storiesRepository.findAll();
    }

    public Stories findStoriesByID(String _id) {
        return storiesRepository.findById(_id).orElse(null);
    }

    public Stories findStoriesByName(String mStoryName) {
        return storiesRepository.findById(mStoryName).orElse(null);
    }

}


