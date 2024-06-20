package com.SFM.Student_Management.service.Admin;

import com.SFM.Student_Management.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
