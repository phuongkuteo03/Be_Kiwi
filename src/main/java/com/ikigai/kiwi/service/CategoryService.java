package com.ikigai.kiwi.service;

import com.ikigai.kiwi.entity.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CategoryService {
    <S extends Category> S save(S entity);

    <S extends Category> Optional<S> findOne(Example<S> example);

    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    List<Category> findAll(Sort sort);

    List<Category> findAllById(List<Integer> ids);

    <S extends Category> List<S> saveAll(List<S> entities);

    void flush();

    <S extends Category> S saveAndFlush(S entity);

    <S extends Category> List<S> saveAllAndFlush(List<S> entities);

    <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

    Category findById(Integer id);

    void deleteInBatch(List<Category> entities);

    boolean existsById(Integer id);

    <S extends Category> long count(Example<S> example);

    void deleteAllInBatch(List<Category> entities);

    <S extends Category> boolean exists(Example<S> example);

    void deleteAllByIdInBatch(List<Integer> ids);

    <S extends Category, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    long count();

    void deleteAllInBatch();

    void deleteById(Integer id);

    Category getOne(Integer id);

    void delete(Category entity);

    Category getById(Integer id);

    void deleteAllById(List<? extends Integer> ids);

    void deleteAll(List<? extends Category> entities);

    Category getReferenceById(Integer id);

    void deleteAll();

    <S extends Category> List<S> findAll(Example<S> example);

    <S extends Category> List<S> findAll(Example<S> example, Sort sort);
}
