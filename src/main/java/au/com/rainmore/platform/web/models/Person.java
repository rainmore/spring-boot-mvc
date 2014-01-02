package au.com.rainmore.platform.web.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person extends GenericModel {
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = true)
    private String middleName;
    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
