package com.ikigai.kiwi.service;

import com.ikigai.kiwi.entity.Content;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ContentService {
    <S extends Content> S save(S entity);

    <S extends Content> Optional<S> findOne(Example<S> example);

    List<Content> findAll();

    Page<Content> findAll(Pageable pageable);

    List<Content> findAll(Sort sort);

    List<Content> findAllById(List<Integer> ids);

    <S extends Content> List<S> saveAll(List<S> entities);

    void flush();

    <S extends Content> S saveAndFlush(S entity);

    <S extends Content> List<S> saveAllAndFlush(List<S> entities);

    <S extends Content> Page<S> findAll(Example<S> example, Pageable pageable);

    Content findById(Integer id);

    void deleteInBatch(List<Content> entities);

    boolean existsById(Integer id);

    <S extends Content> long count(Example<S> example);

    void deleteAllInBatch(List<Content> entities);

    <S extends Content> boolean exists(Example<S> example);

    void deleteAllByIdInBatch(List<Integer> ids);

    <S extends Content, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    long count();

    void deleteAllInBatch();

    void deleteById(Integer id);

    Content getOne(Integer id);

    void delete(Content entity);

    Content getById(Integer id);

    void deleteAllById(List<? extends Integer> ids);

    void deleteAll(List<? extends Content> entities);

    Content getReferenceById(Integer id);

    void deleteAll();

    <S extends Content> List<S> findAll(Example<S> example);

    <S extends Content> List<S> findAll(Example<S> example, Sort sort);
}
