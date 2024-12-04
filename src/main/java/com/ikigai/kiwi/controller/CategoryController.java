package com.ikigai.kiwi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ikigai.kiwi.model.CategoryStories;
import com.ikigai.kiwi.model.Stories;
import com.ikigai.kiwi.service.CategoryStoriesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryStoriesService categoryStoriesService;

    @GetMapping("/cate")
    public String cate(HttpServletRequest request, Model model) {
        List<CategoryStories> categories = categoryStoriesService.findAll();
        model.addAttribute("categorystories", categories);
        return "layout/cate";
    }

    @GetMapping("/addcate")
    public String createCate(HttpServletRequest request, Model model) {
        model.addAttribute("categorystories", new CategoryStories());
        return "layout/create_cate";
    }

    @PostMapping("/addcate")
    public String addCate(String mCateId,String mCateName,String mCateAvatarUrl, Model model) {
        try {
            categoryStoriesService.CreateCategories(mCateId,mCateName,mCateAvatarUrl);
            return "redirect:/category/cate";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "layout/error";
        }
    }
    @DeleteMapping("/deletecate/{id}")
    public String deleteCate(@PathVariable("id") String id,Model model){
        try{
            categoryStoriesService.deleteCate(id);
            return "redirect:/category/cate";
        }
        catch (Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "layout/error";
        }
    }
    @GetMapping("/detailcate/{id}")
    public String detailCate(@PathVariable("id") String id, Model model) {
        CategoryStories categoryStories = categoryStoriesService.findCateByID(id);
        if (categoryStories != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
                model.addAttribute("mCateNameJson", objectMapper.writeValueAsString(categoryStories.getMCateName()));
            } catch (Exception e) {
                model.addAttribute("errorMessage", "Lỗi format json: " + e.getMessage());
            }
        }
        model.addAttribute("categories", categoryStories);
        return "layout/detailcate";
    }
    @PatchMapping("/updatecate/{id}")
    public String updateCate(@PathVariable("id") String id, @RequestParam Map<String, String> updates, Model model) {
        try {
            categoryStoriesService.updateCate(id, updates);
            return "redirect:/category/cate";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "layout/error";
        }
    }
}
