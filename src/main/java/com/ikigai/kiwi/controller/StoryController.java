package com.ikigai.kiwi.controller;

import com.ikigai.kiwi.model.CategoryStories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ikigai.kiwi.model.Stories;
import com.ikigai.kiwi.service.StoriesService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/story")
public class StoryController {

    @Autowired
    StoriesService storyService;

    @GetMapping("/search")
    public String timKiemSach(@RequestParam("name") String name, HttpServletRequest request, Model model) {
//        model.addAttribute("stories", storyService.findByNameStory(name));
        return "layout/index";
    }

    @GetMapping("/add")
    public String createStory(HttpServletRequest request, Model model) {
        model.addAttribute("stories", new Stories());
        model.addAttribute("cates", new CategoryStories());
        return "layout/create";
    }

    @PostMapping("/add")
    public String addStory(@ModelAttribute("stories") Stories stories, @ModelAttribute("cates") CategoryStories cates , Model model) {
        return "redirect:/";
    }

    @GetMapping(value = "/detail/{id}")
    public String detailStory(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        return "layout/detail";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStory(@ModelAttribute("truyen") Stories truyen, Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStory(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        return "redirect:/";
    }
}
