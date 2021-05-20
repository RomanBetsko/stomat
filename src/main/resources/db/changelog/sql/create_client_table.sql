CREATE TABLE IF NOT EXISTS stomat.client (
                          client_id int NOT NULL AUTO_INCREMENT,
                          date_of_birth DATETIME NOT NULL,
                          disable_notification bit(1) DEFAULT NULL,
    disable_notification_date DATETIME DEFAULT NULL,
    email varchar(255) COLLATE utf8_bin NOT NULL,
    first_name varchar(255) COLLATE utf8_bin NOT NULL,
    phone varchar(255) COLLATE utf8_bin NOT NULL,
    resource varchar(255) COLLATE utf8_bin DEFAULT NULL,
    second_name varchar(255) COLLATE utf8_bin NOT NULL,
    sex varchar(255) COLLATE utf8_bin NOT NULL,
    third_name varchar(255) COLLATE utf8_bin NOT NULL,
    total_earn int DEFAULT NULL,
    PRIMARY KEY (client_id)
    ) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
;