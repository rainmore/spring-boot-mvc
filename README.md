A example of Spring Boot, JPA with QueryDSL, in Kotlin


```
DROP DATABASE IF EXISTS centus;

CREATE DATABASE centus CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE USER 'centus'@'localhost' IDENTIFIED BY 'centus';

GRANT ALL PRIVILEGES ON centus.* TO 'centus'@'localhost';

FLUSH PRIVILEGES;

USER centus;

CREATE TABLE userRoles (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    name VARCHAR(150) NOT NULL,
    parentId BIGINT UNSIGNED DEFAULT NULL,
    isAlmighty BOOLEAN DEFAULT FALSE,
    isArchived BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id),
    KEY(isArchived),
    KEY(isAlmighty),
    CONSTRAINT FK_userRoles_parentId FOREIGN KEY (parentId) REFERENCES userRoles(id) ON UPDATE CASCADE ON DELETE RESTRICT
);

INSERT INTO userRoles VALUES (1, 'system', NULL, true, false), (2, 'admin', NULL, false, false), (3, 'user', NULL, false, false);

```