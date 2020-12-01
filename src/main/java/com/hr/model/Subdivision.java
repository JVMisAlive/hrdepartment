package com.hr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subdivision")
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "subdivisions_posts",
            joinColumns = @JoinColumn(name = "subdivision_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> postSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }
}
