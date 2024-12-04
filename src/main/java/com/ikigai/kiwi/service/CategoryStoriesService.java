package com.ikigai.kiwi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikigai.kiwi.CustomObjectMapper;
import com.ikigai.kiwi.model.CategoryStories;
import com.ikigai.kiwi.model.Stories;
import com.ikigai.kiwi.model.StoryData;
import com.ikigai.kiwi.repository.CategoryStoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategoryStoriesService {
    @Autowired
    CategoryStoriesRepository categoryStoriesRepository;
    ObjectMapper objectMapper = CustomObjectMapper.getMapper();
    //CRUD: CREATE, READ, UPDATE, DELELTE
    public CategoryStories CreateCategories(String mCateId,String mCateName,String mCateAvatarUrl) throws Exception{
        Map<String, String> mCateNameMap = objectMapper.readValue(mCateName, new TypeReference<>() {});

        CategoryStories categoryStories = new CategoryStories();
        categoryStories.setMCateId(mCateId);
        categoryStories.setMCateName(mCateNameMap);
        categoryStories.setMCateAvatarUrl(mCateAvatarUrl);
        categoryStories.set_id(UUID.randomUUID().toString().split("-")[0]);
        return categoryStoriesRepository.save(categoryStories);
    }

    public void updateCate(String id, Map<String, String> updates) throws Exception {
        CategoryStories existingCate = categoryStoriesRepository.findById(id)
                .orElseThrow(() -> new Exception("Không tìm thấy danh mục"));
        updates.forEach((key, value) -> {
            try {
                switch (key) {
                    case "mCateId" -> existingCate.setMCateId(value);
                    case "mCateName" -> existingCate.setMCateName(
                            objectMapper.readValue(value, new TypeReference<Map<String, String>>() {}));
                    case "mCateAvatarUrl" -> existingCate.setMCateAvatarUrl(value);
                }
            } catch (Exception e) {
                throw new RuntimeException("Lỗi cập nhật: " + key, e);
            }
        });
        categoryStoriesRepository.save(existingCate);
    }

    public List<CategoryStories> findAll(){
        return categoryStoriesRepository.findByDelFlgFalse();
    }

    public void deleteCate(String id)throws Exception{
        CategoryStories categoryStories = categoryStoriesRepository.findById(id).orElseThrow(()-> new Exception("Không tìm thấy câu chuyện để xóa."));
        categoryStories.setDelFlg(true);
        categoryStoriesRepository.save(categoryStories);
    }

    public CategoryStories findCateByID(String _id){
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
