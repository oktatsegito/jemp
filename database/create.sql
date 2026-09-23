

grant all privileges
on bama.*
to bama@localhost
identified by 'titok';

create table employees (
    id int not null primary key auto_increment,
    name varchar(30),
    city varchar(30),
    salary int
);
