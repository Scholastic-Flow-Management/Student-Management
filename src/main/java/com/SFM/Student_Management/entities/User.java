package com.SFM.Student_Management.entities;

import com.SFM.Student_Management.enums.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Column(name = "is_active")
    private boolean isActive;
}
