package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libro")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    private Long id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Autor> authors;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Autor> translators;

    @ElementCollection
    private List<String> subjects;

    @ElementCollection
    private List<String> bookshelves;

    @ElementCollection
    private List<String> languages;

    private Boolean copyright;
    private String media_type;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Format formats;

    private int download_count;

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

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public List<Autor> getTranslators() {
        return translators;
    }

    public void setTranslators(List<Autor> translators) {
        this.translators = translators;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }


//    public Format getFormats() {
//        return formats;
//    }
//
//    public void setFormats(Format formats) {
//        this.formats = formats;
//    }


    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", translators=" + translators +
                ", subjects=" + subjects +
                ", bookshelves=" + bookshelves +
                ", languages=" + languages +
                ", copyright=" + copyright +
                ", media_type='" + media_type + '\'' +
                ", download_count=" + download_count +
                '}';
    }
}
