package com.SFM.Student_Management.repositories;

import com.SFM.Student_Management.entities.User;
import com.SFM.Student_Management.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


     static User findByRole(UserRole userRole){
         return null;
     }

    Optional<User> findFirstByEmail(String email);
}
