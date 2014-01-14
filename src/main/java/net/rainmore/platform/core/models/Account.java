package net.rainmore.platform.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account extends GenericModel {

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 100)
    @NotNull
    private String username;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    @NotNull
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="personId")
    @JsonIgnore
    private Person person;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date lastLogInDate;

    @Column
    private Boolean rememberMe = false;

    @PrePersist
    public void prePersist() {
        if(lastLogInDate == null) //We set default value in case if the value is not set yet.
            lastLogInDate = LocalDateTime.now().toDate();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
