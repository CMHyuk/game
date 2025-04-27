CREATE TABLE number_statistics
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    level         VARCHAR(255) NOT NULL,
    number        INT          NOT NULL,
    frequency     INT          NOT NULL,
    created_date  DATETIME,
    modified_date DATETIME
);

CREATE TABLE record
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    level         VARCHAR(255) NOT NULL,
    attempt_count INT          NOT NULL,
    elapsed_time DOUBLE NOT NULL,
    created_date  DATETIME,
    modified_date DATETIME
);
