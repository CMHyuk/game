CREATE TABLE record
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname     VARCHAR(50) NOT NULL,
    try_count    INT         NOT NULL,
    elapsed_time DATETIME    NOT NULL
);
