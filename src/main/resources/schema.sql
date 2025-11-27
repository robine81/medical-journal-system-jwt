-- Drop tables if they exist (for clean restart)
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS medical_records;
DROP TABLE IF EXISTS patients;

-- Create Users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100)  -- Läkarens namn
);

-- Create Roles table
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Create User_Roles junction table (many-to-many)
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Create indexes
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_roles_name ON roles(name);

DROP TABLE IF EXISTS medical_records;
DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    personal_number VARCHAR(13) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE medical_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    diagnosis VARCHAR(255) NOT NULL,
    treatment TEXT,
    notes TEXT,
    record_date DATE NOT NULL,
    created_by VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);

-- Create indexes for better performance
CREATE INDEX idx_patient_personal_number ON patients(personal_number);
CREATE INDEX idx_medical_record_patient_id ON medical_records(patient_id);
CREATE INDEX idx_medical_record_date ON medical_records(record_date);