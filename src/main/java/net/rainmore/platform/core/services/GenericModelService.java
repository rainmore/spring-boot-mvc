package net.rainmore.platform.core.services;

import net.rainmore.platform.core.models.GenericModel;
import net.rainmore.platform.core.repositories.GenericModelRepository;
import net.rainmore.platform.core.repositories.specifications.GenericModelSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class GenericModelService<GModel extends GenericModel, ID extends Long> extends GenericService<GModel, ID > {

    @SuppressWarnings("unchecked")
    protected abstract GenericModelRepository<GModel, ID> getRepository();

    @SuppressWarnings("unchecked")
    public void activate(GModel GModel) {
        GModel.setActive(true);
        getRepository().save(GModel);
    }

    @SuppressWarnings("unchecked")
    public void archive(GModel GModel) {
        GModel.setActive(false);
        GModel.setArchived(true);
        getRepository().save(GModel);
    }

    public Page<GModel> findAllActive(Pageable pageable) {
        return findAll(true, pageable);
    }

    public Page<GModel> findAllAvailable(Pageable pageable) {
        return findAllArchived(false, pageable);
    }

    public Page<GModel> findAllArchived(Pageable pageable) {
        return findAllArchived(true, pageable);
    }

    @SuppressWarnings("unchecked")
    public Page<GModel> findAllArchived(Boolean archived, Pageable pageable) {
        return getRepository().findAll(GenericModelSpecification.archivedSpecification(archived), pageable);
    }

    @SuppressWarnings("unchecked")
    public Page<GModel> findAll(Boolean active, Pageable pageable) {
        return findAll(active, false, pageable);
    }

    @SuppressWarnings("unchecked")
    public Page<GModel> findAll(Boolean active, Boolean archived, Pageable pageable) {
        return getRepository().findAll(GenericModelSpecification.activeSpecification(active, archived), pageable);
    }

}
