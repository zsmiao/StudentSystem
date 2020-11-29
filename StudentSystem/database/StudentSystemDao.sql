/*
 Navicat Premium Data Transfer

 Source Server         : vm_CentOS_MySQL8.0
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.21.22:3306
 Source Schema         : StudentSystemDao

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 29/11/2020 11:16:14
*/

create database StudentSystemDao;

-- ----------------------------
-- Table structure for tb_User

use StudentSystemDao;

create table tb_User(					#用户表
User_name nvarchar(30) primary key,		#用户名				
Password_ varchar(30) not null			#密码
);

-- ----------------------------
-- Table structure for tb_Student

use StudentSystemDao;
create table tb_Student(		#学生表
Student_Id varchar(30) primary key,	#学生学号
Student_Name nvarchar(50) not null,		#学生姓名
Student_Sex nchar(1) default '男' not null ,	#学生性别
Grade int not null,	#年级
Classe int not null,	#班级
Major_Name nvarchar(50)  not null,	#专业名称
Department_Name nvarchar(50)  not null,	#院系名称