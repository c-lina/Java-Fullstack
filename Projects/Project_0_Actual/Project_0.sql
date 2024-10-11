create table duelists (
	duelist_id int primary key unique,
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

insert into duelists (duelist_id, first_name, last_name)
values (1, 'Yugi', 'Mutou') , (2, 'Seto', 'Kaiba') , (3, 'Joey', 'Wheeler') , (4, 'Mai', 'Valentine'), (5, 'Maximillion', 'Pegasus') 

insert into cards (stars, card_name, atk, def, duelist_id_fk)
values (7, 'Dark Magician', 2500, 2100, 1), ('6', 'Dark Magician Girl', 2000, 1700, 1) , (8, 'Blue Eyes White Dragon', 3000, 2500, 2), 
(7, 'Red Eyes Black Dragon', 2400, 2000, 3), (2, 'Time Wizard', 500, 400, 3), (4, 'Harpy Lady', 1300, 1400, 4), (6, 'Harpy Lady Sisters', 1950, 2100, 4),
('8', 'Blue Eyes Toon Dragon', 3000, 2500, 5)

select * from duelists;

select * from cards;
