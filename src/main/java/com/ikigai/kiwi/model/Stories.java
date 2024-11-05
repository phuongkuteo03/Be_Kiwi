package com.ikigai.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

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
    Object mStoryName;
    String mStoryAvatarUrl;
    String rate;
    boolean isFavourite;

    String mStoryData;
    String areaStory;
    boolean isDisableCate;
    Integer __v;
}
