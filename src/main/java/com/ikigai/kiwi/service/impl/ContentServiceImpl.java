package com.ikigai.kiwi.service.impl;

import com.ikigai.kiwi.dao.ContentDAO;
import com.ikigai.kiwi.entity.Content;
import com.ikigai.kiwi.service.ContentService;
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
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentDAO contentDAO;

    @Override
    public <S extends Content> S save(S entity) {
        return contentDAO.save(entity);
    }

    @Override
    public <S extends Content> Optional<S> findOne(Example<S> example) {
        return contentDAO.findOne(example);
    }

    @Override
    public List<Content> findAll() {
        return contentDAO.findAll();
    }

    @Override
    public Page<Content> findAll(Pageable pageable) {
        return contentDAO.findAll(pageable);
    }

    @Override
    public List<Content> findAll(Sort sort) {
        return contentDAO.findAll(sort);
    }

    @Override
    public List<Content> findAllById(List<Integer> ids) {
        return contentDAO.findAllById(ids);
    }

    @Override
    public <S extends Content> List<S> saveAll(List<S> entities) {
        return contentDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        contentDAO.flush();
    }

    @Override
    public <S extends Content> S saveAndFlush(S entity) {
        return contentDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends Content> List<S> saveAllAndFlush(List<S> entities) {
        return contentDAO.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Content> Page<S> findAll(Example<S> example, Pageable pageable) {
        return contentDAO.findAll(example, pageable);
    }

    @Override
    public Content findById(Integer id) {
        return contentDAO.findById(id).get();
    }

    @Override
    public void deleteInBatch(List<Content> entities) {
        contentDAO.deleteInBatch(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return contentDAO.existsById(id);
    }

    @Override
    public <S extends Content> long count(Example<S> example) {
        return contentDAO.count(example);
    }

    @Override
    public void deleteAllInBatch(List<Content> entities) {
        contentDAO.deleteAllInBatch(entities);
    }

    @Override
    public <S extends Content> boolean exists(Example<S> example) {
        return contentDAO.exists(example);
    }

    @Override
    public void deleteAllByIdInBatch(List<Integer> ids) {
        contentDAO.deleteAllByIdInBatch(ids);
    }

    @Override
    public <S extends Content, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return contentDAO.findBy(example, queryFunction);
    }

    @Override
    public long count() {
        return contentDAO.count();
    }

    @Override
    public void deleteAllInBatch() {
        contentDAO.deleteAllInBatch();
    }

    @Override
    public void deleteById(Integer id) {
        contentDAO.deleteById(id);
    }

    @Override
    public Content getOne(Integer id) {
        return contentDAO.getOne(id);
    }

    @Override
    public void delete(Content entity) {
        contentDAO.delete(entity);
    }

    @Override
    public Content getById(Integer id) {
        return contentDAO.getById(id);
    }

    @Override
    public void deleteAllById(List<? extends Integer> ids) {
        contentDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<? extends Content> entities) {
        contentDAO.deleteAll(entities);
    }

    @Override
    public Content getReferenceById(Integer id) {
        return contentDAO.getReferenceById(id);
    }

    @Override
    public void deleteAll() {
        contentDAO.deleteAll();
    }

    @Override
    public <S extends Content> List<S> findAll(Example<S> example) {
        return contentDAO.findAll(example);
    }

    @Override
    public <S extends Content> List<S> findAll(Example<S> example, Sort sort) {
        return contentDAO.findAll(example, sort);
    }
}
