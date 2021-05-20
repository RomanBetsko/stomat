CREATE TABLE IF NOT EXISTS stomat.proc (
                        procedure_id int NOT NULL AUTO_INCREMENT,
                        description varchar(255) COLLATE utf8_bin DEFAULT NULL,
    name varchar(255) COLLATE utf8_bin DEFAULT NULL,
    price int DEFAULT NULL,
    doctor int DEFAULT NULL,
    PRIMARY KEY (procedure_id),
    KEY FKfd90haffjhemfguore7jcfmo3 (doctor)
    ) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
;