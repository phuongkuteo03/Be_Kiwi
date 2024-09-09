package com.ikigai.kiwi.rest.controller;

import com.ikigai.kiwi.entity.Category;
import com.ikigai.kiwi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public Category getOne(@PathVariable("id") Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category Category) {
        return categoryService.save(Category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category Category) {
        return categoryService.save(Category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
    }
}
