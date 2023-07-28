-- plain_text ddl
CREATE TABLE `plain_text` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- result_text ddl
CREATE TABLE `result_text` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- plain_text dml
insert into plain_text values (1, 'apple');
insert into plain_text values (2, 'banana');
insert into plain_text values (3, 'carrot');
insert into plain_text values (4, 'dessert');
insert into plain_text values (5, 'egg');
insert into plain_text values (6, 'fish');
insert into plain_text values (7, 'goose');
commit;