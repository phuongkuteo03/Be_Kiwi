package com.ikigai.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorystories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryStories{
    @Id
    String _id;
    String mCateId;
    Object mCateName;
    String mCateAvatarUrl;
    String delFlg;
    boolean isDisableCate;
    Integer __v;
}
