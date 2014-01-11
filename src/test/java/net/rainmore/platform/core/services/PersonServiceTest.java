package net.rainmore.platform.core.services;

import net.rainmore.platform.core.models.Person;
import net.rainmore.platform.core.services.fixtures.PersonFixture;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest extends GenericServiceTest {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceTest.class);

    @Autowired
    private PersonService personService;

    private PersonFixture fixture = new PersonFixture();
    private List<Person> list = new ArrayList<Person>();
    private Person person;

    @Transactional
    @Before
    public void setup() {
        super.setup();

        for (int i = 0; i < 10; i++) {
            list.add(fixture.getOne());
        }

        person = fixture.getOne();

        LocalDateTime signalbetime = LocalDateTime.now().minusDays(1);
        logger.info(signalbetime.toString());

        person.setCreatedTime(signalbetime);
        person.setUpdatedTime(signalbetime);
        personService.save(person);
        personService.flush();

        logger.info(person.getCreatedTime().toString());
        logger.info(person.getUpdatedTime().toString());
    }

    @Transactional
    @Test
    public void testSave() {
        Person person = fixture.getOne();

        personService.saveAndFlush(person);

        Assert.assertTrue(personService.exists(person.getId()));

        Assert.assertNotNull(person.getCreatedTime());
        Assert.assertNotNull(person.getUpdatedTime());
        Assert.assertNotNull(person.isActive());
        Assert.assertTrue(person.isActive());
        Assert.assertNotNull(person.isArchived());
        Assert.assertFalse(person.isArchived());

        logger.info(person.toString());

    }

    @Transactional
    @Test
    public void testUpdate() {

        logger.info(person.getFirstName());
        person.setFirstName(StringUtils.capitalize(RandomStringUtils.randomAlphabetic(10)));
        personService.saveAndFlush(person);
        logger.info(person.getFirstName());
        logger.info(person.getCreatedTime().toString());
        logger.info(person.getUpdatedTime().toString());

        LocalDate date = LocalDate.now();

        Assert.assertNotNull(person.getId());

        Assert.assertTrue(person.getDateOfBirth().toDate().compareTo(date.toDate()) < 0);
        Assert.assertNotNull(person.getFirstName());
        Assert.assertNotNull(person.getLastName());
        Assert.assertTrue(person.isActive());
        Assert.assertFalse(person.isArchived());

        Assert.assertNotEquals(person.getCreatedTime(), person.getUpdatedTime());
    }

    @Test
    public void testFindAll() {
        for (Person person: list) {
            personService.save(person);
        }

        Assert.assertTrue(personService.count() >= 10);

        List<Person> l = personService.findAll();
        Assert.assertFalse(l.isEmpty());
        Assert.assertTrue(l.size() >= 10);
    }

    @Test
    public void testDelete() {
        Person person1 = fixture.getOne();
        Person person2 = fixture.getOne();
        personService.saveAndFlush(person1);
        personService.saveAndFlush(person2);

        Long id1 = person1.getId().longValue();
        Long id2 = person2.getId().longValue();

        Assert.assertNotNull(id1);
        Assert.assertNotNull(id2);

        personService.delete(person1);
        personService.delete(id2);

        Assert.assertFalse(personService.exists(id1));
        Assert.assertFalse(personService.exists(id2));

    }
}
