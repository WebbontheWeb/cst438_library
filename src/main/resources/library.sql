create schema library;

use library;

create table patron (
    patron_id bigint primary key,
    name varchar(250) not null );

create table book (
    book_id bigint primary key,
    title varchar(250) not null,
    author varchar(250) not null,
    checkout_patron_id bigint,
    checkout_date date,
    foreign key (checkout_patron_id) references patron(patron_id));




