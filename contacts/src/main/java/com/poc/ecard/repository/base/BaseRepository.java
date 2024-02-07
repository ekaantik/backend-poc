package com.poc.ecard.repository.base;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T, ID>
        extends PagingAndSortingRepository<T, ID>, QuerydslPredicateExecutor<T> {

}
