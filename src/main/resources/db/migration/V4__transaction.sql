CREATE TABLE transaction(
    id BIGSERIAL PRIMARY KEY,
    product varchar(256),
    quantity integer,
    sale_id INTEGER,
    CONSTRAINT sale_id_fk FOREIGN KEY (sale_id) REFERENCES sale(id))