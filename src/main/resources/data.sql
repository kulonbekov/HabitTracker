----roles-----------------------------------------------------------------------------------------------------------
insert into tb_role (id, status, name) VALUES (1, 'ACTIVE', 'ROLE_ADMIN');
insert into tb_role (id, status, name) VALUES (2, 'ACTIVE', 'ROLE_USER');

----users-----------------------------------------------------------------------------------------------------------
insert into tb_user(id,created,status,updated,age, email, gender, password, username)
VALUES (1, '2023-04-19 02:28:38.593', 'ACTIVE', '2023-04-19 02:28:38.593', 29, 'mirbek@gmail.com','MALE', '$2a$04$j8hS2sCsqpTzZBYPPRpBnubIuhee0Y1DmYOrwfTc9BO56Td7IiYW2', 'mirbek');

----users_roles-----------------------------------------------------------------------------------------------------
insert into tb_user_roles(user_id,role_id)VALUES (1,1);
