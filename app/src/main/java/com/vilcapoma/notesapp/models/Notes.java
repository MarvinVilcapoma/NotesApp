package com.vilcapoma.notesapp.models;

import com.orm.dsl.Table;

@Table
public class Notes {
    private Long id;
    private String title;
    private int state;
    private String content;

    public Notes() {
    }

    public Notes(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", state=" + state +
                ", content='" + content + '\'' +
                '}';
    }
}

