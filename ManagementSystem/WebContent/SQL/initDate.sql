DELETE FROM TB_EMPLOYEE;
DELETE FROM TB_MESSAGE;
DELETE FROM TB_REPLY;
DELETE FROM TB_CRITICISM;
COMMIT;

-- ����Ա����Ϣ����                     ��ʼ...
INSERT INTO TB_EMPLOYEE (EMPLOYEEID, EMPLOYEENAME, EMPLOYEESEX, EMPLOYEEBIRTH, EMPLOYEEPHONE, EMPLOYEEPLACE, JOINTIME, PASSWORD, ISLEAD)
VALUES (3052, '�', b'1', '1978-01-08', '1378675****', '������', '2008-12-30', '123456', b'1');
INSERT INTO TB_EMPLOYEE  (EMPLOYEEID, EMPLOYEENAME, EMPLOYEESEX, EMPLOYEEBIRTH, EMPLOYEEPHONE, EMPLOYEEPLACE, JOINTIME, PASSWORD, ISLEAD)
VALUES (3053, '��ɺ', b'0', '1980-05-11', '1376795****', '�����', '2009-10-28', '123456', b'0');
COMMIT;
-- ����Ա����Ϣ����                      ����...

-- ������Ϣ��Ϣ����                     ��ʼ...
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (14, '����ά������', '<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 48pt; line-height: 42pt; mso-char-indent-count: 2.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: ����; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">Ϊ��֤����������������Ϣ�����ذ���������ά����Աֵ�ࡣ���û�����������ϣ��밴���·�ʽ��ϵ��</span><span lang=\"EN-US\" style=\"font-size: 24pt\"><o:p></o:p></span></p>\r\n<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 24pt; line-height: 42pt; mso-char-indent-count: 1.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: ����; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">��ֵ��绰��</span><span lang=\"EN-US\" style=\"font-size: 24pt\">XXXXXX</span></p>\r\n<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 24pt; line-height: 42pt; mso-char-indent-count: 1.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: ����; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">&nbsp;ֵ���ˣ�������</span></p>', 3052, '2009-08-25 14:18:59');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (16, '����֪ͨ', '<p><span style=\"color: #3366ff\"><span style=\"background-color: #ffffff\"><span><span style=\"font-size: 20px\">�뿪������������Ա��8��30�յ�����2�㵽��¥�����ң�������Ҫ������ȱϯ��</span></span></span></span></p>', 3052, '2009-08-25 14:27:54');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (17, '�з�������֪ͨ', '<p><span style=\"color: #ff0000\"><span style=\"font-size: 20px\">���з�����������Ա��8��30�յ�����2�㵽��¥�����ң�������Ҫ������ȱϯ����</span></span></p>', 3052, '2009-08-25 14:33:51');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (18, '���ڹ���żٵ�֪ͨ', '<p><span style=\"font-size: 20px\">�����ҹ涨����ż����죬8��8�������ϰࡣ</span></p>', 3052, '2009-08-25 14:35:35');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (19, '���һ�죬���쵼����׼', '<p>���ڼ��������飬���账�������һ�죬���쵼����׼��</p>', 3052, '2009-08-25 14:37:02');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (20, '����һ�·�����', '<p><img alt=\"\" src=\"http://localhost:8080/JavaPrj_1/fckeditor/editor/images/smiley/qq/004.gif\" />����һ�£�</p>', 3052, '2010-01-26 20:53:57');
COMMIT;
-- ������Ϣ��Ϣ����                      ����...

-- ���ػظ���Ϣ����                     ��ʼ...
INSERT INTO TB_REPLY (REPLYID, REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID)
VALUES (9, '<p>̫���ˣ�ϣ���Ժ�Ҫ���޹ʵ����ˣ�����</p>', 3052, '2009-08-25 15:03:23',14);
INSERT INTO TB_REPLY (REPLYID, REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID)
VALUES (10, '<p>��Ŷ���������ܹ����������ˡ�</p>', 3052, '2009-08-25 15:03:49',14);
INSERT INTO TB_REPLY (REPLYID, REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID)
VALUES (11, '<p>���Իظ�</p>', 3052, '2010-01-26 20:52:26',14);
COMMIT;
-- ���ػظ���Ϣ����                      ����...


-- ����������Ϣ����                     ��ʼ...
INSERT INTO TB_CRITICISM (CRITICISMID, CRITICISMCONTENT, EMPLOYEEID, CRITICISMTIME, MESSAGEID)
VALUES (3, '<p>�����Ժ��Һúøɻ��</p>', 3052, '2009-08-25 15:08:16', 14);
INSERT INTO TB_CRITICISM (CRITICISMID, CRITICISMCONTENT, EMPLOYEEID, CRITICISMTIME, MESSAGEID)
VALUES (4, '<p>��������</p>', 3052, '2010-01-26 20:52:46', 14);
COMMIT;
-- ����������Ϣ����                      ����...