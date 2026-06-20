package com.srgec.Notes_Management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String title;

    @Column(length = 2000)
    private String content;

    @Column
    private String category;

    public Note(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}