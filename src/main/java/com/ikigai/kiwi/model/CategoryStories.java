package com.ikigai.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "categorystories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryStories{
    @Id
    String _id;
    String mCateId;
    Map<String, String> mCateName;
    String mCateAvatarUrl;
    boolean delFlg;
    boolean isDisableCate;
    Integer __v;

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
