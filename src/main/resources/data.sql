create table person
( 
id integer not null, 
name varchar(255) not null, 
location varchar(255), 
birth_date timestamp, 
primary key(id)
);	

insert into person(ID, Name, Location, BIRTH_DATE) 
values(10001, 'Ranga','Hyderabad',CURRENT_TIMESTAMP()); 
insert into person(ID, Name, Location, BIRTH_DATE) 
values(10002, 'James','New York',CURRENT_TIMESTAMP()); 
insert into person(ID, Name, Location, BIRTH_DATE) 
values(10003, 'Peter','Amesterdam',CURRENT_TIMESTAMP()); 