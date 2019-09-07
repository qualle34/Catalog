package com.senla.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CommentEntityPK implements Serializable {
    private int commentId;
    private int advertId;
    private int userId;

    @Column(name = "comment_id")
    @Id
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Column(name = "advert_id")
    @Id
    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntityPK that = (CommentEntityPK) o;

        if (commentId != that.commentId) return false;
        if (advertId != that.advertId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + advertId;
        result = 31 * result + userId;
        return result;
    }
}
