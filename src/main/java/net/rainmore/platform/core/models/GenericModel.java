package net.rainmore.platform.core.models;

import javax.persistence.*;

@MappedSuperclass
public class GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected Boolean active = false;

    @Column
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

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean isActive() {
        return active;
    }

    public Boolean isArchived() {
        return archived;
    }
}
