package net.rainmore.platform.core.services;

import net.rainmore.platform.core.repositories.GenericModelRepository;
import net.rainmore.platform.core.repositories.PersonRepository;
import net.rainmore.platform.core.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends GenericModelService<Person, Long> {

    @Autowired
    private PersonRepository repository;

    @Override
    protected GenericModelRepository<Person, Long> getRepository() {
        return repository;
    }
}
