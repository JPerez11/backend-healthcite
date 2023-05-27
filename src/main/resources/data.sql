insert into healthcite.roles (id, description, name)
values (1, 'ROLE_ADMIN', 'ADMIN');
insert into healthcite.roles (id, description, name)
values (2, 'ROLE_DOCTOR', 'DOCTOR');
insert into healthcite.roles (id, description, name)
values (3, 'ROLE_PATIENT', 'PATIENT');

insert into healthcite.people
    (id, address, birthdate, document, email, first_name, gender, last_name,
     password, phone, id_role)
values
    (1,
     'admin street',
     '2000-01-01',
     '1234567890',
     'admin@example.com',
     'adminName',
     'male',
     'adminSurname',
     '$2a$10$8U2js1MRFl/o7vMn2/j/z.ctfTK1SBRIjsJ3o7UZgY7IZaQIbYYLG',
     '+1234567890',
     1);

-- password = admin123 --