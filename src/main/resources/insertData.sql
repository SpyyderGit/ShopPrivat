
--  product_view add data
insert into product_view(view_name) values('Krupnaya tehnika');
insert into product_view(view_name) values('Melkaya bytovaya tehnika');
insert into product_view(view_name) values('Electronics');

--  product_type add data
insert into product_type(type_name,fk_id) values('TV',3);
insert into product_type(type_name,fk_id) values('Fridges',1);
insert into product_type(type_name,fk_id) values('SVC',2);
insert into product_type(type_name,fk_id) values('Utyugi',3);

--  manufacturer add data
insert into manufacturer(mr_name) values('Samsung');
insert into manufacturer(mr_name) values('LG');
insert into manufacturer(mr_name) values('Saturn');
insert into manufacturer(mr_name) values('Sony');

-- product add data

insert into product(name,price,remark,sklad,fk_id_mr,fk_id_type) values('Saturn PX',150,'Utyug','Y',3,4);
insert into product(name,price,remark,sklad,fk_id_mr,fk_id_type) values('Samsung XP',15000,'TV','Y',1,1);
insert into product(name,price,remark,sklad,fk_id_mr,fk_id_type) values('LG XRO PX',200,'SVC','N',2,3);
insert into product(name,price,remark,sklad,fk_id_mr,fk_id_type) values('Sony Bravia',20000,'Sony TV','Y',4,1);
insert into product(name,price,remark,sklad,fk_id_mr,fk_id_type) values('Holodok',200000,'Super Fridge','Y',4,2);

COMMIT ;

select t1.product_id,
       t1.name,
       t1.price,
       t1.remark,
       t1.sklad,
       t2.mr_name,
       t3.type_name,
       t4.view_name
from product      as t1
  join manufacturer as t2 on t2.mr_id = t1.fk_id_mr
  join product_type as t3 on t3.type_id = t1.fk_id_type
  join product_view as t4 on t4.view_id = t3.fk_id;

