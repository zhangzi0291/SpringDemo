prompt PL/SQL Developer import file
prompt Created on 2017年2月20日 by North
set feedback off
set define off
prompt Creating FINANC_PRODUCT...
create table FINANC_PRODUCT
(
  ID                NUMBER not null,
  LOAN_AMOUNT       NUMBER,
  REPAYMENT_METHOD  VARCHAR2(64),
  INTEREST_RATE     NUMBER,
  REPAYMENT_DATE    DATE,
  PUBLIC_TYPE       VARCHAR2(8),
  PUBLIC_MAN        VARCHAR2(64),
  REPAYMENT_BALANCE NUMBER,
  REPAYMENT_MAN     VARCHAR2(64)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column FINANC_PRODUCT.ID
  is 'id';
comment on column FINANC_PRODUCT.LOAN_AMOUNT
  is '贷款金额';
comment on column FINANC_PRODUCT.REPAYMENT_METHOD
  is '还款方式';
comment on column FINANC_PRODUCT.INTEREST_RATE
  is '利率';
comment on column FINANC_PRODUCT.REPAYMENT_DATE
  is '还款时间';
comment on column FINANC_PRODUCT.PUBLIC_TYPE
  is '发布类型：1融资2贷款';
comment on column FINANC_PRODUCT.PUBLIC_MAN
  is '发布人';
comment on column FINANC_PRODUCT.REPAYMENT_BALANCE
  is '剩余需要还款额';
comment on column FINANC_PRODUCT.REPAYMENT_MAN
  is '还款人';
alter table FINANC_PRODUCT
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating SYS_MENU...
create table SYS_MENU
(
  ID         NUMBER not null,
  MENU_NAME  VARCHAR2(128),
  MENU_PID   INTEGER,
  MENU_ICON  VARCHAR2(128),
  MENU_URL   VARCHAR2(256),
  MENU_ORDER INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table SYS_MENU
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating SYS_USER...
create table SYS_USER
(
  USER_NAME       VARCHAR2(32),
  USER_PWD        VARCHAR2(32),
  USER_EMAIL      VARCHAR2(64),
  USER_PROFESSION VARCHAR2(32),
  REAL_NAME       VARCHAR2(255),
  REAL_INCOME     INTEGER,
  FAMILY_NUMBER   INTEGER,
  ID_NUMBER       VARCHAR2(32),
  ID              NUMBER not null,
  CREDIT_RATE     VARCHAR2(4) default 5,
  HEADSHOT_IMG    VARCHAR2(64)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    minextents 1
    maxextents unlimited
  );
comment on column SYS_USER.USER_NAME
  is '用户名';
comment on column SYS_USER.USER_PWD
  is '密码';
comment on column SYS_USER.USER_EMAIL
  is '邮箱';
comment on column SYS_USER.USER_PROFESSION
  is '职业';
comment on column SYS_USER.REAL_NAME
  is '真实名字';
comment on column SYS_USER.REAL_INCOME
  is '实际收入';
comment on column SYS_USER.FAMILY_NUMBER
  is '家庭人数';
comment on column SYS_USER.ID_NUMBER
  is '身份证号码';
comment on column SYS_USER.ID
  is 'id';
comment on column SYS_USER.CREDIT_RATE
  is '信用评级';
alter table SYS_USER
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Deleting SYS_USER...
delete from SYS_USER;
commit;
prompt Deleting SYS_MENU...
delete from SYS_MENU;
commit;
prompt Deleting FINANC_PRODUCT...
delete from FINANC_PRODUCT;
commit;
prompt Loading FINANC_PRODUCT...
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN)
values (1, 1000, '还款方式', 1, to_date('19-02-2017 23:25:08', 'dd-mm-yyyy hh24:mi:ss'), '融资', '管理员', 0, null);
commit;
prompt 1 records loaded
prompt Loading SYS_MENU...
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (1, '融资', -1, null, null, null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (2, '贷款', -1, null, null, null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (3, '目录3', -1, null, null, null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (4, '我的融资', 1, null, 'finance/myFinance.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (5, '我的贷款', 2, null, '#', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (6, '融资产品', 1, null, '#', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (7, '贷款申请', 2, null, '#', null);
commit;
prompt 7 records loaded
prompt Loading SYS_USER...
insert into SYS_USER (USER_NAME, USER_PWD, USER_EMAIL, USER_PROFESSION, REAL_NAME, REAL_INCOME, FAMILY_NUMBER, ID_NUMBER, ID, CREDIT_RATE, HEADSHOT_IMG)
values ('admin', '123', null, '学生', '管理员', 12300, 2, '123456789012345678', 8, '5', null);
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
