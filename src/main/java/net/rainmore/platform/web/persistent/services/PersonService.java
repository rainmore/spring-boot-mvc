package net.rainmore.platform.web.persistent.services;

import net.rainmore.platform.web.persistent.repositories.PersonRepository;
import net.rainmore.platform.web.persistent.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends GenericService<Person, Long> {

    @Autowired
    protected PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Page<Person> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Person save(Person model) {
        return repository.save(model);
    }

    public Person findOne(Long id) {
        return repository.findOne(id);
    }

}
