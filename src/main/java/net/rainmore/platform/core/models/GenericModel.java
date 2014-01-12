package net.rainmore.platform.core.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@MappedSuperclass
public abstract class GenericModel implements Model, Activable, Archivable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    protected Long id;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT TRUE")
    @Type(type="org.hibernate.type.NumericBooleanType")
    protected Boolean active = true;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT FALSE")
    @Type(type="org.hibernate.type.NumericBooleanType")
    protected Boolean archived = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getArchived() {
        return archived;
    }

    @Override
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public Boolean isActive() {
        return active;
    }

    @Override
    public Boolean isArchived() {
        return archived;
    }
}
