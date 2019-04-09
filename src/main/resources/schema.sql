CREATE TABLE accounts (
  account_id bigint PRIMARY KEY,
  bank_id    int,
  client_id  char(36),
  count      bigint
);
CREATE TABLE banks (
  bank_id char(36) PRIMARY KEY,
  name    varchar(max),
  code    int
);
CREATE TABLE clients (
  client_id char(36) PRIMARY KEY,
  bank_id   char(36),
  fio       varchar(max)
);
CREATE TABLE operation_logs (
  operation_id      char(36) PRIMARY KEY,
  start_date        timestamp,
  end_date          timestamp,
  account_id        bigint,
  operation_type_id int,
  status_id         int
);


