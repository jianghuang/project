DELETE FROM TB_EMPLOYEE;
DELETE FROM TB_MESSAGE;
DELETE FROM TB_REPLY;
DELETE FROM TB_CRITICISM;
COMMIT;

-- 加载员工信息数据                     开始...
INSERT INTO TB_EMPLOYEE (EMPLOYEEID, EMPLOYEENAME, EMPLOYEESEX, EMPLOYEEBIRTH, EMPLOYEEPHONE, EMPLOYEEPLACE, JOINTIME, PASSWORD, ISLEAD)
VALUES (3052, '李俊', b'1', '1978-01-08', '1378675****', '北京市', '2008-12-30', '123456', b'1');
INSERT INTO TB_EMPLOYEE  (EMPLOYEEID, EMPLOYEENAME, EMPLOYEESEX, EMPLOYEEBIRTH, EMPLOYEEPHONE, EMPLOYEEPLACE, JOINTIME, PASSWORD, ISLEAD)
VALUES (3053, '张珊', b'0', '1980-05-11', '1376795****', '天津市', '2009-10-28', '123456', b'0');
COMMIT;
-- 加载员工信息数据                      结束...

-- 加载消息信息数据                     开始...
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (14, '网络维护公告', '<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 48pt; line-height: 42pt; mso-char-indent-count: 2.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: 宋体; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">为保证网络上网，网络信息中心特安排了网络维护人员值班。各用户如有网络故障，请按以下方式联系。</span><span lang=\"EN-US\" style=\"font-size: 24pt\"><o:p></o:p></span></p>\r\n<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 24pt; line-height: 42pt; mso-char-indent-count: 1.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: 宋体; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">　值班电话：</span><span lang=\"EN-US\" style=\"font-size: 24pt\">XXXXXX</span></p>\r\n<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 24pt; line-height: 42pt; mso-char-indent-count: 1.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: 宋体; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">&nbsp;值班人：周先生</span></p>', 3052, '2009-08-25 14:18:59');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (16, '开会通知', '<p><span style=\"color: #3366ff\"><span style=\"background-color: #ffffff\"><span><span style=\"font-size: 20px\">请开发部的所有人员于8月30日的下午2点到三楼会议室，会议重要，请勿缺席。</span></span></span></span></p>', 3052, '2009-08-25 14:27:54');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (17, '研发部会议通知', '<p><span style=\"color: #ff0000\"><span style=\"font-size: 20px\">请研发部的所有人员于8月30日的下午2点到三楼会议室，会议重要，请勿缺席！！</span></span></p>', 3052, '2009-08-25 14:33:51');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (18, '关于国庆放假的通知', '<p><span style=\"font-size: 20px\">按国家规定国庆放假七天，8月8日正常上班。</span></p>', 3052, '2009-08-25 14:35:35');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (19, '请假一天，望领导能批准', '<p>由于家里有事情，急需处理，现请假一天，忘领导能批准。</p>', 3052, '2009-08-25 14:37:02');
INSERT INTO TB_MESSAGE (MESSAGEID, MESSAGETITLE, MESSAGECONTENT, EMPLOYEEID, PUBLISHTIME )
VALUES (20, '测试一下发布！', '<p><img alt=\"\" src=\"http://localhost:8080/JavaPrj_1/fckeditor/editor/images/smiley/qq/004.gif\" />测试一下！</p>', 3052, '2010-01-26 20:53:57');
COMMIT;
-- 加载消息信息数据                      结束...

-- 加载回复信息数据                     开始...
INSERT INTO TB_REPLY (REPLYID, REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID)
VALUES (9, '<p>太好了，希望以后不要再无故掉线了！！！</p>', 3052, '2009-08-25 15:03:23',14);
INSERT INTO TB_REPLY (REPLYID, REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID)
VALUES (10, '<p>是哦，总算是能够安心上网了。</p>', 3052, '2009-08-25 15:03:49',14);
INSERT INTO TB_REPLY (REPLYID, REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID)
VALUES (11, '<p>测试回复</p>', 3052, '2010-01-26 20:52:26',14);
COMMIT;
-- 加载回复信息数据                      结束...


-- 加载批复信息数据                     开始...
INSERT INTO TB_CRITICISM (CRITICISMID, CRITICISMCONTENT, EMPLOYEEID, CRITICISMTIME, MESSAGEID)
VALUES (3, '<p>不错，以后大家好好干活！！</p>', 3052, '2009-08-25 15:08:16', 14);
INSERT INTO TB_CRITICISM (CRITICISMID, CRITICISMCONTENT, EMPLOYEEID, CRITICISMTIME, MESSAGEID)
VALUES (4, '<p>测试批复</p>', 3052, '2010-01-26 20:52:46', 14);
COMMIT;
-- 加载批复信息数据                      结束...