package com.senla.catalog.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "catalog", catalog = "")
@IdClass(CommentEntityPK.class)
public class CommentEntity {
    private int commentId;
    private int advertId;
    private int userId;
    private String text;

    @Id
    @Column(name = "comment_id")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Id
    @Column(name = "advert_id")
    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (advertId != that.advertId) return false;
        if (userId != that.userId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + advertId;
        result = 31 * result + userId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
