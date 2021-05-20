CREATE TABLE if not exists client_file_upload (
    file_id varchar(255) COLLATE utf8_bin NOT NULL,
    file_name varchar(255) COLLATE utf8_bin DEFAULT NULL,
    client_id int NOT NULL,
    PRIMARY KEY (file_id),
    KEY FKiv82yep2a3dwf2nbm6lg3ckro (client_id)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin
;