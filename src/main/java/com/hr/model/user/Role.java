package com.hr.model.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String role;

    public Role() {

    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }


}
