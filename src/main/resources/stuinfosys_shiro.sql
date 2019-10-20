/*
Navicat MySQL Data Transfer

Source Server         : mysql8
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : stuinfosys_shiro

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-10-19 21:31:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `major_id` varchar(32) NOT NULL,
  `institute_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('clgc1', '车辆工程1班', '6', '003');
INSERT INTO `clazz` VALUES ('clgc2', '车辆工程2班', '6', '003');
INSERT INTO `clazz` VALUES ('clgc3', '车辆工程3班', '6', '003');
INSERT INTO `clazz` VALUES ('dab9d515fc7b434c8870dfc8f4a5e5b2', '测试', '1', '001');
INSERT INTO `clazz` VALUES ('dqzdh1', '电气自动化1班', '4', '002');
INSERT INTO `clazz` VALUES ('dqzdh2', '电气自动化2班', '4', '002');
INSERT INTO `clazz` VALUES ('jsj1', '计算机1班', '1', '001');
INSERT INTO `clazz` VALUES ('jsj2', '计算机2班', '1', '001');
INSERT INTO `clazz` VALUES ('jtgc1', '交通工程1班', '8', '003');
INSERT INTO `clazz` VALUES ('jtgc2', '交通工程1班', '8', '003');
INSERT INTO `clazz` VALUES ('jxzzjqzdh1', '机械制造及其自动化1班', '3', '002');
INSERT INTO `clazz` VALUES ('jxzzjqzdh2', '机械制造及其自动化2班', '3', '002');
INSERT INTO `clazz` VALUES ('jz1', '建筑1班', '5', '002');
INSERT INTO `clazz` VALUES ('qcfwgc1', '汽车服务工程1班', '7', '003');
INSERT INTO `clazz` VALUES ('qcfwgc2', '汽车服务工程2班', '7', '003');
INSERT INTO `clazz` VALUES ('rjgc1', '软件工程1班', '2', '001');
INSERT INTO `clazz` VALUES ('rjgc2', '软件工程2班', '2', '001');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('b414d36e954041e8ab27e6e38de62be0', '创业');
INSERT INTO `course` VALUES ('c1', '计算机组成原理');
INSERT INTO `course` VALUES ('c2', '操作系统');
INSERT INTO `course` VALUES ('c3', '数据结构');
INSERT INTO `course` VALUES ('c4', '计算机网络');
INSERT INTO `course` VALUES ('c5', '汽车构造');

-- ----------------------------
-- Table structure for `course_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `course_teacher`;
CREATE TABLE `course_teacher` (
  `id` varchar(32) NOT NULL,
  `course_id` varchar(32) NOT NULL,
  `teacher_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_teacher
-- ----------------------------
INSERT INTO `course_teacher` VALUES ('001', 'c1', 't1');
INSERT INTO `course_teacher` VALUES ('002', 'c3', 't2');
INSERT INTO `course_teacher` VALUES ('003', 'c5', 't3');
INSERT INTO `course_teacher` VALUES ('41f8c32e9c3d43a2846ada48048d3e3e', 'c4', 't5');
INSERT INTO `course_teacher` VALUES ('44ab8d66941743e2bda7bc91c9b032c5', 'c3', 't1');
INSERT INTO `course_teacher` VALUES ('59a38e0a89ab46eea2b9d1d2ee57a374', 'c3', 't4');
INSERT INTO `course_teacher` VALUES ('9637b1fec9f34cf19081fde0d4e655fe', 'c4', 't4');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` varchar(32) NOT NULL,
  `student_id` varchar(32) NOT NULL,
  `course_id` varchar(32) NOT NULL,
  `exam_time` date DEFAULT NULL,
  `exam_type` int(11) DEFAULT NULL,
  `score` double NOT NULL,
  `teacher_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('103e3e5766e143bfba98aa326345377e', '2015020001', 'c3', '2019-07-27', '1', '77', 't1');
INSERT INTO `grade` VALUES ('13e27ca9e14744b0bc273ce5c6e25fd3', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('16959d0bbfbc435f8c975f0812ee44e6', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('23d208ffb5314b9b96b9aed181347dce', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('27c92bc34d6f4449a099f02cef292b0c', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('29bc5ba09893493996fdd7d0c735432a', '2015010003', 'c5', '2019-07-27', '2', '75', 't3');
INSERT INTO `grade` VALUES ('46bce3d8969842d698238be0a8362a27', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('477e178e24ec4bd7a824ef3a6155f36a', '2015020002', 'c5', '2019-07-27', '1', '89', 't3');
INSERT INTO `grade` VALUES ('4c5131a3f1ea4095aef7ad998b4a05d3', '123475869', 'c3', '2019-07-27', '2', '55', 't1');
INSERT INTO `grade` VALUES ('6517a9514fab4624be70c2b2513c2c7f', '2015020001', 'c2', '2019-07-27', '1', '86', 't4');
INSERT INTO `grade` VALUES ('750ee5e3ed9b47eaba7162708d49778e', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('7c9db8f0c37a4ebf98dea91f7b31616c', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('89091bf37aa640b086d6ab6a32ea5524', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('bd966812ac6b403383ed63401b81abdd', '2015010001', 'c4', '2019-07-27', '1', '88', 't4');
INSERT INTO `grade` VALUES ('f96a5b16f6af4be59878beca328a5250', '2015010001', 'c3', '2019-07-27', '2', '88', 't4');

-- ----------------------------
-- Table structure for `institute`
-- ----------------------------
DROP TABLE IF EXISTS `institute`;
CREATE TABLE `institute` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of institute
-- ----------------------------
INSERT INTO `institute` VALUES ('001', '计算机科学与技术学院');
INSERT INTO `institute` VALUES ('002', '自动化学院');
INSERT INTO `institute` VALUES ('003', '汽车学院');
INSERT INTO `institute` VALUES ('19387011959141c5bbb7842b606c6703', '测试');
INSERT INTO `institute` VALUES ('8309970cb6714ca3b4b779b481c0ddf5', '大数据');
INSERT INTO `institute` VALUES ('d1616addf54d4fb5bd8ae608afe81d2e', '老师添加的学院11122');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `institute_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '计算机', '001');
INSERT INTO `major` VALUES ('194b357be7c9499d9962e7a023a37828', '测试专业66', '003');
INSERT INTO `major` VALUES ('2', '软件工程', '001');
INSERT INTO `major` VALUES ('3', '机械制造及其自动化', '002');
INSERT INTO `major` VALUES ('3cbd63fd5038452492886b62c51e825b', '测试', '001');
INSERT INTO `major` VALUES ('4', '电气自动化', '002');
INSERT INTO `major` VALUES ('5', '建筑', '002');
INSERT INTO `major` VALUES ('53b25acd23754923a172a920a7b02055', '测试专业33', '001');
INSERT INTO `major` VALUES ('6', '车辆工程', '003');
INSERT INTO `major` VALUES ('7', '汽车服务工程', '003');
INSERT INTO `major` VALUES ('8', '交通工程', '003');
INSERT INTO `major` VALUES ('jsj3', '计算机3班', '001');
INSERT INTO `major` VALUES ('test', '测试', '001');

-- ----------------------------
-- Table structure for `perms`
-- ----------------------------
DROP TABLE IF EXISTS `perms`;
CREATE TABLE `perms` (
  `id` varchar(32) NOT NULL,
  `name` varchar(10) NOT NULL,
  `url` varchar(255) NOT NULL,
  `type` int(1) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of perms
-- ----------------------------
INSERT INTO `perms` VALUES ('1', '系统设置', '/system', '0', null, '1');
INSERT INTO `perms` VALUES ('10', '学生修改', '/student/update', '2', '4', '10');
INSERT INTO `perms` VALUES ('11', '老师增加', '/teacher/add', '2', '5', '11');
INSERT INTO `perms` VALUES ('12', '老师删除', '/teacher/delete', '2', '5', '12');
INSERT INTO `perms` VALUES ('13', '老师修改', '/teacher/update', '2', '5', '13');
INSERT INTO `perms` VALUES ('14', '课程增加', '/course/add', '2', '6', '14');
INSERT INTO `perms` VALUES ('15', '课程删除', '/course/delete', '2', '6', '15');
INSERT INTO `perms` VALUES ('16', '课程修改', '/course/update', '2', '6', '16');
INSERT INTO `perms` VALUES ('17', '成绩增加', '/grade/add', '2', '7', '17');
INSERT INTO `perms` VALUES ('18', '成绩删除', '/grade/delete', '2', '7', '18');
INSERT INTO `perms` VALUES ('19', '成绩修改', '/grade/update', '2', '7', '19');
INSERT INTO `perms` VALUES ('2', '学院管理', '/institutePage', '1', '1', '2');
INSERT INTO `perms` VALUES ('20', '用户管理', '/usersPage', '1', '0', '20');
INSERT INTO `perms` VALUES ('21', '学院添加', '/institute/add', '2', '2', '21');
INSERT INTO `perms` VALUES ('22', '学院删除', '/institute/delete', '2', '2', '22');
INSERT INTO `perms` VALUES ('23', '学院修改', '/institute/update', '2', '2', '23');
INSERT INTO `perms` VALUES ('24', '用户添加', '/users/add', '2', '20', '24');
INSERT INTO `perms` VALUES ('25', '用户删除', '/users/delete', '2', '20', '25');
INSERT INTO `perms` VALUES ('26', '用户修改', '/users/update', '2', '20', '26');
INSERT INTO `perms` VALUES ('27', '分配角色', '/users/saveUserRoles', '2', '20', '27');
INSERT INTO `perms` VALUES ('28', '专业管理', '/majorPage', '1', '1', '28');
INSERT INTO `perms` VALUES ('29', '专业添加', '/major/add', '2', '28', '29');
INSERT INTO `perms` VALUES ('3', '班级管理', '/clazzPage', '1', '1', '3');
INSERT INTO `perms` VALUES ('30', '专业删除', '/major/delete', '2', '28', '30');
INSERT INTO `perms` VALUES ('31', '专业修改', '/major/update', '2', '28', '31');
INSERT INTO `perms` VALUES ('32', '班级添加', '/clazz/add', '2', '3', '32');
INSERT INTO `perms` VALUES ('33', '班级删除', '/clazz/delete', '2', '3', '33');
INSERT INTO `perms` VALUES ('34', '班级修改', '/clazz/update', '2', '3', '34');
INSERT INTO `perms` VALUES ('4', '学生管理', '/studentPage', '1', '1', '4');
INSERT INTO `perms` VALUES ('5', '老师管理', '/teacherPage', '1', '1', '5');
INSERT INTO `perms` VALUES ('6', '课程管理', '/coursePage', '1', '1', '6');
INSERT INTO `perms` VALUES ('7', '成绩管理', '/gradePage', '1', '1', '7');
INSERT INTO `perms` VALUES ('8', '学生添加', '/student/add', '2', '4', '8');
INSERT INTO `perms` VALUES ('9', '学生删除', '/student/delete', '2', '4', '9');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '老师');
INSERT INTO `role` VALUES ('3', '学生');

-- ----------------------------
-- Table structure for `role_perms`
-- ----------------------------
DROP TABLE IF EXISTS `role_perms`;
CREATE TABLE `role_perms` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `perms_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_perms
-- ----------------------------
INSERT INTO `role_perms` VALUES ('1', '1', '1');
INSERT INTO `role_perms` VALUES ('10', '1', '11');
INSERT INTO `role_perms` VALUES ('11', '1', '12');
INSERT INTO `role_perms` VALUES ('12', '1', '13');
INSERT INTO `role_perms` VALUES ('13', '1', '14');
INSERT INTO `role_perms` VALUES ('14', '1', '15');
INSERT INTO `role_perms` VALUES ('15', '1', '16');
INSERT INTO `role_perms` VALUES ('16', '2', '4');
INSERT INTO `role_perms` VALUES ('17', '2', '6');
INSERT INTO `role_perms` VALUES ('18', '2', '7');
INSERT INTO `role_perms` VALUES ('19', '2', '8');
INSERT INTO `role_perms` VALUES ('2', '1', '2');
INSERT INTO `role_perms` VALUES ('20', '2', '9');
INSERT INTO `role_perms` VALUES ('21', '2', '10');
INSERT INTO `role_perms` VALUES ('22', '2', '14');
INSERT INTO `role_perms` VALUES ('23', '2', '17');
INSERT INTO `role_perms` VALUES ('24', '2', '18');
INSERT INTO `role_perms` VALUES ('25', '2', '19');
INSERT INTO `role_perms` VALUES ('26', '3', '5');
INSERT INTO `role_perms` VALUES ('27', '3', '6');
INSERT INTO `role_perms` VALUES ('28', '3', '7');
INSERT INTO `role_perms` VALUES ('29', '1', '20');
INSERT INTO `role_perms` VALUES ('3', '1', '3');
INSERT INTO `role_perms` VALUES ('30', '1', '21');
INSERT INTO `role_perms` VALUES ('31', '1', '22');
INSERT INTO `role_perms` VALUES ('32', '1', '23');
INSERT INTO `role_perms` VALUES ('33', '2', '21');
INSERT INTO `role_perms` VALUES ('34', '1', '24');
INSERT INTO `role_perms` VALUES ('35', '1', '25');
INSERT INTO `role_perms` VALUES ('36', '1', '26');
INSERT INTO `role_perms` VALUES ('37', '1', '27');
INSERT INTO `role_perms` VALUES ('38', '2', '26');
INSERT INTO `role_perms` VALUES ('39', '3', '26');
INSERT INTO `role_perms` VALUES ('4', '1', '4');
INSERT INTO `role_perms` VALUES ('40', '1', '28');
INSERT INTO `role_perms` VALUES ('41', '1', '29');
INSERT INTO `role_perms` VALUES ('42', '1', '30');
INSERT INTO `role_perms` VALUES ('43', '1', '31');
INSERT INTO `role_perms` VALUES ('44', '1', '32');
INSERT INTO `role_perms` VALUES ('45', '1', '33');
INSERT INTO `role_perms` VALUES ('46', '1', '34');
INSERT INTO `role_perms` VALUES ('5', '1', '5');
INSERT INTO `role_perms` VALUES ('6', '1', '6');
INSERT INTO `role_perms` VALUES ('7', '1', '8');
INSERT INTO `role_perms` VALUES ('8', '1', '9');
INSERT INTO `role_perms` VALUES ('9', '1', '10');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `clazz_id` varchar(32) NOT NULL,
  `major_id` varchar(32) NOT NULL,
  `institute_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('123475869', '测试2', '1', '23', '1456789', 'jz1', '5', '002');
INSERT INTO `student` VALUES ('2015010001', '张三', '1', '22', '1356123456', 'jsj1', '1', '001');
INSERT INTO `student` VALUES ('2015010002', '李四', '1', '23', '00011122', 'jsj2', '1', '001');
INSERT INTO `student` VALUES ('2015010003', '王五', '2', '22', '1356123456', 'jsj2', '1', '001');
INSERT INTO `student` VALUES ('2015020001', 'Tom', '1', '21', '1356123456', 'clgc1', '6', '003');
INSERT INTO `student` VALUES ('2015020002', 'Sam', '2', '22', '1237894560', 'clgc2', '6', '003');
INSERT INTO `student` VALUES ('2015114143009', '测试', '1', '23', '110022', 'clgc1', '6', '003');
INSERT INTO `student` VALUES ('67b6937981cd443c80298bc4aad918d2', '测试学生', '1', '23', '13800138000', 'jsj1', '1', '001');
INSERT INTO `student` VALUES ('76bc4a39893d4fc29ee39521d29f0deb', 'mary', '2', '23', '115533', 'clgc1', '6', '003');
INSERT INTO `student` VALUES ('e64c64008c4148829047890ecdfb5c4c', '测试88', '1', '88', '13800138000', 'dqzdh1', '4', '002');

-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` varchar(32) NOT NULL,
  `student_id` varchar(32) NOT NULL,
  `course_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('0001', '2015010001', 'c1');
INSERT INTO `student_course` VALUES ('0002', '2015010002', 'c3');
INSERT INTO `student_course` VALUES ('0003', '2015020002', 'c5');
INSERT INTO `student_course` VALUES ('474ee48762be46ce85a92a18c2ef9272', '2015010001', 'c4');
INSERT INTO `student_course` VALUES ('4a6e9cf924b14dcda2a6f3faca6a421e', '2015010003', 'c5');
INSERT INTO `student_course` VALUES ('75096a396fb24420847cf8d1bfd80fa0', '2015020001', 'c2');
INSERT INTO `student_course` VALUES ('8811b915d92f433ea73e5a4a69e08dbc', '2015010001', 'c3');
INSERT INTO `student_course` VALUES ('a8c2313511f44198bf72211ca40d96ce', '123475869', 'c3');
INSERT INTO `student_course` VALUES ('e65498f54dd9434a917a27150e588fc9', '2015020002', 'c4');
INSERT INTO `student_course` VALUES ('ff75b8b8153d4713b73603d0fb76e72a', '2015020001', 'c3');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2c85b8ac07a24ab4bf50b2bfcc4dbb7f', 'test', '3');
INSERT INTO `teacher` VALUES ('t1', '张老师', '1');
INSERT INTO `teacher` VALUES ('t2', '王老师', '2');
INSERT INTO `teacher` VALUES ('t3', '李老师', '3');
INSERT INTO `teacher` VALUES ('t4', '胡老师', '1');
INSERT INTO `teacher` VALUES ('t5', '黄老师', '4');

-- ----------------------------
-- Table structure for `t_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `dict_code` int(10) NOT NULL,
  `dict_value` varchar(50) NOT NULL,
  `dict_type_code` varchar(20) NOT NULL,
  `dict_desc` varchar(255) DEFAULT NULL,
  `dict_order` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_sys_dict
-- ----------------------------
INSERT INTO `t_sys_dict` VALUES ('1', '1', '管理员', 'USERTYPE', '用户角色', '1');
INSERT INTO `t_sys_dict` VALUES ('2', '2', '老师', 'USERTYPE', '用户角色', '2');
INSERT INTO `t_sys_dict` VALUES ('3', '3', '学生', 'USERTYPE', '用户角色', '3');
INSERT INTO `t_sys_dict` VALUES ('4', '1', '是', 'YESNO', '是否', '1');
INSERT INTO `t_sys_dict` VALUES ('5', '0', '否', 'YESNO', '是否', '2');
INSERT INTO `t_sys_dict` VALUES ('6', '1', '教授', 'TITLE', '职称', '1');
INSERT INTO `t_sys_dict` VALUES ('7', '2', '副教授', 'TITLE', '职称', '2');
INSERT INTO `t_sys_dict` VALUES ('8', '3', '讲师', 'TITLE', '职称', '3');
INSERT INTO `t_sys_dict` VALUES ('9', '4', '助教', 'TITLE', '职称', '4');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_type` int(1) DEFAULT NULL,
  `enable` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', '1', '1');
INSERT INTO `user` VALUES ('425c8d9c407b4adf8231bb5dcb2818f2', 'zys', 'zys', '1', '1');
INSERT INTO `user` VALUES ('4561fa27c234489fbc771989c3f75513', 'Tom', 'Tom', '3', '0');
INSERT INTO `user` VALUES ('54dc97b5eb1c4367bd04adde6fa00f2d', 'aaa', 'a7cf41c6537065fe724cc9980f8b5635', '1', '1');
INSERT INTO `user` VALUES ('5f804fcce46c4c5085b08d06df12e653', '测试用户', '6fdd3867e67a720e75ca21668e2583cb', '1', '1');
INSERT INTO `user` VALUES ('87b67546e14b4ca99a4ea7228e0c471b', 'Sam', 'b813a346bc8b5222551a44c72bc177d9', '2', '1');
INSERT INTO `user` VALUES ('8fa44760c19844ba8b0dcf1bd658452d', '1111', '0932e71a76b6717fc6bc7f2e6c448370', '1', '1');
INSERT INTO `user` VALUES ('93c9797100f246ba8dab77324b09888c', 'my', '6728cac2cc861f57c2127c7dec1ae063', '2', '0');
INSERT INTO `user` VALUES ('9e93739ad17f4ab8883fdb4f114069b3', 'qiuxinfa', '2a0d82d168a087a5d6feb88126c4313d', '3', '1');
INSERT INTO `user` VALUES ('a2d5680da9c44bc083d7b954c5fa2fcd', 'aaaee', 'a7cf41c6537065fe724cc9980f8b5635', '3', '0');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '001', '1');
INSERT INTO `user_role` VALUES ('2', '87b67546e14b4ca99a4ea7228e0c471b', '2');
INSERT INTO `user_role` VALUES ('3', '9e93739ad17f4ab8883fdb4f114069b3', '3');
INSERT INTO `user_role` VALUES ('4', '425c8d9c407b4adf8231bb5dcb2818f2', '1');
INSERT INTO `user_role` VALUES ('8914361d68874add955bef2f5a313938', '8fa44760c19844ba8b0dcf1bd658452d', '1');
