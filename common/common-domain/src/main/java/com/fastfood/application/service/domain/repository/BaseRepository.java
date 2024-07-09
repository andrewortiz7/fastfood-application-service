package com.fastfood.application.service.domain.repository;

import com.fastfood.application.service.domain.entity.BaseEntity;
import com.fastfood.application.service.domain.valueobject.BaseId;

import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends BaseId<?>>{
    E save(E entity);
    Optional<E> findById(ID id);
}
