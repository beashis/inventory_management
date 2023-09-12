CREATE TABLE CUSTOMERS ( 
  USER_ID       NUMBER (5)  GENERATED ALWAYS AS IDENTITY  NOT NULL, 
  USERNAME      VARCHAR2 (20) UNIQUE  NOT NULL, 
  C_PASSWORD  VARCHAR2 (20)  NOT NULL,
  PRIMARY KEY ( USER_ID ) 
)



CREATE OR REPLACE PROCEDURE insertcustomer(
	   
	   p_username IN CUSTOMERS.USERNAME%TYPE,
	   p_password IN CUSTOMERS.C_PASSWORD%TYPE)
IS
BEGIN

 

  INSERT INTO CUSTOMERS ("USERNAME","C_PASSWORD") 
  VALUES (p_username,p_password);

 

  COMMIT;

 

END;

---------------------
CREATE TABLE PRODUCTS ( 
  p_id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
  c_id integer not null,
  p_name varchar2(50) UNIQUE,
  p_quantity INTEGER,
  p_price INTEGER,
  p_discount INTEGER
)



CREATE OR REPLACE PROCEDURE insertproduct(
	   
	   p_cid IN PRODUCTS.c_id%TYPE,
	   p_name IN PRODUCTS.p_name%TYPE,
       p_quantity IN PRODUCTS.p_quantity%TYPE,
       p_price IN PRODUCTS.p_price%TYPE,
       p_discount IN PRODUCTS.p_discount%TYPE)
IS
BEGIN

 

  INSERT INTO products (c_id ,
  p_name ,
  p_quantity,
  p_price ,
  p_discount) 
  VALUES (p_cid,p_name,p_quantity,p_price,p_discount);

 

  COMMIT;

 

END;

---------------------

create table I_ADMIN
(
a_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
a_name varchar2(50),
a_password VARCHAR2(50)
);

------------------

create table categories
(
  c_id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY  ,
  c_name VARCHAR2(50)
)

CREATE OR REPLACE PROCEDURE insertcategories(
	   
	   p_name IN categories.C_NAME%TYPE)
IS
BEGIN
  INSERT INTO categories ("C_NAME") 
  VALUES (p_name);

  COMMIT;
END;

begin
insertcategories('sports');
end;
--------------------------------------------------------------

create table cart
(
  u_id INTEGER not null,
  p_id INTEGER not null,
  quantity INTEGER not null
);

CREATE OR REPLACE PROCEDURE insertcart(
	   
	   p_uid IN cart.u_id%TYPE,
	   p_pid IN cart.p_id%TYPE,
       p_quantity IN cart.quantity%TYPE)
IS
BEGIN
  INSERT INTO cart ("U_ID","P_ID","QUANTITY") 
  VALUES (p_uid,p_pid,p_quantity);
  COMMIT;
END;

----------------------------




 


 

