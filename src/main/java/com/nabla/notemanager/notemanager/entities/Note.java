package com.nabla.notemanager.notemanager.entities;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_id")
    private int note_id;

    @Column(name = "note_title")
    private String note_title;

    @Column(name = "note_description")
    private String note_description;

    @CreationTimestamp
    @Column(name = "created_date")
    private Calendar created_date;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Calendar updated_date;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_by")
    private int updatedBy;

    public enum CategoryName {
        project_task,project_plan,meetings,other
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_name")
    private CategoryName category_name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Note() {
    }

    public Note(int note_id, String note_title, String note_description, Calendar created_date, Calendar updated_date, int createdBy, int updatedBy, CategoryName category_name, User user) {
        this.note_id = note_id;
        this.note_title = note_title;
        this.note_description = note_description;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.category_name = category_name;
        this.user = user;
    }
    

    public int getNote_id() {
        return this.note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNote_title() {
        return this.note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_description() {
        return this.note_description;
    }

    public void setNote_description(String note_description) {
        this.note_description = note_description;
    }

    public Calendar getCreated_date() {
        return this.created_date;
    }

    public void setCreated_date(Calendar created_date) {
        this.created_date = created_date;
    }

    public Calendar getUpdated_date() {
        return this.updated_date;
    }

    public void setUpdated_date(Calendar updated_date) {
        this.updated_date = updated_date;
    }

    public int getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public CategoryName getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(CategoryName category_name) {
        this.category_name = category_name;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }    


    @Override
    public String toString() {
        return "{" +
            " note_id='" + getNote_id() + "'" +
            ", note_title='" + getNote_title() + "'" +
            ", note_description='" + getNote_description() + "'" +
            ", created_date='" + getCreated_date() + "'" +
            ", updated_date='" + getUpdated_date() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", category_name='" + getCategory_name() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}

// @Column(name = "user_id", columnDefinition = "INT", updatable = false, insertable = false)
// @JoinColumnOrFormula(onDelete = OnDeleteAction.CASCADE)
// private int user_id;

// @Column(name = "user_id", columnDefinition = "INT")
// @JoinColumnOrFormula(onDelete = OnDeleteAction.CASCADE)
// private int user_id;


