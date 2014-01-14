package au.com.rainmore.platform.web.services;

import java.util.List;

import au.com.rainmore.platform.web.dao.GenericRepository;
import au.com.rainmore.platform.web.models.GenericModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

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
