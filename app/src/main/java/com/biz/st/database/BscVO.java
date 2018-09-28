package com.biz.st.database;

public class BscVO {

    public String no;
    public String bsc;
    public String genre;
    public String title;
    public String memo;
    private String link;
    public String fav;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBsc() {
        return bsc;
    }

    public void setBsc(String bsc) {
        this.bsc = bsc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "BscVO{" +
                "no='" + no + '\'' +
                ", bsc='" + bsc + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", memo='" + memo + '\'' +
                ", link='" + link + '\'' +
                ", fav='" + fav + '\'' +
                '}';
    }
}
