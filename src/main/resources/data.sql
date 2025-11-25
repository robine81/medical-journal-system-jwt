INSERT INTO patients (first_name, last_name, personal_number, phone_number, email, address)
VALUES
    ('Anna', 'Andersson', '199001011234', '0701234567', 'anna.andersson@email.com', 'Storgatan 1, Stockholm'),
    ('Erik', 'Eriksson', '198505152345', '0702345678', 'erik.eriksson@email.com', 'Kungsgatan 15, Göteborg'),
    ('Maria', 'Karlsson', '199212123456', '0703456789', 'maria.karlsson@email.com', 'Drottninggatan 22, Malmö'),
    ('Johan', 'Johansson', '198808084567', '0704567890', 'johan.johansson@email.com', 'Vasagatan 8, Uppsala');

INSERT INTO medical_records (patient_id, diagnosis, treatment, notes, record_date, created_by)
VALUES
    (1, 'Förkylning', 'Vila och värktabletter', 'Patient har haft feber i 2 dagar', '2024-11-01', 'Dr. Svensson'),
    (1, 'Årskontroll', 'Inga åtgärder behövs', 'Allt ser bra ut', '2024-06-15', 'Dr. Lindgren'),
    (2, 'Högt blodtryck', 'Blodtrycksmedicin ordinerad', 'Kontroll om 3 månader', '2024-10-20', 'Dr. Svensson'),
    (2, 'Migrän', 'Smärtstillande medicin', 'Återkom vid behov', '2024-09-10', 'Dr. Berg'),
    (3, 'Astma', 'Inhalator ordinerad', 'Patient ska använda vid behov', '2024-11-10', 'Dr. Lindgren'),
    (4, 'Fotledsstukning', 'Tejpning och vila', 'Stukad under fotbollsmatch', '2024-11-15', 'Dr. Svensson');