package net.rainmore.platform.core.services;

import net.rainmore.platform.core.models.Activable;
import net.rainmore.platform.core.models.GenericModel;
import net.rainmore.platform.core.repositories.GenericModelRepository;
import net.rainmore.platform.core.repositories.specifications.GenericModelSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class GenericModelService<Model extends GenericModel, ID extends Long> extends GenericService<Model, ID > {

    protected abstract GenericModelRepository getRepository();

    public void activate(Model model) {
        model.setActive(true);
        getRepository().save(model);
    }

    public void archive(Model model) {
        model.setActive(false);
        model.setArchived(true);
        getRepository().save(model);
    }

    public Page<Model> findAllActive(Pageable pageable) {
        return findAll(true, pageable);
    }

    public Page<Model> findAllAvailable(Pageable pageable) {
        return findAllArchived(false, pageable);
    }

    public Page<Model> findAllArchived(Pageable pageable) {
        return findAllArchived(true, pageable);
    }

    public Page<Model> findAllArchived(Boolean archived, Pageable pageable) {
        return getRepository().findAll(GenericModelSpecification.archivedSpecification(archived), pageable);
    }

    public Page<Model> findAll(Boolean active, Pageable pageable) {
        return findAll(active, false, pageable);
    }

    public Page<Model> findAll(Boolean active, Boolean archived, Pageable pageable) {
        return getRepository().findAll(GenericModelSpecification.activeSpecification(active, archived), pageable);
    }

}
