package ua.com.alevel.dto;

import ua.com.alevel.entity.Author;

public class AuthorDto {

    private String firstName;
    private String secondName;
    private String email;

    public AuthorDto() { }

    public AuthorDto(Author author) {
        this.email = author.getEmail();
        this.firstName = author.getFirstName();
        this.secondName = author.getSecondName();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
