package net.rainmore.platform.web.persistent.services;

import net.rainmore.platform.web.persistent.repositories.PersonRepository;
import net.rainmore.platform.web.persistent.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends GenericService<Person, Long> {

    @Autowired
    private PersonRepository repository;

    @Override
    protected JpaRepository<Person, Long> getRepository() {
        return repository;
    }
}
