package com.ikigai.kiwi.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ikigai.kiwi.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ikigai.kiwi.entity.Story;
import com.ikigai.kiwi.service.CategoryService;
import com.ikigai.kiwi.service.StoryService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/story")
public class StoryController {

    @Autowired
    StoryService storyService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/search")
    public String timKiemSach(@RequestParam("name") String name, HttpServletRequest request, Model model) {
        model.addAttribute("stories", storyService.findByNameStory(name));
        return "layout/index";
    }

    @GetMapping("/add")
    public String createStory(HttpServletRequest request, Model model) {
        model.addAttribute("stories", new Story());
        model.addAttribute("cates", new Category());
        return "layout/create";
    }

    @PostMapping("/add")
    public String addStory(@ModelAttribute("stories") Story stories, @ModelAttribute("cates") Category cates ,Model model) {
        categoryService.save(cates);
        stories.setCategory(cates);
        storyService.save(stories);
        return "redirect:/";
    }

    @GetMapping(value = "/detail/{id}")
    public String detailStory(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        model.addAttribute("truyen", storyService.findById(id));
        return "layout/detail";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStory(@ModelAttribute("truyen") Story truyen, Model model) {
        storyService.save(truyen);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStory(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        storyService.deleteStory(id);
        return "redirect:/";
    }
}
