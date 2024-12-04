package com.ikigai.kiwi.controller;

import com.ikigai.kiwi.model.CategoryStories;
import com.ikigai.kiwi.service.CategoryStoriesService;
import com.ikigai.kiwi.service.StoriesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    StoriesService storyService;

    @Autowired
    private CategoryStoriesService categoryStoriesService;

    @GetMapping({ "/", "/home/index" })
    public String home(@RequestParam(required = false) String category, Model model) throws Exception {
        List<CategoryStories> categories = categoryStoriesService.findAll();
        model.addAttribute("categories", categories);

        if (category != null && !category.isEmpty()) {
            model.addAttribute("stories", storyService.findByCategoryId(category));
        } else {
            model.addAttribute("stories", storyService.findAll());
        }

        return "layout/index";
    }
}
