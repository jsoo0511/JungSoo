
#1
create table product(
    code int(10) primary key,
    name varchar(100),
    price int(100)
);

#2
insert into product values(1,'삼성TV',2000000);
insert into product values(2,'삼성노트북',1500000);
insert into product values(3,'삼성최신형TV',4000000);
insert into product values(4,'삼성Pen-S노트북',2300000);
insert into product values(5,'삼성중고TV',500000);

#3
update product set price=price*0.85;

#4
update product set price=price*0.8 where name Like "%TV%";

#5
select sum(price) as 총금액 from product;



select * from product;