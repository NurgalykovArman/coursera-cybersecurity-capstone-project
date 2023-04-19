package com.example.DB;

public class Post {
    private Long id;
    private Long authod_id;
    private String author_name;
    private String title;
    private String content;
    private String post_date;

    public Post(Long id, Long authod_id, String author_name, String title, String content, String post_date) {
        this.id = id;
        this.authod_id = authod_id;
        this.author_name = author_name;
        this.title = title;
        this.content = content;
        this.post_date = post_date;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Post(Long authod_id, String author_name, String title, String content, String post_date) {
        this.authod_id = authod_id;
        this.author_name = author_name;
        this.title = title;
        this.content = content;
        this.post_date = post_date;
    }



    public Post() {
    }

    public Post(Long id, Long authod_id, String title, String content, String post_date) {
        this.id = id;
        this.authod_id = authod_id;
        this.title = title;
        this.content = content;
        this.post_date = post_date;
    }

    public Post(Long authod_id, String title, String content, String post_date) {
        this.authod_id = authod_id;
        this.title = title;
        this.content = content;
        this.post_date = post_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthod_id() {
        return authod_id;
    }

    public void setAuthod_id(Long authod_id) {
        this.authod_id = authod_id;
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

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }
}
