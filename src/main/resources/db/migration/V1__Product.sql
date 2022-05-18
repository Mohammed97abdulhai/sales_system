Create Table product(
    id BIGSERIAL PRIMARY KEY,
    name varchar(256) Not NULL,
    description varchar(512),
    category varchar(256),
    creation_date DATE,
    timestamp TIMESTAMP
)