package com.codeup.initalspring.models;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn (name="user_id")
    private Post post;

    public Post() {}

    public Post(long id, String title, String body, User owner) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.owner = user;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public Post getPost() {
        return post;
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

    public void setPost(Post post) {
        this.post = post;
    }
}
