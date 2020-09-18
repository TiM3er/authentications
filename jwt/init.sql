    drop table IF EXISTS USERS_ROLES;
    DROP TABLE  IF EXISTS USERS;
    DROP TABLE IF EXISTS ROLES;


    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

    create table IF NOT EXISTS  USERS
    (
        US_UID         varchar(50) PRIMARY KEY ,
        US_LOGIN       varchar(255) NOT NULL ,
        US_PASSWORD    varchar(255) NOT NULL ,
        US_CREATE_DATE timestamptz

    );

    CREATE TABLE IF NOT EXISTS ROLES (
                                         RO_UID varchar(50) PRIMARY KEY ,
                                         RO_CODE varchar(25) NOT NULL,
                                         RO_NAME varchar(25) NOT NULL,
                                         RO_DESCRIPTION varchar(255)
    );
    CREATE TABLE IF NOT EXISTS USERS_ROLES(
                                              UR_UID varchar(50) PRIMARY KEY,
                                              US_US_UID varchar(50) NOT NULL,
                                              RO_RO_UID varchar(50) NOT NULL,
                                              FOREIGN KEY (RO_RO_UID) REFERENCES ROLES(RO_UID),
                                              FOREIGN KEY (US_US_UID) REFERENCES USERS(US_UID)
    );

    insert INTO USERS(US_UID, US_LOGIN, US_PASSWORD) VALUES ('612b03f8-0bcb-43e2-8d48-f0109736c222','admin','admin');
    insert INTO USERS(US_UID, US_LOGIN, US_PASSWORD) VALUES ('94d428ea-f1f1-44b4-9224-7d1aca9c5344','ash','ketchum');
    insert INTO USERS(US_UID, US_LOGIN, US_PASSWORD) VALUES ('68f4958b-311c-46eb-8dad-38886590020c','Oak','Profesor');


    insert INTO roles(RO_UID, RO_CODE, RO_NAME, RO_DESCRIPTION) VALUES ('9ea67d2f-eb2a-4f56-91ff-8f2ce4d73c22','ADMIN','ADMINISTRATOR','ADMINISTRATOR ROLE');
    insert INTO roles(RO_UID, RO_CODE, RO_NAME, RO_DESCRIPTION) VALUES ('5c7b0db5-c621-4b0e-9dbe-14b65bece5f0','DELETE','DETELE USER','ROLE FOR DELETE USER ACCOUNT');
    insert INTO roles(RO_UID, RO_CODE, RO_NAME, RO_DESCRIPTION) VALUES ('df817214-21a8-482a-acf4-a111cf28c3bd','DELETE','DETELE USER','ROLE FOR DELETE USER ACCOUNT');
    insert INTO roles(RO_UID, RO_CODE, RO_NAME, RO_DESCRIPTION) VALUES ('c59babd5-dc03-4c5b-83a1-2136321da287','NUMBER','POKEMON NUMBER','GET INFO POKEMON BY NUMBER');
    insert INTO roles(RO_UID, RO_CODE, RO_NAME, RO_DESCRIPTION) VALUES ('82747f9e-429e-41ad-8584-7ff98532539f','NAME','POKEMON NAME','GET INFO POKEMON BY NAME');
    insert INTO roles(RO_UID, RO_CODE, RO_NAME, RO_DESCRIPTION) VALUES ('28eae730-871b-45ee-982d-82190dfb3a8e','TYPE','POKEMON TYPE','GET INFO POKEMON BY TYPE');


    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'612b03f8-0bcb-43e2-8d48-f0109736c222','9ea67d2f-eb2a-4f56-91ff-8f2ce4d73c22');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'612b03f8-0bcb-43e2-8d48-f0109736c222','5c7b0db5-c621-4b0e-9dbe-14b65bece5f0');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'612b03f8-0bcb-43e2-8d48-f0109736c222','df817214-21a8-482a-acf4-a111cf28c3bd');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'612b03f8-0bcb-43e2-8d48-f0109736c222','c59babd5-dc03-4c5b-83a1-2136321da287');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'612b03f8-0bcb-43e2-8d48-f0109736c222','82747f9e-429e-41ad-8584-7ff98532539f');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'612b03f8-0bcb-43e2-8d48-f0109736c222','28eae730-871b-45ee-982d-82190dfb3a8e');

    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'94d428ea-f1f1-44b4-9224-7d1aca9c5344','5c7b0db5-c621-4b0e-9dbe-14b65bece5f0');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'94d428ea-f1f1-44b4-9224-7d1aca9c5344','82747f9e-429e-41ad-8584-7ff98532539f');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'94d428ea-f1f1-44b4-9224-7d1aca9c5344','28eae730-871b-45ee-982d-82190dfb3a8e');

    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'68f4958b-311c-46eb-8dad-38886590020c','5c7b0db5-c621-4b0e-9dbe-14b65bece5f0');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'68f4958b-311c-46eb-8dad-38886590020c','82747f9e-429e-41ad-8584-7ff98532539f');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'68f4958b-311c-46eb-8dad-38886590020c','28eae730-871b-45ee-982d-82190dfb3a8e');
    INSERT INTO users_roles(UR_UID, US_US_UID, RO_RO_UID) VALUES (uuid_generate_v4(),'68f4958b-311c-46eb-8dad-38886590020c','c59babd5-dc03-4c5b-83a1-2136321da287');
