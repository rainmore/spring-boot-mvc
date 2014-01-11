package net.rainmore.platform.web.persistent.repositories;

import net.rainmore.platform.web.persistent.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
