package ua.com.alevel.dto;

import ua.com.alevel.entity.Note;

import java.util.Date;

public class NoteDto {

    private String title;
    private String description;
    private String authorEmail;
    private Date createdDate;

    public NoteDto() { }

    public NoteDto(Note note) {
        this.title = note.getTitle();
        this.description = note.getDescription();
        this.authorEmail = note.getAuthorEmail();
        this.createdDate = note.getCreatedDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
