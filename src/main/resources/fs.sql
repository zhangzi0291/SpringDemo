--------------------------------------------
-- Export file for user FS                --
-- Created by North on 2017-2-27, 0:41:12 --
--------------------------------------------

spool fs.log

prompt
prompt Creating table CASH_FLOW
prompt ========================
prompt
create table CASH_FLOW
(
  ID        NUMBER,
  PAYEE_MAN VARCHAR2(32),
  PAYER_MAN VARCHAR2(32),
  MONEY     NUMBER,
  PAY_DATE  DATE
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
comment on column CASH_FLOW.PAYEE_MAN
  is '�տ���';
comment on column CASH_FLOW.PAYER_MAN
  is '������';
comment on column CASH_FLOW.MONEY
  is '���';
comment on column CASH_FLOW.PAY_DATE
  is '��������';

prompt
prompt Creating table EVALUATION_CRITERIA
prompt ==================================
prompt
create table EVALUATION_CRITERIA
(
  ID               NUMBER,
  EVALUATORS_MAN   VARCHAR2(32),
  VALUATION_MAN    VARCHAR2(32),
  EVALUATION_SCORE NUMBER,
  EVALUATION_DATE  DATE,
  FID              NUMBER
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
comment on column EVALUATION_CRITERIA.EVALUATORS_MAN
  is '������';
comment on column EVALUATION_CRITERIA.VALUATION_MAN
  is '��������';
comment on column EVALUATION_CRITERIA.EVALUATION_SCORE
  is '����';
comment on column EVALUATION_CRITERIA.EVALUATION_DATE
  is '��������';
comment on column EVALUATION_CRITERIA.FID
  is '����id';

prompt
prompt Creating table FINANC_PRODUCT
prompt =============================
prompt
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
  REPAYMENT_MAN     VARCHAR2(64),
  STATE             VARCHAR2(16)
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
  is '������';
comment on column FINANC_PRODUCT.REPAYMENT_METHOD
  is '���ʽ';
comment on column FINANC_PRODUCT.INTEREST_RATE
  is '����';
comment on column FINANC_PRODUCT.REPAYMENT_DATE
  is '����ʱ��';
comment on column FINANC_PRODUCT.PUBLIC_TYPE
  is '�������ͣ�1����2����';
comment on column FINANC_PRODUCT.PUBLIC_MAN
  is '������';
comment on column FINANC_PRODUCT.REPAYMENT_BALANCE
  is '�ѻ����';
comment on column FINANC_PRODUCT.REPAYMENT_MAN
  is '������';
comment on column FINANC_PRODUCT.STATE
  is '״̬��1�������� 2������� 3���ͨ�� 4��˲�ͨ�� 5���ڻ��� 6������� 7������� 8 �������뷢�� 9������������� 10 �������������';
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

prompt
prompt Creating table SYS_MENU
prompt =======================
prompt
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

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
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
  is '�û���';
comment on column SYS_USER.USER_PWD
  is '����';
comment on column SYS_USER.USER_EMAIL
  is '����';
comment on column SYS_USER.USER_PROFESSION
  is 'ְҵ';
comment on column SYS_USER.REAL_NAME
  is '��ʵ����';
comment on column SYS_USER.REAL_INCOME
  is 'ʵ������';
comment on column SYS_USER.FAMILY_NUMBER
  is '��ͥ����';
comment on column SYS_USER.ID_NUMBER
  is '���֤����';
comment on column SYS_USER.ID
  is 'id';
comment on column SYS_USER.CREDIT_RATE
  is '��������';
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

prompt
prompt Creating sequence SYS_SEQ
prompt =========================
prompt
create sequence SYS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 91
increment by 1
cache 10;

prompt
prompt Creating function GETID
prompt =======================
prompt
create or replace function getId return number is
  id number;
begin
  select sys_seq.nextval into id  from dual;
  return id;
end getId;
/

prompt
prompt Creating trigger FINANC_PRODUCT_SEQ_TRI
prompt =======================================
prompt
create or replace trigger FINANC_PRODUCT_seq_tri
before insert on FINANC_PRODUCT for each row
declare
  next_id number;
begin
  select sys_seq.nextval into next_id from dual;
  :new.id := next_id;
end;
/

prompt
prompt Creating trigger SYS_USER_SEQ_TRI
prompt =================================
prompt
create or replace trigger sys_user_seq_tri
before insert on sys_user for each row
declare
  next_id number;
begin
  select sys_seq.nextval into next_id from dual;
  :new.id := next_id;
end;
/


spool off
