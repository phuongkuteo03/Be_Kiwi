package com.ikigai.kiwi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document(collection = "stories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stories {

    @Id
    String _id;
    String mStoryId;
    String mCateId;
    Object mCateName;
    Map<String, String> mStoryName;
    String mStoryAvatarUrl;
    String rate;
    boolean isFavourite;
    List<StoryData> mStoryData;
    String areaStory;
    boolean isDisableCate;
    boolean isDeleted;
    Integer __v;

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
