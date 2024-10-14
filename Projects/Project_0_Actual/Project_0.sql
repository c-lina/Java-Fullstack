create table duelists (
	duelist_id serial primary key unique,
	first_name text,
	last_name text
);

create table cards (
	card_id serial primary key,
	stars int,
	card_name text,
	atk int,
	def int,
	duelist_id_fk int references duelists (duelist_id)
);

insert into duelists (first_name, last_name)
values ('Yugi', 'Mutou') , ('Seto', 'Kaiba') , ('Joey', 'Wheeler') , ('Mai', 'Valentine'), ('Maximillion', 'Pegasus'); 

insert into cards (stars, card_name, atk, def, duelist_id_fk)
values (7, 'Dark Magician', 2500, 2100, 1), ('6', 'Dark Magician Girl', 2000, 1700, 1) , (8, 'Blue Eyes White Dragon', 3000, 2500, 2), 
(7, 'Red Eyes Black Dragon', 2400, 2000, 3), (2, 'Time Wizard', 500, 400, 3), (4, 'Harpy Lady', 1300, 1400, 4), (6, 'Harpy Lady Sisters', 1950, 2100, 4),
('8', 'Blue Eyes Toon Dragon', 3000, 2500, 5);

select * from duelists;

select * from cards order by card_id asc;

select * from cards where duelist_id_fk = 1;

delete from cards where card_id = 0;

delete from duelists where duelist_id = 0;

drop table cards;

drop table duelists;

UPDATE cards SET atk = 3000 WHERE card_id = 3;

SELECT * FROM cards WHERE card_id = 6;

SELECT card_id FROM cards WHERE card_name = 'Dark Magician';

select * from duelists where first_name like '%Yugi%' and last_name like '%Mutou%';
