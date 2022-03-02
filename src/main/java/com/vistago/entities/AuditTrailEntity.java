package com.vistago.entities;


import com.vistago.listener.AuditTrailListener;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@RevisionEntity(AuditTrailListener.class)
@Table(name = "audit_trail_entity")
public class AuditTrailEntity extends DefaultRevisionEntity {
    @Column(name = "comments", length = 255)
    private String comments;

    @Column(name = "url", length = 1000)
    private String url;

    @Column(name = "action", length = 100)
    private String action;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
