CREATE TABLE IF NOT EXISTS stomat.doctor (
                          id int NOT NULL AUTO_INCREMENT,
                          email varchar(255) COLLATE utf8_bin NOT NULL,
    first_name varchar(255) COLLATE utf8_bin NOT NULL,
    phone varchar(255) COLLATE utf8_bin NOT NULL,
    second_name varchar(255) COLLATE utf8_bin NOT NULL,
    third_name varchar(255) COLLATE utf8_bin NOT NULL,
    total_appointments int NOT NULL,
    total_clients int NOT NULL,
    total_procedures int NOT NULL,
    PRIMARY KEY (id)
    ) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
;