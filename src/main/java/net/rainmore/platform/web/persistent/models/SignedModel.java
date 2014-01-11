package net.rainmore.platform.web.persistent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.rainmore.platform.web.config.json.JsonCustomDateTimeDeserializer;
import net.rainmore.platform.web.config.json.JsonCustomDateTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class SignedModel extends GenericModel implements Signable {
    @Column(updatable= false, columnDefinition = "datetime", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = JsonCustomDateTimeSerializer.class)
    @JsonDeserialize(using = JsonCustomDateTimeDeserializer.class)
    @JsonIgnore
    protected LocalDateTime createdTime;

    @Column(columnDefinition = "datetime", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = JsonCustomDateTimeSerializer.class)
    @JsonDeserialize(using = JsonCustomDateTimeDeserializer.class)
    @JsonIgnore
    protected LocalDateTime updatedTime;

    @PrePersist
    public void prePersist() {
        if(createdTime == null) //We set default value in case if the value is not set yet.
            createdTime = LocalDateTime.now();
        if (updatedTime == null)
            updatedTime = LocalDateTime.now();


    }

    @PreUpdate
    public void preUpdate() {
        updatedTime = LocalDateTime.now();
    }

    @Override
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
