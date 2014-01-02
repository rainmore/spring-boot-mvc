package au.com.rainmore.platform.web.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public abstract class GenericService<Model, ID extends Serializable> {

    protected JpaRepository<Model, ID> repository;

//    public List<Model> findAll() {
//        return repository.findAll();
//    }

//    public Model save(Model model) {
//        return repository.save(model);
//    }
//
//    public Model findOne(ID id) {
//        return repository.findOne(id);
//    }

}
