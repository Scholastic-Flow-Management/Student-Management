package com.SFM.Student_Management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "accounts", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Column(name = "is_active")
    private boolean isActive;
}
