CREATE TABLE IF NOT EXISTS Doctor (
    id SERIAL,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Patients (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    lastaname VARCHAR(100) NOT NULL,
    Patients_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (Patients_id ) REFERENCES patients(id)
    );