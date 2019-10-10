

CREATE TABLE ROLES 
(
  ROLEID INTEGER NOT NULL 
, ROLENAME VARCHAR2(255) NOT NULL 
, CONSTRAINT ROLES_PK PRIMARY KEY 
  (
    ROLEID 
  )
  ENABLE 
);

CREATE SEQUENCE ROLES_SEQ;

CREATE TRIGGER ROLES_TRG 
BEFORE INSERT ON ROLES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ROLEID IS NULL THEN
      SELECT ROLES_SEQ.NEXTVAL INTO :NEW.ROLEID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/


CREATE TABLE GENDER 
(
  GENDERID INTEGER NOT NULL 
, GENDERNAME VARCHAR2(255) NOT NULL 
, CONSTRAINT GENDER_PK PRIMARY KEY 
  (
    GENDERID 
  )
  ENABLE 
);

CREATE SEQUENCE GENDER_SEQ;

CREATE TRIGGER GENDER_TRG 
BEFORE INSERT ON GENDER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.GENDERID IS NULL THEN
      SELECT GENDER_SEQ.NEXTVAL INTO :NEW.GENDERID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/


CREATE TABLE USERS 
(
  USERID INTEGER NOT NULL 
, FULLNAME VARCHAR2(255) NOT NULL 
, ADDRESS VARCHAR2(255) NOT NULL 
, LOGIN VARCHAR2(255) NOT NULL 
, PASSWORD VARCHAR2(255) NOT NULL 
, GENDER INTEGER NOT NULL 
, ROLE INTEGER NOT NULL 
, CONSTRAINT USERS_PK PRIMARY KEY 
  (
    USERID 
  )
  ENABLE 
);

CREATE SEQUENCE USERS_SEQ;

CREATE TRIGGER USERS_TRG 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.USERID IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.USERID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/



ALTER TABLE USERS
ADD CONSTRAINT USERS_FK1 FOREIGN KEY
(
  ROLE 
)
REFERENCES ROLES
(
  ROLEID 
)
ENABLE;

ALTER TABLE USERS
ADD CONSTRAINT USERS_FK2 FOREIGN KEY
(
  GENDER 
)
REFERENCES GENDER
(
  GENDERID 
)
ENABLE;



CREATE TABLE AUCTIONPRODUCTINFO 
(
  INFOID INTEGER NOT NULL 
, STARTPRICE DOUBLE PRECISION NOT NULL 
, STEPLEVEL DOUBLE PRECISION NOT NULL 
, BIDDER INTEGER NOT NULL 
, TIME TIMESTAMP NOT NULL 
, USER_MASTER INTEGER NOT NULL 
, ISBIDDING NUMBER(1) NOT NULL 
, CONSTRAINT AUCTIONPRODUCTINFO_PK PRIMARY KEY 
  (
    INFOID 
  )
  ENABLE 
);

CREATE SEQUENCE AUCTIONPRODUCTINFO_SEQ2;

CREATE TRIGGER AUCTIONPRODUCTINFO_TRG 
BEFORE INSERT ON AUCTIONPRODUCTINFO 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.INFOID IS NULL THEN
      SELECT AUCTIONPRODUCTINFO_SEQ2.NEXTVAL INTO :NEW.INFOID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/




CREATE TABLE PRODUCTS 
(
  PRODUCTID INTEGER NOT NULL 
, NAMEPRODUCT VARCHAR2(255) NOT NULL 
, DESCRIPTION VARCHAR2(255) NOT NULL 
, AUCTIONINFO_FK INTEGER NOT NULL 
, CONSTRAINT PRODUCTS_PK PRIMARY KEY 
  (
    PRODUCTID 
  )
  ENABLE 
);

CREATE SEQUENCE PRODUCTS_SEQ;

CREATE TRIGGER PRODUCTS_TRG 
BEFORE INSERT ON PRODUCTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.PRODUCTID IS NULL THEN
      SELECT PRODUCTS_SEQ.NEXTVAL INTO :NEW.PRODUCTID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/


ALTER TABLE PRODUCTS
ADD CONSTRAINT PRODUCTS_FK1 FOREIGN KEY
(
  AUCTIONINFO_FK 
)
REFERENCES AUCTIONPRODUCTINFO
(
  INFOID 
)
ENABLE;


ALTER TABLE AUCTIONPRODUCTINFO RENAME COLUMN USER_MASTER TO USER_MASTER_FK;

CREATE OR REPLACE TRIGGER AUCTIONPRODUCTINFO_TRG 
BEFORE INSERT ON AUCTIONPRODUCTINFO 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/


CREATE TABLE BIDDER 
(
  BIDDERID INTEGER NOT NULL 
, BIDDEROFFER DOUBLE PRECISION NOT NULL 
, BIDDERUSER_FK INTEGER NOT NULL 
, CONSTRAINT BIDDER_PK PRIMARY KEY 
  (
    BIDDERID 
  )
  ENABLE 
);

CREATE SEQUENCE BIDDER_SEQ;

CREATE TRIGGER BIDDER_TRG 
BEFORE INSERT ON BIDDER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.BIDDERID IS NULL THEN
      SELECT BIDDER_SEQ.NEXTVAL INTO :NEW.BIDDERID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/



ALTER TABLE AUCTIONPRODUCTINFO RENAME COLUMN BIDDER TO BIDDER_FK;

ALTER TABLE AUCTIONPRODUCTINFO
ADD CONSTRAINT AUCTIONPRODUCTINFO_FK1 FOREIGN KEY
(
  BIDDER_FK 
)
REFERENCES BIDDER
(
  BIDDERID 
)
ENABLE;

ALTER TABLE AUCTIONPRODUCTINFO
ADD CONSTRAINT AUCTIONPRODUCTINFO_FK2 FOREIGN KEY
(
  USER_MASTER_FK 
)
REFERENCES USERS
(
  USERID 
)
ENABLE;





ALTER TABLE BIDDER
ADD CONSTRAINT BIDDER_FK1 FOREIGN KEY
(
  BIDDERUSER_FK 
)
REFERENCES USERS
(
  USERID 
)
ENABLE;

CREATE SEQUENCE AUCTIONPRODUCTINFO_SEQ4;

CREATE TRIGGER AUCTIONPRODUCTINFO_TRG2 
BEFORE INSERT ON AUCTIONPRODUCTINFO 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.INFOID IS NULL THEN
      SELECT AUCTIONPRODUCTINFO_SEQ4.NEXTVAL INTO :NEW.INFOID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/



ALTER TABLE BIDDER  
MODIFY (BIDDERUSER_FK NULL);

ALTER TABLE AUCTIONPRODUCTINFO  
MODIFY (BIDDER_FK NULL);

