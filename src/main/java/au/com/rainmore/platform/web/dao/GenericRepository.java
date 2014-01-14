package au.com.rainmore.platform.web.dao;

import au.com.rainmore.platform.web.models.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface GenericRepository<T extends GenericModel, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor {
}
