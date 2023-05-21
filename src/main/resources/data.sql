insert into healthcite.roles (id, description, name)
values (1, 'ROLE_ADMIN', 'ADMIN');
insert into healthcite.roles (id, description, name)
values (1, 'ROLE_DOCTOR', 'DOCTOR');
insert into healthcite.roles (id, description, name)
values (1, 'ROLE_PATIENT', 'PATIENT');

insert into healthcite.people
    (id, address, birthdate, document, email, first_name, gender, last_name,
     password, phone, username, id_role)
values
    (1,
     'test street',
     '2000-01-01',
     '1234567890',
     'test@example.com',
     'testName',
     'binary',
     'testSurname',
     '$2a$10$q.XGDLzKn8Oos3y5zGweIuAyN/.QVkiiFBk.MHI99lgPVzErUudJe',
     '+1234567890',
     'testUsername',
     1);