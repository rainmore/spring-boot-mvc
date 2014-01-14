package net.rainmore.platform.core.services;

import java.util.List;

import net.rainmore.platform.core.repository.GenericRepository;
import net.rainmore.platform.core.models.GenericModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public abstract class GenericService<T extends GenericModel, ID extends Serializable> {

    protected abstract GenericRepository<T, ID> getRepository();

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public T save(T model) {
        return getRepository().save(model);
    }

    public T findOne(ID id) {
        return getRepository().findOne(id);
    }

    public void delete(T model) {
        getRepository().delete(model);
    }

    public void delete(ID id) {
        getRepository().delete(id);

    }

    public Boolean exists(ID id) {
        return getRepository().exists(id);
    }

    public long count() {
        return getRepository().count();
    }

    public void flush() {
        getRepository().flush();
    }

    public void saveAndFlush(T model) {
        getRepository().saveAndFlush(model);
    }

    public List<T> save(Iterable<T> entities) {
        return getRepository().save(entities);
    }

    public List<T> findAll(Iterable<ID> ids) {
        return getRepository().findAll(ids);
    }
}
