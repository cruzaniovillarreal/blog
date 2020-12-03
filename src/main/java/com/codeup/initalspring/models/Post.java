package com.codeup.initalspring.models;

import jdk.jfr.Category;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ads_categories",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<PostCategory> categories;

//    @ManyToOne
//    @JoinColumn (name="user_id")

//    private Post post;

    public Post() {}

    //READ
    public Post(long id, String title, String body, User owner, List<PostImage> images) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.images = images;
    }

    //CREATE
    public Post(String title, String body, User user, List<PostImage> images) {
        this.title = title;
        this.body = body;
        this.owner = user;
        this.images = images;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public List<PostCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PostCategory> categories) {
        this.categories = categories;
    }

}
