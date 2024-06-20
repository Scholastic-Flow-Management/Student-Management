package com.SFM.Student_Management.enums;

public enum Role {
    SUPER_ADMIN(10, "Super Admin"),
    ADMIN(9, "Admin"),
    MANAGER(8, "Manager"),
    USER(1, "User");

    private int priority;
    private String description;

    Role(int priority, String description) {
    }
}
