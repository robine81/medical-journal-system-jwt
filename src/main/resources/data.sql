    -- Roller
    INSERT INTO roles(name) VALUES ('USER');   -- Patient
    INSERT INTO roles(name) VALUES ('ADMIN');  -- Läkare

    -- Läkare (användarnamn = deras namn)
    INSERT INTO users(username, password, full_name)
    VALUES ('dr.svensson', '$2a$12$hHPNY3T.0lKffbj4qCIskuBAk5FA1w8h6hdnufq4B/e.AJ3/oW76y', 'Dr. Svensson');

    INSERT INTO users(username, password, full_name)
    VALUES ('dr.lindgren', '$2a$12$CXqSeBneszgxnW96G8KDZuk44Px5KeBTN3BHGnZKqv1jv8nkZBrTC', 'Dr. Lindgren');
    INSERT INTO user_roles(user_id, role_id) VALUES (1, 2); -- dr.svensson → ADMIN
    INSERT INTO user_roles(user_id, role_id) VALUES (2, 2); -- dr.lindgren → ADMIN

    INSERT INTO users(username, password, full_name)
    VALUES ('anna.andersson', '$2a$12$VAbgw3A6dpd75tEUudrqXOlelyuqecc54N9WNfxN7zStPQV7aY8EO', 'Anna Andersson');
    INSERT INTO user_roles(user_id, role_id) VALUES (3, 1); -- anna.andersson → USER
   -- UPDATE patients SET user_id = 3 WHERE personal_number = '199001011234';


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