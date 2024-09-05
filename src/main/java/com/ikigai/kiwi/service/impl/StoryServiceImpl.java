package com.ikigai.kiwi.service.impl;

import com.ikigai.kiwi.dao.StoryDAO;
import com.ikigai.kiwi.entity.Story;
import com.ikigai.kiwi.service.StoryService;
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
public class StoryServiceImpl implements StoryService {
    @Autowired
    StoryDAO storyDAO;

    @Override
    public <S extends Story> S save(S entity) {
        return storyDAO.save(entity);
    }

    @Override
    public <S extends Story> Optional<S> findOne(Example<S> example) {
        return storyDAO.findOne(example);
    }

    @Override
    public List<Story> findAll() {
        return storyDAO.findAll();
    }

    @Override
    public Page<Story> findAll(Pageable pageable) {
        return storyDAO.findAll(pageable);
    }

    @Override
    public List<Story> findAll(Sort sort) {
        return storyDAO.findAll(sort);
    }

    @Override
    public List<Story> findAllById(List<Integer> ids) {
        return storyDAO.findAllById(ids);
    }

    @Override
    public <S extends Story> List<S> saveAll(List<S> entities) {
        return storyDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        storyDAO.flush();
    }

    @Override
    public <S extends Story> S saveAndFlush(S entity) {
        return storyDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends Story> List<S> saveAllAndFlush(List<S> entities) {
        return storyDAO.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Story> Page<S> findAll(Example<S> example, Pageable pageable) {
        return storyDAO.findAll(example, pageable);
    }

    @Override
    public Story findById(Integer id) {
        return storyDAO.findById(id).get();
    }

    @Override
    public void deleteInBatch(List<Story> entities) {
        storyDAO.deleteInBatch(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return storyDAO.existsById(id);
    }

    @Override
    public <S extends Story> long count(Example<S> example) {
        return storyDAO.count(example);
    }

    @Override
    public void deleteAllInBatch(List<Story> entities) {
        storyDAO.deleteAllInBatch(entities);
    }

    @Override
    public <S extends Story> boolean exists(Example<S> example) {
        return storyDAO.exists(example);
    }

    @Override
    public void deleteAllByIdInBatch(List<Integer> ids) {
        storyDAO.deleteAllByIdInBatch(ids);
    }

    @Override
    public <S extends Story, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return storyDAO.findBy(example, queryFunction);
    }

    @Override
    public long count() {
        return storyDAO.count();
    }

    @Override
    public void deleteAllInBatch() {
        storyDAO.deleteAllInBatch();
    }

    @Override
    public void deleteById(Integer id) {
        storyDAO.deleteById(id);
    }

    @Override
    public Story getOne(Integer id) {
        return storyDAO.getOne(id);
    }

    @Override
    public void delete(Story entity) {
        storyDAO.delete(entity);
    }

    @Override
    public Story getById(Integer id) {
        return storyDAO.getById(id);
    }

    @Override
    public void deleteAllById(List<? extends Integer> ids) {
        storyDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<? extends Story> entities) {
        storyDAO.deleteAll(entities);
    }

    @Override
    public Story getReferenceById(Integer id) {
        return storyDAO.getReferenceById(id);
    }

    @Override
    public void deleteAll() {
        storyDAO.deleteAll();
    }

    @Override
    public <S extends Story> List<S> findAll(Example<S> example) {
        return storyDAO.findAll(example);
    }

    @Override
    public <S extends Story> List<S> findAll(Example<S> example, Sort sort) {
        return storyDAO.findAll(example, sort);
    }

}
