package net.rainmore.platform.core.models;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person extends SignedModel {

    @Column(nullable = false)
    @Size(min=2, max=50)
    @NotNull
    private String firstName;

    @Column(nullable = false)
    @Size(min=2, max=50)
    @NotNull
    private String lastName;

    @Column(nullable = true)
    private String middleName;

    @Column(columnDefinition = "DATE DEFAULT NULL")
//    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Past
    private LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        String date = null;
        if (dateOfBirth != null) {
            date = dateOfBirth.toString();
        }
        return String.format("[%s, %s, %s, %s]", firstName, lastName, middleName, date);
    }
}
