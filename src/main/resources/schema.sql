-- Drop tables if they exist (for clean restart)
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