package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GutendexBook {
    private String title;

    @JsonProperty("author_name")
    private String authorName;

    private String language;

    @JsonProperty("download_count")
    private int downloadCount;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("death_year")
    private String deathYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }
}
