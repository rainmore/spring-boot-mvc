package net.rainmore.platform.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public abstract class GenericService<Model, ID extends Serializable> {

    protected abstract JpaRepository<Model, ID> getRepository();

    public List<Model> findAll() {
        return getRepository().findAll();
    }

    public Page<Model> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public Model save(Model model) {
        return getRepository().save(model);
    }

    public Model findOne(ID id) {
        return getRepository().findOne(id);
    }

    public void delete(Model model) {
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

    public void saveAndFlush(Model model) {
        getRepository().saveAndFlush(model);
    }

}
