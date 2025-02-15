DROP TABLE IF EXISTS Run;

CREATE TABLE IF NOT EXISTS Run(
    id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    started_on TIMESTAMP NOT NULL,
    ended_on TIMESTAMP NOT NULL,
    miles DECIMAL(10, 2) NOT NULL,
    location VARCHAR(255) NOT NULL,
    version INT,
    PRIMARY KEY(id)
);