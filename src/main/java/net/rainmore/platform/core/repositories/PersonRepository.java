package net.rainmore.platform.core.repositories;

import net.rainmore.platform.core.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
