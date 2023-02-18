package com.driver.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    @ManyToOne
    @JoinColumn
    private User user;
    @OneToOne(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image>ImageList;

    public Blog() {
    }

    public Blog(User user,String title, String content) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Blog(String title, String content, User user, List<Image>ImageList) {
        this.title = title;
        this.content = content;
        this.user=user;
        this.ImageList=ImageList;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return ImageList;
    }

    public void setImageList(List<Image> ImageList) {
        this.ImageList = ImageList;
    }
}