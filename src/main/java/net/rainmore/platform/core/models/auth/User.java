package net.rainmore.platform.core.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.rainmore.platform.core.models.GenericModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 6, max = 100)
    private String username;

    @Column(nullable = false)
    @NotNull
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    @JsonIgnore
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString() {
        return String.format("id: %d, username: %s", getId(), getUsername());
    }
}
