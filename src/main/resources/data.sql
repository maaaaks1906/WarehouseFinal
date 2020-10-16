insert into units_of_measure (name) values ('kg'),('m'),('cm'),('mm'),('pcs');

insert into items (name, quantity, unit_of_measure_id, number_of_modifications) values ('Srubka', 10.0, 5, 0);
insert into items (name, quantity, unit_of_measure_id, number_of_modifications) values ('Gniazdko x', 15.0, 5, 0);
insert into items (name, quantity, unit_of_measure_id, number_of_modifications) values ('Lampa y', 20.0, 5, 0);

insert into customers (first_name, middle_name, last_name, address, phone_number, email_address, social_security_number) values ('Maksymilian', 'Filip', 'Kaczmarek', 'Sigtun 1', '7639894', 'mk@mk.pl', '1235');

insert into users (password, email) values ('grimur', 'grimur@gmg.pl');
