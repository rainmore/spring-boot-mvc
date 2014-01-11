package net.rainmore.platform.core.services.fixtures;

import net.rainmore.platform.core.models.Person;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDate;
import org.thymeleaf.util.StringUtils;

import java.util.Random;

public class PersonFixture {

    public Person getOne() {
        Person person = new Person();
        person.setFirstName(StringUtils.capitalize(RandomStringUtils.randomAlphabetic(6)));
        person.setLastName(StringUtils.capitalize(RandomStringUtils.randomAlphabetic(9)));
        person.setDateOfBirth(dateOfBirth());
        return person;

    }

    private LocalDate dateOfBirth() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int year = random.nextInt(50) + 1;
        LocalDate date = LocalDate.now().minusMonths(month).minusYears(year);
        return date;
    }

}
