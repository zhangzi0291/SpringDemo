prompt PL/SQL Developer import file
prompt Created on 2017��3��5�� by North
set feedback off
set define off
prompt Deleting SYS_USER...
delete from SYS_USER;
commit;
prompt Deleting SYS_MENU...
delete from SYS_MENU;
commit;
prompt Deleting SYS_BLACKLIST...
delete from SYS_BLACKLIST;
commit;
prompt Loading SYS_BLACKLIST...
insert into SYS_BLACKLIST (ID, BLACKUSER_ID, REMARK)
values (128, '127', '����������');
commit;
prompt 1 records loaded
prompt Loading SYS_MENU...
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (8, '�ҵ�����', 2, null, 'loan/applicationLoan.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (1, '����', -1, null, null, 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (2, '����', -1, null, null, 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (3, 'ϵͳ����', -1, null, null, 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (4, '�ҵ�����', 1, null, 'finance/myFinance.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (5, '�ҵĴ���', 2, null, 'loan/myLoan.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (6, '���ʲ�Ʒ', 2, null, 'finance/allFinance.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (7, '��������', 1, null, 'loan/allLoan.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (11, '�û��б�', 12, null, 'admin/userList.html', 0);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (12, 'ϵͳ����', -1, null, null, 0);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (9, '�ҵ���Ϣ', 3, null, 'user/myinfo.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (10, '�޸�����', 3, null, 'user/changePwd.html', 1);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (13, 'ȫ�����ʷ���', 12, null, 'admin/allFinance.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (14, 'ȫ����������', 12, null, 'admin/allLoan.html', null);
insert into SYS_MENU (ID, MENU_NAME, MENU_PID, MENU_ICON, MENU_URL, MENU_ORDER)
values (15, '������', 12, null, 'admin/blackList.html', null);
commit;
prompt 15 records loaded
prompt Loading SYS_USER...
insert into SYS_USER (USER_NAME, USER_PWD, USER_EMAIL, USER_PROFESSION, REAL_NAME, REAL_INCOME, FAMILY_NUMBER, ID_NUMBER, ID, CREDIT_RATE, HEADSHOT_IMG)
values ('admin', 'admin', 'email@a.com', 'ְԱ', '����Ա', 12300, 3, '123456789012345678', 1, '5', null);
insert into SYS_USER (USER_NAME, USER_PWD, USER_EMAIL, USER_PROFESSION, REAL_NAME, REAL_INCOME, FAMILY_NUMBER, ID_NUMBER, ID, CREDIT_RATE, HEADSHOT_IMG)
values ('test', '1234', 'test@gmail.com', 'ѧ��', '����', 10000, 4, '123456789012345678', 17, '5', null);
insert into SYS_USER (USER_NAME, USER_PWD, USER_EMAIL, USER_PROFESSION, REAL_NAME, REAL_INCOME, FAMILY_NUMBER, ID_NUMBER, ID, CREDIT_RATE, HEADSHOT_IMG)
values ('black', '1234', 'black@126.com', 'ְԱ', '������', 50000, 3, '123456789012345678', 127, '5', null);
commit;
prompt 3 records loaded
set feedback on
set define on
prompt Done.
