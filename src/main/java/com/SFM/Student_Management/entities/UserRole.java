package com.SFM.Student_Management.entities;

import com.SFM.Student_Management.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Entity
@Table(name = "user_role", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @EmbeddedId
    private UserPerRole userPerRole;

}

@Embeddable
class UserPerRole {
    @Column(name = "user_role")
    private Role role;
    @Column(name = "user_id")
    private String userId;
}
