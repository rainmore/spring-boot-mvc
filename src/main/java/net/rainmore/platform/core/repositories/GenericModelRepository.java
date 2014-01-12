package net.rainmore.platform.core.repositories;

import net.rainmore.platform.core.models.GenericModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface GenericModelRepository<Model extends GenericModel, ID extends Long> extends JpaRepository<Model, ID>, JpaSpecificationExecutor {

    public List<Model> findByActive(Boolean active);

    public List<Model> findByArchived(Boolean archived);

    public List<Model> findByActiveTrueAndArchivedFalse();

}
