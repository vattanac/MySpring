
create table  tbl_category(
 id serial primary  key ,
 name varchar
);


CREATE TABLE  tbl_book(
id serial PRIMARY key,
title VARCHAR,
author VARCHAR,
publisher VARCHAR,
thumbnail VARCHAR,
cate_id int references tbl_category(id)
);