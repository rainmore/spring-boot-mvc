package net.rainmore.platform.core.repository;

import net.rainmore.platform.core.models.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T extends GenericModel, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor {

    List<T> findById(ID id);
}
