package com.ikigai.kiwi.controller;

import com.ikigai.kiwi.service.CategoryService;
import com.ikigai.kiwi.service.ContentService;
import com.ikigai.kiwi.service.StoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    StoryService storyService;

    @RequestMapping({ "/", "/home/index" })
    public String home(HttpServletRequest request, Model model) throws Exception {
//        if (request.getRemoteUser() != null) {
//            TaiKhoan user = taiKhoanService.getOne(request.getRemoteUser());
//            model.addAttribute("USER", user);
//        }
        model.addAttribute("items_story",storyService.findAll());
        return "layout/index";
    }
}
