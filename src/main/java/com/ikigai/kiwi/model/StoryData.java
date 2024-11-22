package com.ikigai.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryData {
    int id;
    Map<String, String> content;
    String url_image;
}
