package net.rainmore.platform.core.services;

import net.rainmore.platform.core.models.Person;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class PersonServiceTest extends GenericServiceTest {

    @Autowired
    private PersonService personService;


    @Test
    public void testSave() {
        Person person = new Person();
        person.setFirstName(RandomStringUtils.randomAlphabetic(10));
        person.setLastName(RandomStringUtils.randomAlphabetic(10));

        Random random = new Random();
        int number = random.nextInt(12) + 1;
        person.setDateOfBirth(LocalDate.now().minusMonths(number).toDate());

        personService.save(person);
        Assert.assertTrue(person.getId() != null);
    }
}
