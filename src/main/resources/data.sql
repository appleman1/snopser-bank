INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567891, 3333, 'cbca327ff25841fa876b0e854b2b4db1', 10078000);

INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567892, 3333, 'cbca327ff25841fa876b0e854b2b4db2', 10003400);

INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567893, 3333, 'cbca327ff25841fa876b0e854b2b4db3', 1006000);

INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567894, 3333, 'cbca327ff25841fa876b0e854b2b4db4', 10150000);

INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567895, 3333, 'cbca327ff25841fa876b0e854b2b4db5', 1002000);

INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567896, 3333, 'cbca327ff25841fa876b0e854b2b4db6', 10320000);

INSERT INTO accounts (account_id, bank_id, client_id, count)
values (3333567897, 3333, 'cbca327ff25841fa876b0e854b2b4db7', 1005000);

INSERT INTO banks (bank_id, name, code)
values ('cbca327ff25841fa876b0e854b2b4d10', 'Банк Танк', 7777);

INSERT INTO banks (bank_id, name, code)
values ('cbca327ff25841fa876b0e854b2b4d21', 'SnopseR', 3333);

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db1',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Петров Иван Филиппович',
        'login1',
        'password');

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db2',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Козел Ихний Филиппович',
        'login2',
        'password');

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db3',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Отсутствие Фантазии Конкретное',
        'login3',
        'password');

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db4',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Лень Думать Сложно',
        'login4',
        'password');

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db5',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Единорогов Няша Иванович',
        'login5',
        'password');

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db6',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Яусталов Игорь Дмитриевич',
        'login6',
        'password');

INSERT INTO clients (client_id, bank_id, fio, login, password)
values ('cbca327ff25841fa876b0e854b2b4db7',
        'cbca327ff25841fa876b0e854b2b4d21',
        'Лошков Инокентий Казашкович',
        'login7',
        'password');

INSERT INTO client_roles (client_client_id, roles)
values ('cbca327ff25841fa876b0e854b2b4db1', 'ROLE_ADMIN')