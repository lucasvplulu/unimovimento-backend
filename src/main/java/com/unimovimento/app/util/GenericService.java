package com.unimovimento.app.util;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author lkogici
 * @param <T> Type of desired value object
 */
public interface GenericService<T> {
    public List<T> findAll();
    public T findById(UUID id);
    public T create(T element);
    public T update(UUID id, T newElement);
    public Boolean delete(UUID id);
}