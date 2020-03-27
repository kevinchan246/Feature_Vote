package com.featurevote.domain;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    private Long id;
    private String name;
    private User user;
    private Set<Feature> features = new HashSet<>();
    private boolean published;


    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product") //e.g  when a product got deleted, all of its feature should be deleted
                                                                                        //be careful with CascadeType.ALL, if all the relation are related, and specified with CascadeType.ALL, when one of them gets deleted,
                                                                                        //    all of the related database gets deleted.
    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", features=" + features +
                ", published=" + published +
                '}';
    }
}
