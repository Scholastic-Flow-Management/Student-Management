package com.SFM.Student_Management.service.Admin;

import com.SFM.Student_Management.entities.User;
import com.SFM.Student_Management.enums.UserRole;
import com.SFM.Student_Management.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void CreateAdminAccount() {
        User AdminAccount = UserRepository.findByRole(UserRole.Admin);
        if (AdminAccount == null) {
            User Admin = new User();
            Admin.setEmail("admin@test.com");
            Admin.setName("admin");
            Admin.setRole(UserRole.Admin);
            Admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(Admin);
        }
    }
}
