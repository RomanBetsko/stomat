CREATE TABLE IF NOT EXISTS stomat.appointment (
                               appointment_id int NOT NULL AUTO_INCREMENT,
                               clinic varchar(255) COLLATE utf8_bin NOT NULL,
    date_from datetime DEFAULT NULL,
    date_to datetime DEFAULT NULL,
    description varchar(255) COLLATE utf8_bin DEFAULT NULL,
    name varchar(255) COLLATE utf8_bin NOT NULL,
    price int NOT NULL,
    client_id int NOT NULL,
    doctor int NOT NULL,
    PRIMARY KEY (appointment_id),
    KEY FK3gbqcfd3mnwwcit63lybpqcf8 (client_id),
    KEY FKdd2ggcc6m2hgy7amgrhf74j3e (doctor)
    ) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
;