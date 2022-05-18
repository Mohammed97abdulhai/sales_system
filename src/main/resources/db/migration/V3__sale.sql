CREATE TABLE sale(
  id BIGSERIAL PRIMARY KEY,
  creation_date DATE,
  seller varchar(256),
  total INTEGER,
  client_id INTEGER,
  CONSTRAINT client_id_fk FOREIGN KEY (client_id) REFERENCES client(id)
  )