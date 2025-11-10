CREATE TABLE ciudad (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL UNIQUE,
  estado VARCHAR(120) NOT NULL
);

CREATE TABLE hotel (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(160) NOT NULL,
  ciudad_id INT NOT NULL REFERENCES ciudad(id),
  estrellas INT NOT NULL CHECK (estrellas BETWEEN 1 AND 5),
  precio_por_noche NUMERIC NOT NULL CHECK (precio_por_noche > 0)
);

CREATE TABLE reservacion (
  id SERIAL PRIMARY KEY,
  hotel_id INT NOT NULL REFERENCES hotel(id),
  nombre_huesped VARCHAR(160) NOT NULL,
  email VARCHAR(160) NOT NULL,
  num_personas INT NOT NULL CHECK (num_personas > 0),
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE NOT NULL,
  CHECK (fecha_fin > fecha_inicio)
);