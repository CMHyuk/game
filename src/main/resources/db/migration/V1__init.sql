CREATE TABLE number_statistics
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    number    INT NOT NULL,
    frequency INT NOT NULL
);

CREATE TABLE record
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    level         VARCHAR(50) NOT NULL,
    attempt_count INT         NOT NULL,
    elapsed_time DOUBLE NOT NULL
);

