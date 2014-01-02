package au.com.rainmore.platform.web.services;

import au.com.rainmore.platform.web.dao.PersonRepository;
import au.com.rainmore.platform.web.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends GenericService<Person, Long> {

    @Autowired
    protected PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person save(Person model) {
        return repository.save(model);
    }

    public Person findOne(Long id) {
        return repository.findOne(id);
    }
}
