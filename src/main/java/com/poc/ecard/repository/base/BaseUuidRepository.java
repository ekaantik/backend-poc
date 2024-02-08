package com.poc.ecard.repository.base;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseUuidRepository<T> extends BaseRepository<T, UUID> {

}
