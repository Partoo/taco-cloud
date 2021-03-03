create table if not exists Ingredient (
    id identity ,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Taco
(
    id identity,
    name varchar(50) not null,
    created_at timestamp nullable
);

create table if not exists Taco_Ingredients (
    taco bigint not null,
    ingredient varchar(6) not null
);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);
alter table Taco_ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
    id identity ,
    name varchar not null,
    street varchar not null,
    city varchar not null ,
    cvv varchar not null
);

create table if not exists Taco_Order_Tacos (
    order_id bigint not null,
    taco_id bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (order_id) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (taco_id) references Taco(id);