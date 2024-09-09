package com.ikigai.kiwi.rest.controller;

import com.ikigai.kiwi.entity.Content;
import com.ikigai.kiwi.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/controller")
public class ContentRestController {

    @Autowired
    ContentService contentService;

    @GetMapping()
    public List<Content> getAll() {
        return contentService.findAll();
    }

    @GetMapping("{id}")
    public Content getOne(@PathVariable("id") Integer id) {
        return contentService.findById(id);
    }

    @PostMapping
    public Content create(@RequestBody Content Content) {
        return contentService.save(Content);
    }

    @PutMapping("{id}")
    public Content update(@PathVariable("id") Integer id, @RequestBody Content Content) {
        return contentService.save(Content);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        contentService.deleteById(id);
    }
}
