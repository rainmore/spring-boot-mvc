package au.com.rainmore.platform.web.dao;

import au.com.rainmore.platform.web.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
