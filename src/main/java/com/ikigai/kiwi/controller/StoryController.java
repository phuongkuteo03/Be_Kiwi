package com.ikigai.kiwi.controller;

import com.ikigai.kiwi.service.StoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/story")
public class StoryController {
    @Autowired
    StoryService storyService;

    @GetMapping("/search")
    public String chitietdonhang(@RequestParam("name") String name, HttpServletRequest request, Model model) {
        model.addAttribute("items_story", storyService.findByNameStory(name));
        return "layout/index";
    }

    @GetMapping("/detail/{id}")
    public String detailStory(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        model.addAttribute("item_story", storyService.findById(id));
        return "layout/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStory(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        storyService.deleteStory(id);
        return "redirect:/";
    }
}
