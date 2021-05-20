CREATE TABLE IF NOT EXISTS stomat.appointment_procedure (
                                         appointment_id int NOT NULL,
                                         procedure_id int NOT NULL,
                                         KEY FKjs9dnwl4flvlx86xtovr0b9vu (procedure_id),
    KEY FK7aaiepuu3xlmp1t78o2il9uq6 (appointment_id)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin
;