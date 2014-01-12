package net.rainmore.platform.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.rainmore.platform.core.helpers.json.JsonCustomDateTimeDeserializer;
import net.rainmore.platform.core.helpers.json.JsonCustomDateTimeSerializer;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account extends SignedModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="personId", columnDefinition = "BIGINT UNSIGNED NOT NULL")
    private Person person;

    @Column(unique = true, nullable = false)
    @Email
    @Size(min = 6, max = 100)
    private String email;

    @Column(unique = true)
    @Size(min = 6, max = 100)
    private String nickName;

    @Column(nullable = false)
    @Size(min = 6, max = 100)
    private String password;

    @Column(columnDefinition = "datetime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = JsonCustomDateTimeSerializer.class)
    @JsonDeserialize(using = JsonCustomDateTimeDeserializer.class)
    private LocalDateTime lastLoginTime;
}
