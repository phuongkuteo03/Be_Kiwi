package com.ikigai.kiwi.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ikigai.kiwi.model.CategoryStories;
import com.ikigai.kiwi.service.CategoryStoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ikigai.kiwi.model.Stories;
import com.ikigai.kiwi.service.StoriesService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/story")
public class StoryController {

    @Autowired
    StoriesService storyService;
    @Autowired
    CategoryStoriesService categoryStoriesService;

    @GetMapping("/add")
    public String createStory(HttpServletRequest request, Model model) {
        model.addAttribute("stories", new Stories());
        List<CategoryStories> categories = categoryStoriesService.findAll();
        model.addAttribute("categorystories", categories);
        return "layout/create";
    }

    @PostMapping("/add")
    public String addStory(String mStoryId,String mStoryName, String mStoryData, String mStoryAvatarUrl,String mCateId,String areaStory, Model model) {
        try {
            storyService.CreateStories(mStoryId,mStoryName, mStoryData, mStoryAvatarUrl,mCateId,areaStory);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "layout/error";
        }
    }

    @PatchMapping("/update/{id}")
    public String updateStory(@PathVariable("id") String id, @RequestParam Map<String, String> updates, Model model) {
        try {
            storyService.updateStory(id, updates);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "layout/error";
        }
    }

    @GetMapping("/detail/{id}")
    public String detailStory(@PathVariable("id") String id, Model model) {
        Stories story = storyService.findStoriesByID(id);
        List<CategoryStories> categories = categoryStoriesService.findAll();
        if (story != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
                model.addAttribute("mStoryNameJson", objectMapper.writeValueAsString(story.getMStoryName()));
                model.addAttribute("mStoryDataJson", objectMapper.writeValueAsString(story.getMStoryData()));
            } catch (Exception e) {
                model.addAttribute("errorMessage", "Lỗi format json: " + e.getMessage());
            }
        }
        model.addAttribute("categorystories", categories);
        model.addAttribute("stories", story);
        return "layout/detail";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStory(@PathVariable("id") String id, Model model){
        try {
            storyService.deleteStory(id);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "layout/error";
        }
    }

    @GetMapping("/search")
    public String searchStory(@RequestParam("name") String name, Model model) {
        List<Stories> foundStories = storyService.searchStoryByName(name);
        model.addAttribute("stories", foundStories);
        return "layout/index";
    }
}
