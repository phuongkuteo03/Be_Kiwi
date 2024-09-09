package com.ikigai.kiwi.service.impl;

import com.ikigai.kiwi.dao.CategoryDAO;
import com.ikigai.kiwi.entity.Category;
import com.ikigai.kiwi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public <S extends Category> S save(S entity) {
        return categoryDAO.save(entity);
    }

    @Override
    public <S extends Category> Optional<S> findOne(Example<S> example) {
        return categoryDAO.findOne(example);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryDAO.findAll(pageable);
    }

    @Override
    public List<Category> findAll(Sort sort) {
        return categoryDAO.findAll(sort);
    }

    @Override
    public List<Category> findAllById(List<Integer> ids) {
        return categoryDAO.findAllById(ids);
    }

    @Override
    public <S extends Category> List<S> saveAll(List<S> entities) {
        return categoryDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        categoryDAO.flush();
    }

    @Override
    public <S extends Category> S saveAndFlush(S entity) {
        return categoryDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends Category> List<S> saveAllAndFlush(List<S> entities) {
        return categoryDAO.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categoryDAO.findAll(example, pageable);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id).get();
    }

    @Override
    public void deleteInBatch(List<Category> entities) {
        categoryDAO.deleteInBatch(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return categoryDAO.existsById(id);
    }

    @Override
    public <S extends Category> long count(Example<S> example) {
        return categoryDAO.count(example);
    }

    @Override
    public void deleteAllInBatch(List<Category> entities) {
        categoryDAO.deleteAllInBatch(entities);
    }

    @Override
    public <S extends Category> boolean exists(Example<S> example) {
        return categoryDAO.exists(example);
    }

    @Override
    public void deleteAllByIdInBatch(List<Integer> ids) {
        categoryDAO.deleteAllByIdInBatch(ids);
    }

    @Override
    public <S extends Category, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return categoryDAO.findBy(example, queryFunction);
    }

    @Override
    public long count() {
        return categoryDAO.count();
    }

    @Override
    public void deleteAllInBatch() {
        categoryDAO.deleteAllInBatch();
    }

    @Override
    public void deleteById(Integer id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public Category getOne(Integer id) {
        return categoryDAO.getOne(id);
    }

    @Override
    public void delete(Category entity) {
        categoryDAO.delete(entity);
    }

    @Override
    public Category getById(Integer id) {
        return categoryDAO.getById(id);
    }

    @Override
    public void deleteAllById(List<? extends Integer> ids) {
        categoryDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<? extends Category> entities) {
        categoryDAO.deleteAll(entities);
    }

    @Override
    public Category getReferenceById(Integer id) {
        return categoryDAO.getReferenceById(id);
    }

    @Override
    public void deleteAll() {
        categoryDAO.deleteAll();
    }

    @Override
    public <S extends Category> List<S> findAll(Example<S> example) {
        return categoryDAO.findAll(example);
    }

    @Override
    public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
        return categoryDAO.findAll(example, sort);
    }

}
