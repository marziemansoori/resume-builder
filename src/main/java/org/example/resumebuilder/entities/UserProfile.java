package org.example.resumebuilder.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private int theme;

    @Column(columnDefinition="TEXT")
    private String summary;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;
}