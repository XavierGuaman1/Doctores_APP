CREATE TABLE IF NOT EXISTS Doctor (
    id SERIAL,
    Nombre VARCHAR(100) NOT NULL,
    Especialidad VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Patients (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    Patients_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (Patients_id ) REFERENCES Patients(id)
    );