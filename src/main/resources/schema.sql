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
  fio       varchar(max),
  login     char(max),
  password  char(max),
  client_client_id  binary
);
CREATE TABLE operation_logs (
  operation_id      char(36) PRIMARY KEY,
  start_date        timestamp,
  end_date          timestamp,
  account_id        bigint,
  operation_type_id varchar(20),
  status_id         varchar(20)
);
CREATE TABLE client_roles (
  client_client_id binary not null,
  roles    varchar(max)
)

