prompt PL/SQL Developer import file
prompt Created on 2017年2月27日 by North
set feedback off
set define off
prompt Deleting SYS_USER...
delete from SYS_USER;
commit;
prompt Deleting SYS_MENU...
delete from SYS_MENU;
commit;
prompt Deleting FINANC_PRODUCT...
delete from FINANC_PRODUCT;
commit;
prompt Deleting EVALUATION_CRITERIA...
delete from EVALUATION_CRITERIA;
commit;
prompt Deleting CASH_FLOW...
delete from CASH_FLOW;
commit;
prompt Loading CASH_FLOW...
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (77, '1', '17', 8336, to_date('27-02-2017 00:21:16', 'dd-mm-yyyy hh24:mi:ss'));
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (76, '1', '17', 8336, to_date('26-02-2017 20:16:41', 'dd-mm-yyyy hh24:mi:ss'));
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (78, '1', '17', 8336, to_date('27-02-2017 00:24:33', 'dd-mm-yyyy hh24:mi:ss'));
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (79, '1', '17', 8336, to_date('27-02-2017 00:25:31', 'dd-mm-yyyy hh24:mi:ss'));
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (80, '1', '17', 8336, to_date('27-02-2017 00:29:42', 'dd-mm-yyyy hh24:mi:ss'));
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (74, '17', '1', 6777, to_date('26-02-2017 20:08:33', 'dd-mm-yyyy hh24:mi:ss'));
insert into CASH_FLOW (ID, PAYEE_MAN, PAYER_MAN, MONEY, PAY_DATE)
values (81, '1', '17', 8336, to_date('27-02-2017 00:30:00', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 7 records loaded
prompt Loading EVALUATION_CRITERIA...
insert into EVALUATION_CRITERIA (ID, EVALUATORS_MAN, VALUATION_MAN, EVALUATION_SCORE, EVALUATION_DATE, FID)
values (60, '17', '1', 5, null, 58);
insert into EVALUATION_CRITERIA (ID, EVALUATORS_MAN, VALUATION_MAN, EVALUATION_SCORE, EVALUATION_DATE, FID)
values (67, '1', '17', 5, null, 66);
insert into EVALUATION_CRITERIA (ID, EVALUATORS_MAN, VALUATION_MAN, EVALUATION_SCORE, EVALUATION_DATE, FID)
values (68, '17', '1', 5, null, 66);
insert into EVALUATION_CRITERIA (ID, EVALUATORS_MAN, VALUATION_MAN, EVALUATION_SCORE, EVALUATION_DATE, FID)
values (59, '1', '17', 5, null, 58);
insert into EVALUATION_CRITERIA (ID, EVALUATORS_MAN, VALUATION_MAN, EVALUATION_SCORE, EVALUATION_DATE, FID)
values (56, '17', '1', 5, null, 53);
insert into EVALUATION_CRITERIA (ID, EVALUATORS_MAN, VALUATION_MAN, EVALUATION_SCORE, EVALUATION_DATE, FID)
values (57, '1', '17', 4.5, null, 53);
commit;
prompt 6 records loaded
prompt Loading FINANC_PRODUCT...
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN, STATE)
values (66, 3400, '分期还款', 5, to_date('28-03-2017', 'dd-mm-yyyy'), '1', '17', 3570, '1', '7');
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN, STATE)
values (53, 10000, '一次还款', 10, to_date('12-03-2017', 'dd-mm-yyyy'), '1', '17', 11000, '1', '7');
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN, STATE)
values (72, 6678, '一次还款', 12, to_date('12-03-2017', 'dd-mm-yyyy'), '2', null, null, '17', '8');
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN, STATE)
values (69, 22556, '一次还款', 1, to_date('31-03-2017', 'dd-mm-yyyy'), '1', '17', null, null, '0');
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN, STATE)
values (73, 6777, '一次还款', 23, to_date('11-03-2017', 'dd-mm-yyyy'), '1', '1', 8336, '17', '6');
insert into FINANC_PRODUCT (ID, LOAN_AMOUNT, REPAYMENT_METHOD, INTEREST_RATE, REPAYMENT_DATE, PUBLIC_TYPE, PUBLIC_MAN, REPAYMENT_BALANCE, REPAYMENT_MAN, STATE)
values (58, 20000, '一次还款', 5, to_date('12-03-2017', 'dd-mm-yyyy'), '2', '17', 21000, '1', '7');
commit;
prompt 6 records loaded
prompt Loading SYS_MENU...
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (8, '我的申请', 2, null, 'loan/applicationLoan.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (1, '融资', -1, null, null, null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (2, '贷款', -1, null, null, null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (3, '目录3', -1, null, null, null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (4, '我的融资', 1, null, 'finance/myFinance.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (5, '我的贷款', 2, null, 'loan/myLoan.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (6, '融资产品', 2, null, 'finance/allFinance.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (7, '贷款申请', 1, null, 'loan/allLoan.html', null);
commit;
prompt 8 records loaded
prompt Loading SYS_USER...
insert into SYS_USER (USER_NAME, USER_PWD, USER_EMAIL, USER_PROFESSION, REAL_NAME, REAL_INCOME, FAMILY_NUMBER, ID_NUMBER, ID, CREDIT_RATE, HEADSHOT_IMG)
values ('admin', 'admin', null, '学生', '管理员', 12300, 2, '123456789012345678', 1, '5', null);
insert into SYS_USER (USER_NAME, USER_PWD, USER_EMAIL, USER_PROFESSION, REAL_NAME, REAL_INCOME, FAMILY_NUMBER, ID_NUMBER, ID, CREDIT_RATE, HEADSHOT_IMG)
values ('test', '1234', 'test@gmail.com', '职员', '测试', 10000, 4, '123456789012345678', 17, '5', null);
commit;
prompt 2 records loaded
set feedback on
set define on
prompt Done.
