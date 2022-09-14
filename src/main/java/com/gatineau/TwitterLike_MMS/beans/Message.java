package com.gatineau.TwitterLike_MMS.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document("message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    private UUID _id;
    private String github_id;


    private String title;

    private String content;

    private Date date;
    public Message(String github_id, String title, String content, Date date){
        set_id();
        this.github_id = github_id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id() {
        this._id = UUID.randomUUID();
    }

    public String getGithub_id() {
        return github_id;
    }

    public void setGithub_id(String github_id) {
        this.github_id = github_id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
