CREATE TABLE Roles (
    role_id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role_name VARCHAR(20),
    description VARCHAR(255),
    priority INT NOT NULL DEFAULT -1
);

CREATE TABLE Permissions (
    permission_id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    permission_name VARCHAR(255)
);

CREATE TABLE Accounts (
    user_id VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Groups (
    group_id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    group_name VARCHAR(255),
    description VARCHAR(255)
);

--CREATE TABLE USER_ROLE (
--    user_id VARCHAR(255),
--    user_role VARCHAR(20),
--    PRIMARY KEY (user_id, user_role),
--    FOREIGN KEY (user_id) REFERENCES Accounts(user_id),
--    FOREIGN KEY (user_role) REFERENCES Roles(user_role)
--);

CREATE TABLE User_Group (
    user_id VARCHAR(255),
    group_id INT,
    PRIMARY KEY (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES Accounts(user_id),
    FOREIGN KEY (group_id) REFERENCES Groups(group_id)
);

CREATE TABLE Group_Role (
    group_id INT,
    role_id INT,
    PRIMARY KEY (group_id, role_id),
    FOREIGN KEY (group_id) REFERENCES Groups(group_id),
    FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);

CREATE TABLE Role_Permission (
    permission_id INT,
    role_id INT,
    PRIMARY KEY (permission_id, role_id),
    FOREIGN KEY (permission_id) REFERENCES Permissions(permission_id),
    FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);

INSERT INTO Roles (role_name, description, priority) VALUES
('Admin', 'Has full system access', 1),
('Editor', 'Can edit existing entries', 2),
('Moderator', 'Can delete posts or ban users', 3),
('Viewer', 'Can view contents', 4),
('Author', 'Can create new posts', 5),
('Audit', 'Can access system logs', 6),
('Guest', 'Has limited access', 7),
('Developer', 'Access to development tools', 8),
('Support', 'Can interact with customer support queries', 9),
('Marketing', 'Can access marketing tools', 10);

INSERT INTO Permissions (permission_name) VALUES
('create'),
('read'),
('update'),
('delete'),
('upload'),
('download'),
('share'),
('view_logs'),
('change_settings'),
('execute_scripts');

INSERT INTO Accounts (user_id, password, phone_number, email) VALUES
('user01', 'pass01', '1234567890', 'user01@example.com'),
('user02', 'pass02', '2345678901', 'user02@example.com'),
('user03', 'pass03', '3456789012', 'user03@example.com'),
('user04', 'pass04', '4567890123', 'user04@example.com'),
('user05', 'pass05', '5678901234', 'user05@example.com'),
('user06', 'pass06', '6789012345', 'user06@example.com'),
('user07', 'pass07', '7890123456', 'user07@example.com'),
('user08', 'pass08', '8901234567', 'user08@example.com'),
('user09', 'pass09', '9012345678', 'user09@example.com'),
('user10', 'pass10', '0123456789', 'user10@example.com');

INSERT INTO Groups (group_name, description) VALUES
('Group A', 'First group of users'),
('Group B', 'Second group of users'),
('Group C', 'Third group of users'),
('Group D', 'Fourth group of users'),
('Group E', 'Fifth group of users'),
('Group F', 'Sixth group of users'),
('Group G', 'Seventh group of users'),
('Group H', 'Eighth group of users'),
('Group I', 'Ninth group of users'),
('Group J', 'Tenth group of users');

--INSERT INTO User_Group (user_id, group_id) VALUES
--('user01', 1),
--('user02', 2),
--('user03', 3),
--('user04', 4),
--('user05', 5),
--('user06', 6),
--('user07', 7),
--('user08', 8),
--('user09', 9),
--('user10', 10);

INSERT INTO Group_Role (group_id, role_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO Role_Permission (permission_id, role_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
