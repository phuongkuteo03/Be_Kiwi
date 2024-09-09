package com.ikigai.kiwi.rest.controller;

import com.ikigai.kiwi.entity.Story;
import com.ikigai.kiwi.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/story")
public class StoryRestController {
    @Autowired
    StoryService storyService;

    @GetMapping()
    public List<Story> getAll() {
        return storyService.findAll();
    }

    @GetMapping("{id}")
    public Story getOne(@PathVariable("id") Integer id) {
        return storyService.findById(id);
    }

    @PostMapping
    public Story create(@RequestBody Story Story) {
        return storyService.save(Story);
    }

    @PutMapping("{id}")
    public Story update(@PathVariable("id") Integer id, @RequestBody Story Story) {
        return storyService.save(Story);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        storyService.deleteById(id);
    }
}
