package com.ikigai.kiwi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ikigai.kiwi.entity.Story;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface StoryService {

    <S extends Story> S save(S entity);

    <S extends Story> Optional<S> findOne(Example<S> example);

    List<Story> findAll();

    Page<Story> findAll(Pageable pageable);

    List<Story> findAll(Sort sort);

    List<Story> findAllById(List<Integer> ids);

    <S extends Story> List<S> saveAll(List<S> entities);

    void flush();

    <S extends Story> S saveAndFlush(S entity);

    <S extends Story> List<S> saveAllAndFlush(List<S> entities);

    <S extends Story> Page<S> findAll(Example<S> example, Pageable pageable);

    Story findById(Integer id);

    void deleteInBatch(List<Story> entities);

    boolean existsById(Integer id);

    <S extends Story> long count(Example<S> example);

    void deleteAllInBatch(List<Story> entities);

    <S extends Story> boolean exists(Example<S> example);

    void deleteAllByIdInBatch(List<Integer> ids);

    <S extends Story, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    long count();

    void deleteAllInBatch();

    void deleteById(Integer id);

    Story getOne(Integer id);

    void delete(Story entity);

    Story getById(Integer id);

    void deleteAllById(List<? extends Integer> ids);

    void deleteAll(List<? extends Story> entities);

    Story getReferenceById(Integer id);

    void deleteAll();

    <S extends Story> List<S> findAll(Example<S> example);

    <S extends Story> List<S> findAll(Example<S> example, Sort sort);

    List<Story> findByNameStory(String name);

    List<Story> findAllStoryNotDeleted();

    void deleteStory(Integer id);

    Story create(JsonNode storyData);
}
