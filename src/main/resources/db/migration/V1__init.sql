CREATE TABLE IF NOT EXISTS Doctor (
    id SERIAL,
    Nombre VARCHAR(100) NOT NULL,
    Especialidad VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS pacientes (
    id SERIAL,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    pacientes_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pacientes_id ) REFERENCES pacientes(id)
    );