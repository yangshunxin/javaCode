/**
 * 
 */
package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yangs
 * 
 * 基本语法知识：
 * 	mysql关键字不区分大小写；
 * 	mysql的注释是 --
 * 
 * 	用mysql客户端连接数据库： mysql -uroot -ppassword   --连接到数据库
 * 	update mysql.user set authentication_string=password('123456') where user='root' and Host = 'localhost'; --修改用户名密码
 * 	flush privileges; -- 刷新权限
 *
 * 	exit; --退出连接；
 * 	ctrl + c --停止当前操作
 * 
 * 	--- 所有的语句都使用分号结尾
 * 	show databases;  -- 查看所有的数据库 
 * 
 * 	use 数据库名;  --切换数据库
 * 	show tables;  -- 查看数据库中所有的表
 * 	describe 表名; --显示数据库中表的所有信息
 * 
 * 	create database 新数据库名;  ---创建一个新数据库
 * 	数据库的语言包括四个：CRUD（增删改查）
 * 	DDL： 定义; DML： 操作;  DQL： 查询; DCL： 控制
 * 操作数据库：
 * 	1. 创建数据库
 * 		create database [if not exists] westos; --如果不存在就创建 westos这个数据库
 * 	2. 删除数据库
 * 		drop database [if exists] westos;  -- 删除一个数据库，[]可选
 * 	3. 切换和使用数据库：
 * 		use 数据库名  -- 如果 你的命名带有关键字，使用``(tab键上面的字符，引住)
 * 	4. 查看数据库
 * 		show databases   -- 查看所有的数据库
 *  
 * 操作数据库的表：
 * 	1. 创建数据库表：
 * 	数据库的列类型：
 * 		数值:
 * 			tinyint		十分小的数据		1个字节
 * 			smallint	较小的数据			2个字节
 * 			mediumint	中等大小的数据		3个字节
 * 			int			标准的整数			4个字节  常用的 java.int  ****
 * 			bigint		较大的数据			8个字节
 * 			float		浮点数			4个字节	*****
 * 			double		双精度浮点数		8个字节 （精度问题！！）
 * 			decimal		字符形式的字符串 金融计算的时候使用，一半使用decimal
 * 
 * 		字符串：
 * 			char		字符串固定大小 长度：0-255
 * 			varchar		可变字符串		0~65535		常用的变量 String *****
 * 			tinytext	微型文本		2^8 - 1		
 * 			text		文本串		2^16 - 1	保存大文本
 * 		时间日期:
 * 			java.util.Date对应
 * 			date		YYYY-MM-DD 	日期格式
 * 			time		HH:mm:ss	时间格式
 * 			datetime	YYYY-MM-DD HH:mm:ss 最常用的时间格式	*****
 * 			timestamp	时间戳， 1970.1.1到现在的毫秒树！ 也较为常用
 * 			year	年份表示 
 * 
 * 		null:
 * 			没有值，未知
 * 			注意，不要使用null进行运算
 * 
 * 	数据库的字段属性：
 * 		Unsigned：无符号的整数，声明了该列不能为负数；
 * 		zerofill: 0填充的，不足的位数，使用0来填充 int(3) 5--> 005
 * 		自增：自动在上一条记录的基础上+1（默认）；通常用来设计唯一的主键，必须为整型，可以设置自增的起始值和步长；
 * 	
 * 非空 null/not null
 * 		假设设置为 not null, 如果不给它赋值，就会报错；
 * 		null,如果不填写值，默认就是null
 * 
 * 默认：
 * 		设置默认的值，如果不指定，就是默认的值；	
 * 	
 * 阿里巴巴的文档中，每个表中必须有以下五个字段：
 * 	id			主键
 * 	`version`	乐观锁
 * 	is_delete	伪删除
 * 	gmt_create	创建时间
 * 	gmt_update	修改时间
 * 
 * 	创建表：
 * 	注意点：
 * 		使用英文的括号，表的名称和字段用``阔起来, 防止是关键字
 * 		AUTO_INCREMENT 自增
 * 		字符串使用 单引号括起来！
 * 		所有的语句后面加逗号","（英文下），最后一个不用加
 * 		PRIMARY KEY 主键，一般一个表只有一个唯一的主键
 * 		CREATE TABLE IF NOT EXISTS `student` (
 * 			`id` INT(4) NOT NULL COMMENT '学号' AUTO_INCREMENT,
 * 			`name` VAECHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
 * 			`pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
 * 			`birthday` timestamp DEFAULT NULL COMMENT '出生日期',
 * 			`address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
 * 			`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
 * 			PRIMARY KEY(`id`) 
 * 		)ENGINE=INNODB DEFAULT CHARSET=utf8
 *   下面是一个实际可用的导出：
 	   CREATE TABLE `jsd_jsd_check_log` (
 		  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 		  `url` varchar(255) NOT NULL COMMENT '图片链接',
		  `phone_type` varchar(30) NOT NULL DEFAULT '' COMMENT '手机型号',
		  `barcode` varchar(30) NOT NULL COMMENT '二维码',
		  `result` int(10) NOT NULL COMMENT '结果',
		  `ip` varchar(80) DEFAULT '' COMMENT 'ip地址',
		  `source` varchar(20) DEFAULT '' COMMENT '来源',
		  `check_type` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '1-AI验证；2-人工验证',
		  `message` varchar(200) NOT NULL DEFAULT '' COMMENT '提示信息',
		  `check_time` varchar(10) NOT NULL DEFAULT '' COMMENT '算法消耗时间',
		  `total_time` varchar(10) NOT NULL DEFAULT '0' COMMENT '总执行时间',
		  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=11279240 DEFAULT CHARSET=utf8mb4 COMMENT='记录嘉实多调用接口日志表'
 * 
 * 
 * 	格式：
 * 		create table [if not exists] `表名`(
 * 			`字段名1` 列类型 [属性] [索引] [注释],
 *  		`字段名2` 列类型 [属性] [索引] [注释],
 *   		`字段名3` 列类型 [属性] [索引] [注释]
 * 		)[表类型] [字符集设置] [注释]
 * 	
 * 	查看系统中创建数据库的语句：
 * 		show create database `数据库名`,
 * 	查看创建表名的语句：
 * 		show create table `表名`，
 * 	查看表结构：
 * 		DESC student  -- 显示表结果	
 * 	
 * 数据库引擎：
 * 	所有的数据库文件都保存在data目录下，一个文件夹就对应一个数据库
 * 	INNODB 默认使用 
 * 	MYISAM	早些年使用
 * 
 * 设置数据库表的字符集编码：
 * 	CHARSET=utf8
 * 	不设置就会使用sql默认的字符集编码（不支持中文）；
 * 
 * 2. 修改和删除数据库表
 * 	a.修改表名
 * 		alter table 旧表名 rename as 新表名
 * 	b.添加表的字段
 * 		alter table 表名 add 字段名 列属性,
 * 	c.修改表的字段（重命名，修改约束）
 * 		alter table 表名 modify 字段名 约束   -- 修改约束
 * 		例如： alter table teacher modify age varchar(11)   --- 原来age为int, 改成varchar(11)
 * 		alter table 表名 change 旧字段名 新字段名 [约束]    ----- 字段重命名
 * 		例如： alter table teacher1 change age age1 int(1)   --- 将原来的字段age 改成 age1 并且类型改成int(1)
 * 		删除表的字段
 * 		alter table 表名 drop 字段名
 * 	d.删除表
 * 		drop table [if exists] 表名
 * 
 * 	注意点：
 * 		1.所有的创建和删除都要加上判断，以免报错。
 * 		2.字段名用``括住
 * 		3.大小写不敏感
 * 		4.所有的符号用英文的
 * 
 * MySQL数据管理：
 * 	外键（了解即可）： 删除有外键关系的表的时候，必须要先删除引用人的表（从表），再删除被引用的表（主表）
 * 		有一个学生表student包括id、name、age、class字段，
 * 		还有一个年级表class包括id、name两个字段，此时学生表中的class对应年级表中的id,那么class表就对学生表构成列约束；
 * 	创建外键的两种方式：
 * 		第一种方式：写在应用sql的create内部：
 * 			KEY `FK_gradeid` (`gradeid`),  -- KEY:关键字， FK_gradeid: 别名， gradeid是当前表中的字段名
 * 			CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade`(`gradeid`), 
 * 			--  CONSTRAINT FOREIGN KEY REFERENCES：关键字， FK_gradeid： 别名， gradeid：当前表的字段名，`grade`(`gradeid`)： 外键的表名和字段名
 * 		第二种方式：写在外部，创建表是无外键，额外添加约束
 * 			ALTER TABLE `student` ADD CONSTRAINT `FK_gradeid` FOREIGN KEY(`gradeid`) REFERENCES `grade`(`gradeid`)
 * 			-- ALTER TABLE 表名 ADD CONSTRAINT 约束名  FOREIGN KEY(作为外键的列名) REFERENCES 那个表（那个字段）
 * 	以上操作都是物理外，数据库级别的外键，不建议使用；
 * 	最佳实践：
 * 		1. 数据库就是单纯的表，只用来存数据，只有行（数据）和列（字段）
 * 		2. 我们想使用多张表的数据，想使用外键，程序去查多张表即可！！！
 * 	
 * DML语言：包括插入、修改和删除	
 * 	
 * 	1.插入语句 insert：
 * 	insert into 表名([字段名1，字段名2,....字段名n]) values [(值1-1， 值1-2，...值1-n),(值2-1， 值2-2，...值2-n),...(值n-1， 值n-2，...值n-n)] 
 * 	插入语句，数据和字段必须一一对应, 自增的可以不管
 * 	例句：
 * 		insert into `grade` values("大四")  -- 省略字段，但值必须按顺序都补全，不能有多余的
 * 		insert into `grade`(`gradename`) values("大四")  -- 插入一条记录和一个字段
 * 		insert into `student`(`name`, `pwd`, `sex`) values("张三", "aaaaaaa", "male")  -- 插入一条记录和多个字段
 * 		insert into `grade`(`gradename`) values("大四"), ("大三")  -- 插入多条记录
 * 		insert into `grade`(`name`, `pwd`, `sex`) values("张三", "aaaaaaa", "male"), ("李四", "vvvv", "male")  -- 插入多条记录和多个字段
 * 	注意事项：
 * 		1.字段和字段之间使用 英文逗号隔开；
 * 		2. 字段是可以省略的，但是后面的值必须要一一对应，不能少；
 * 		3.可以同时插入多条数据，values后面的值用逗号隔开即可；
 * 
 * 	2.修改语句 update:
 * 	UPDATE 表名 set columnName = value, [columnName = value,...] where [条件]
 * 	例句： UPDATE `student` SET `birthday` = CURRENT_TIME WHERE name = "ysx" AND sex = 'female'
 * 	条件 where子句，表示在某个区间内修改
 * 		=为等于  <>或！=为不等于 >为大于 <为小于，>=为大于且等于 <=为小于且等于 
 * 		BETWEEN A and B 表示范围，闭区间[A, B]  AND为且， OR为或
 * 
 *	注意：
 *		1.columnName是数据库的列，尽量带上``
 *		2.条件，筛选的条件，如果没有指定，则会修改所有的列
 *		3.value 是一个具体的值，也可以是一个变量（CURRENT_TIME）
 *		4.多个设置的属性之间，使用英文逗号隔开  
 * 
 * 	3.删除命令
 * 		delete from 表名 [where 条件]
 * 		例句：
 * 			-- 删除数据（避免这样写，会全部删除）
 * 			delete from `student`
 * 			-- 删除指定数据
 * 			delete from `student` where id = 1
 * 		
 * 		truncate table 表名
 * 		完全清空一个数据库表，表的结果和索引约束不会变。
 * 		
 * 		delete 和 truncate 的区别：
 * 			truncate 自增器会设置为0， 不会影响事务；
 * 
 * DQL Data Query Language 数据查询语句
 * 		（1）所有的查询操作都用它， select
 * 		（2）简单和复杂的查询它都能做
 * 		（3）数据库中最核心的语言，最重要的语句
 * 		（4）使用频率最高的语句
 *
 * 	1. 指定查询字段：
 *  	用法： SELECT [字段名] FROM 表名
 * 		-- 查询全部的信息: 
 * 		select * from student
 * 		-- 查询指定字段
 * 		select `name`, `NO` FROM student
 * 		-- 可以跟显示的字段和显示的表的结果起别名 AS
 * 		select `name` AS 姓名, `NO` AS 学号 from student AS s
 * 		-- 将查询的结果拼接起来 函数 Concat(a, b)
 * 		select CONCAT('姓名：', `name`) AS 新名字 from student
 * 		-- distinct 去重
 * 		select distinct `NO` from `result`  -- 去处了重复的数据
 * 	2.查询表达式
 * 		用法： select 表达式 from 表名
 * 		数据库中的表达式： 文本值、列、函数、计算表达式、系统变量、null等等
 * 		-- 函数
 * 		select version()
 * 		-- 用来计算的表达式
 * 		select 100*3 -1 AS 计算结果
 * 		-- 查询自增的步长 变量
 * 		select @@auto_increment_increment
 * 		-- 结果 + 1 
 * 		select `NO`, `Result` + 1 AS 加分后 from result
 * 	3. where条件子句
 * 		作用： 检索数据中 符合条件 的值， 等值查询
 * 		搜索的条件由一个或者多个表达式组成！ 结果为布尔值
 * 		逻辑运算符：
 * 			与：and或&&   或：or或||    非：Not或！
 * 		-- 查询所有
 * 		select `NO`, `result` from result
 * 		-- 查询 成绩在 95~100之间的  
 * 		select `NO`, `result` from result where result>=95 and result<=100  -- and
 * 		select `NO`, `result` from result where result>=95 && result<=100  -- &&
 *		select `NO`, `result` from result where result between 95 and 100  -- between...and...
 *		-- 除了 1000号学生之外的同学的成绩
 *		select `NO`, `result` from result where `NO`!=1000 		-- !=
 *		select `NO`, `result` from result where not `NO`=1000 	-- not 
 *
 *	4. 模糊查询：
 *		比较运算符
 *			IS NULL 		如果表达式为NULL，则为真
 *			IS NOT NULL		如果表达式不为NULL，则为真
 *			BETWEEN a AND b	如果表达式在a和b之间，则为真
 *			Like b			如果表达式在b中，就为真，一般为比较字符串
 *			In (b1, b2...)	如果表达式在bx中，括号中是确定的元素
 *		例句：	
 *		-- 查询姓刘的同学				
 *		-- like结合 %（代表0到任意个字符）， _(一个字符)
 *		select `NO`, `name` from `student` where `name` LIKE '刘%'
 *		-- 查询姓刘的同学, 名字后面只有一个字
 *		select `NO`, `name` from `student` where `name` LIKE '刘_'
 *		-- 查询名字中有“嘉”字的同学
 *		select `NO`, `name` from `student` where `name` LIKE '_嘉_'	
 *		-- 查询指定学号的信息， 查询 1001， 1002，1003 号学员
 *		select `NO`, `name` from `student` where `no` IN (1001, 1002, 1003)	
 *		-- 查询地址为空的学生 null ''
 *		select `NO`, 'name' from `student` where address='' or address is null
 *	5. 连表查询
 *		用两个表（a_table, b_table）,关联字段a_table.a_id和b_table.b_id来演示SQL的内连接，外连接（左连接、右连接和全连接）
 *		建表语句：
 *			CREATE TABLE `a_table` ( `a_id` int(11) DEFAULT NULL, `a_name` varchar(10) DEFAULT NULL, `a_part` varchar(10) DEFAULT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 *			CREATE TABLE `b_table` ( `b_id` int(11) DEFAULT NULL, `b_name` varchar(10) DEFAULT NULL, `b_part` varchar(10) DEFAULT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 *		（1）内连接 inner join on
 *			select * from a_table a inner join b_table b on a.a_id = b.b_id;
 *			说明：组合两个表中的记录，返回关联字段相符的记录，返回都有的记录， 没有那个字段的内容为空
 *		（2）左连接 left join on 
 *			select * from a_table a left join b_table b on a.a_id = b.b_id;
 *			说明：left join 是left outer join的简写，它的全称是左外连接，是外连接中的一种；
 *				 左(外)连接，左表(a_table)的记录将会全部表示出来，而右表(b_table)只会显示符合搜索条件的记录。右表记录不足的地方均为NULL
 *		（3）右连接 right join on
 *			select * from a_table a  right outer join b_table b  on a.a_id = b.b_id;
 *			说明：right join是right outer join的简写，它的全称是右外连接，是外连接中的一种。
 *				 与左(外)连接相反，右(外)连接，左表(a_table)只会显示符合搜索条件的记录，而右表(b_table)的记录将会全部表示出来。左表记录不足的地方均为NULL。
 *		核心： 我要查询那些数据， 从那些表中查
 *		（4）自连接
 *			查询员工以及他的上司的名称，由于上司也是员工，所以这里虚拟化出一张上司表
 *			SELECT e.empName,b.empName from t_employee e LEFT JOIN t_employee b ON e.bossId = b.id;
 *	6. 分页和排序
 *		查询select完整语法:
 *		SELECT [ALL| DISTINCT] 
 *		{* | table.* | [table.field1 [as alias1] [,table.field2 [as alias2]] [,......]]}
 *		FROM tableName [as table_alias]
 *			[left | right | inner  join table_name2]   -- 联合查询
 *			[where ...]   -- 指定结果需满足的条件
 *			[group by ...] -- 指定结果按照哪几个字段来分组
 *			[having]	   -- 过滤分组的记录必须满足的次要条件
 *			[order by ...] -- 指定查询记录按一个或多个条件排序
 *			[LIMIT {[offset,] row_count | row_countOFFDET offset}]; -- 指定查询的记录从哪条至哪条
 *		注意： []括号代表可选的，{}括号代表必选的
 *		（1）排序
 *			排序方式包括两种：升序 ASC， 降序 DESC
 *			语法：ORDER BY 字段名 排序方式
 *		（2）分页
 *			语法：limit 当前页, 页面的大小 
 *			第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目； 初始记录行的偏移量是0
 *			
 *	7.子查询和嵌套查询
 *		where (select)
 *		-- 查询课程为 高等数学-2 且分数不小于 80 的同学的学号和姓名
 *		(1) 连接查询：
 *			select s.studentNo, studentName 
 *			From student s
 *			inner join result r
 *			on s.studentNo = r.studentNo
 *			inner join subject sub
 *			on r.subjectNo = sub.subjectNo
 *			where subjectName = '高等数学-2' and studentResult>=80
 *
 *		(2) 连接查询和子查询
 *			select distinct s.studentNo, studentName
 *			from student s
 *			inner join result r
 *			on r.studentNo = s.studentNo
 *			where studentResult >= 80 and subjectNo = (
 *				select subjectNo from subject where subjectName = '高等数学-2'
 *			)
 *
 *		(3) 纯子查询--速度快
 *			select studentNo, studentName from student where studentNo in (
 *				select studentNo from result where studentResult>80 and subjectNo = (
 *					select subjectNo from subject where subjectName = '高等数学-2'
 *				)
 *			)
 *	8.函数
 *		（1）常用函数
 *			-- 数学函数
 *			select ABS(-8)  -- 绝对值
 *			select ceiling(9.4) -- 向上取整
 *			select floor(9.4)  -- 向下取整
 *			select rand() -- 返回一个 0~1之间的随机数
 *			select sign(-10) -- 判断一个数的符号，0返回0， 负数返回-1， 正数返回 1
 *			
 *			-- 字符串函数
 *			select char_length('再小的帆也能远航')  -- 字符串长度
 *			select concat('我', '爱', '你') -- 拼接字符串
 *			select insert('我爱编程helloworld', 1, 2, '超级热爱')   -- 插入，并从某个位置开始替换某个长度
 *			select lower('ysx')  -- 小写字母
 *			select upper('ysx')  -- 大写字母
 *			select instr('ysx12345', 'x') -- 返回第一次出现的子串的索引
 *			select replace('上帝说坚持就能成功','坚持','努力了')  -- 替换出现的指定字符串
 *			select substr('上帝说坚持就能成功', 4, 6)  -- 返回指定的子字符串
 *			select reverse('清晨我上马')  -- 反转
 *			
 *			-- 查询姓 周， 改成 邹
 *			select replace(studentName, '周'， '邹') from student where studentName like '周%'
 *			
 *			--  时间和日期函数（记住）
 *			select current_date()  -- 获取当前日期
 *			select curdate()   -- 获取当前日期
 *			select now()  -- 获取当前的时间
 *			select localtime() -- 本地时间
 *			select sysdate()  -- 系统时间
 *
 *			-- 系统
 *			select system_user()
 *			select user()
 *			select version()
 *
 *		（2）聚合函数(常用)
 *			count()			计数
 *			sum()			求和
 *			avg()			平均值
 *			max()			最大值
 *			min()			最小值
 *			
 *			-- count
 *			select count(`BornDate`) from student;  -- Count(字段)， 会忽略所有的null值
 *			select count(*) from student;  -- count(*), 不会忽略null值，本质 计算行数
 *			select count(1) from student;  -- count(1), 不会忽略所有的null值，本质 计算行数
 *			-- sum avg max min
 *			select sum('studentResult') as 总和 from result
 *			select avg('studentResult') as 平均分 from result
 *			select max('studentResult') as 最高分 from result
 *			select min('studentResult') as 最低分 from result
 *	
 *	9. 数据库级别的MD5加密（扩展）
 *	什么是md5? 主要是增强算法复杂度和不可逆性。
 *		md5不可逆，相同的输入，加密后的值是一样滴；
 *		常用的方法：
 *			create table `testmd5`(`id` int(4) not null, `name` varchar(20) not null, `pwd` varchar(50) not null, primary key(`id`)) engine=innodb default charset=utf8
 *			-- 插入的时候加密，比较加密后的值
 *			insert into table values(1, 'xiaoming', md5('123456'))
 *		
 *	10. select小结：
 *		顺序很重要：
 *			select 去重 要查询的字段 from 表（注意：表和字段可以取别名）
 *			xxx join 要连接的表 on 等值判断
 *			where (具体的值，子查询语句)
 *			Group by (通过那个字段来分组)
 *			Having (过滤分组后的信息，条件和where是一样的，位置不同)
 *			order by 通过哪个字段排序 [升序/降序]
 *			limit startindex, pagesize
 *		
 *	11.事务
 *		什么是事务？
 *			一组sql操作，要么都成功，要么都失败；
 *			事务的原则 ACID原则；
 *		原子性：	要么都成功，要么都失败；
 *		一致性：	事务前后的数据完整性要保持一致
 *		隔离性：	多个用户访问数据库时，每个用户之间数据要隔离，不能相互影响
 *		持久性：	事务一旦提交则不可逆，被持久化到数据库中
 *		隔离会产生的一些问题：
 *			脏读：一个事务读取到了另外一个事务未提交的数据
 *			不可重复读：一个事务读取表中的某一行数据，多次读取结果不同；
 *			虚读（幻读）：在一个事务内读取到了别的事务插入的数据，导致前后读取不一致；
 *		-- 事务代码
 *		-- mysql 是默认开启事务自动提交的
 *		set autocommit = 0 -- 关闭事务自动提交
 *		
 *		-- 手动处理事务
 *		-- 事务开始
 *		start transaction  -- 标记一个事务开始，从这个之后的sql都在同一个事务
 *		
 *		insert xxx1
 *		insert xxx2
 *		
 *		-- 提交： 持久化
 *		commit
 *		-- 回滚： 回到原来的样子
 *		rollback
 *		-- 事务结束
 *		set autocommit = 1 -- 开启事务, 回到原来的状态
 *
 *		savepoint 保存点名   -- 设置一个事务的保存点
 *		rollback to savepoint 保存点名  -- 回滚到保存点
 *		release savepoint 保存点名  -- 撤销保存点
 *		
 *		sql 模拟转账：
 *		1. 创建表：
 *		create database shop character set utf8 collate utf8_general_ci 
 *		use shop
 *		2. 创建表
 *		create table `account`(
 *			`id` int(3) not null auto_increment,
 *			`name` varchar(300) not null,
 *			`money` decimal(9, 2) not null,
 *			primary key (`id`)
 *		)engine=innodb default charset=utf8
 *		3. 插入数据
 *		insert into account(`name`, `money`)
 *		value ('A', 200.00), ('B', 10000.00)
 *		4. 模拟转账
 *		set autocommit = 0; -- 关闭自动提交

		START TRANSACTION  -- 开启一个事务
		UPDATE account SET  money=money-500 WHERE `name` = 'A' --  A 减 500
		UPDATE account SET  money=money+500 WHERE `name` = 'B' --  B 加 500
		
		select * from `account`
		
		COMMIT;  -- 提交事务, 要被持久化
		ROLLBACK;  -- 回滚
		
		set autocommit = 1; -- 恢复默认值
 *
 *	12.索引：帮助mysql高效获取数据的数据结构；		
 *		在一个表中，主键索引只能有一个，唯一索引可以有多个。
 *		（1）主键索引（primary key）
 *			唯一的标识，主键不可重复，只能有一个列作为主键
 *		（2）唯一索引（unique key）
 *			避免重复的列出现，唯一索引可以重复，多个列都可以标识为 唯一索引
 *		（3）常规索引（key/index）
 *			默认的，index，key关键字来设置
 *		（4）全文索引（fulltext）
 *			在特定的数据库引擎下才有，myisam
 *			快速定位数据
 *		在创建表的时候给字段增加索引 或者 创建完毕后，增加索引（alter）
 *		show index from 表名 -- 显示所有的索引信息
 *		-- 增加一个全文索引（索引名） 列名
 *		alter table 表名.列明 add fulltext index 索引名（字段名）
 *		-- explain 分析sql执行的状况
 *		explain select * from student;
 *		
 *		索引在小数据量的时候，用处不大，但是在大数据的时候，区别十分明显
 *		测试索引：
 *		--  sql编程，插入100万条数据
		delimiter $$  -- 写在函数之前，必须写，标志
		CREATE FUNCTION mock_data()
		RETURNS INT
		BEGIN
			DECLARE num INT DEFAULT 1000000;
			DECLARE i INT DEFAULT 0;
		
			WHILE i<num DO
				-- 插入语句
				INSERT INTO `app_user` (`name`,`email`,`phone`,`gender`,`password`,`age`) 
				VALUES(CONCAT('用户', i),'12342432432@aa.com',CONCAT('18',FLOOR(RAND() * (999999999 - 100000000) + 100000000)),FLOOR(RAND() * 2),UUID(),FLOOR(RAND() * 100));
				SET i = i + 1;
			END WHILE;
			RETURN i;
		END;
		
		SELECT mock_data();
		SELECT * from app_user WHERE name='用户9999' -- 0.647s

		SELECT * from account  --  0.006s
		
		-- 创建索引 id_表名 _字段名
		-- CREATE xxx INDEX 索引名 on 表（字段）
		CREATE INDEX id_app_user_name on app_user(`name`)
		
		-- 创建索引后执行
		SELECT * from app_user WHERE name='用户9999' --  0.008s
		
		-- 清空表中的内容 
		TRUNCATE app_user
	索引的原则：
		索引不是越多越好，
		不要对经常变动的数据加索引
		小数据量的表不需要加索引
		索引一般加载常用的查询的字段上
	索引的数据结构： hash和Btree(innodb默认)
		
 *	13.用户管理
 *		创建用户
 *			create user 用户名 identified by '密码'
 *		修改用户
 *			-- 修改当前用户密码
 *			set password = password('123455')
 *			-- 修改指定用户的密码
 *			set password for ysx = password('123455')
 *			-- 重命名
 *			rename user 原来的名字 to 新名字
 *		删除用户
 *		权限管理
 *			-- 用户授权 all privileges 全部的权限 ， 库.表
 *			-- all privileges 除了跟其它用户授权的权限，其它的权限都可以了
 *			grant all privileges on *.* to 用户名
 *			-- 查询指定用户的权限
 *			show grants for 用户名  
 *			-- 撤销权限 revoke 哪些权限，在哪些库，给谁撤销
 *			revoke all privileges on *.* from 用户名
 *	
 *	14. 数据库备份
 *		为什么备份： 保证重要数据不丢失，数据转移；
 *		备份方式：
 *			1. 直接拷贝物理文件
 *			2. 用可视化工具
 *			3. 命令行下 导出 mysqldump命令：
 *				mysqldump -h主机 -u用户名 -p密码 数据库 > 物理磁盘的位置/文件名	
 *				mysqldump -h主机 -u用户名 -p密码 数据库 表名1  > 物理磁盘的位置/文件名	
 *				mysqldump -h主机 -u用户名 -p密码 数据库 表名1 表名2  > 物理磁盘的位置/文件名	
 *		导入： 
 *			登陆mysql: mysql -u用户名 -p密码 
 *			登陆的情况下，切换到指定的数据库，
 *			source 备份文件路径
 *	15.规范数据库设计
 *		良好的数据库设计：
 *			节省内存空间，保证数据库的完整性，方便我们开发系统
 *		数据库的设计：	
 *			分析需求，
 *			概要设计：设计关系图E-R图
 *		设计数据库的步骤（个人博客）：
 *			收集信息，分析需求：
 *				用户表（用户登陆注销，用户的个人信息，写博客，创建分类）
 *				分类表（文章分类，谁创建的）
 *				文章表（文章的信息）
 *				评论表
 *				友链表（友链信息）
 *				字定义表（ 一般包含两个字段，key:value）
 *				
 *			标识实体（把需求落地到每个字段）
 *			标识实体之间的关系：
 *				写博客： user->blog
 *				创建分类： user -> category
 *				关注： user ->user
 *				友链： links		
 *				评论表：user -> user -> blog
 *
 *	16.三大范式
 *		第一范式（1NF）：
 *			原子性：保证每一列不可再分
 *		第二范式(2NF):
 *			前提：满足第一范式
 *			每张表只描述一件事情
 *		第三范式（3NF）:
 *			前提：满足第一范式和第二范式
 *			第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。
 *		规范性和性能的问题：	
 *			关联查询不能超过三张表
 *	17.JDBC
 *		sun公司为了简化开发人员（对数据库的统一）操作，提供了一个java操作数据库的规范，俗称JDBC 
 *		这些规范的实现由具体的厂商（mysql, oracle, sql server等）去做；
 *		对于开发人员来讲，我们只需要掌握JDBC的操作即可！！！
 *		开发人员需要用到的东西：
 *			java.sql
 *			javax.sql
 *			还需要导入要给数据库驱动包 mysql-connector-java.5.1.47.jar
 *	
 *	18.sql注入
 *		sql存在漏洞，会被攻击导致数据泄露；sql会被拼接
 *	
 *	19.连接池
 *		最小连接数，最大连接数，等待超市时间
 *		编写连接池，实现一个接口 DateSource
 *		不需要编写连接数据库的代码
 *		开源的数据源实现：（拿来即用）
 *			DBCP： jar包：commons-dbcp-1.4.jar, commons-pool-1.6.jar
 *			C3P0： jar包：c3p0-0.9.5.5.jar, mchange-commons-java-0.2.19.jar
 *			Druid: 阿里巴巴
 *		无论使用什么数据源，dataSource的接口不变
 *
 */
public class MysqlOrder {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver"); // 固定写法，加载驱动. 这里面会注册驱动

		// 2.用户信息和url
		String urlString = "jdbc:mysql://rm-uf6s8m1k8m70jpijrpo.mysql.rds.aliyuncs.com:3306/shop?useUnicode-true&characterEncoding=utf8&useSSL=true";
		// String urlString =
		// "jdbc:mysql://localhost:3306/shop?useUnicode-true&characterEncoding=utf8&useSSL=true";
		String userNameString = "develop";
		String passwordString = "develop@123";
		// 3. 连接成功，数据库对象 Connection 代表数据库
		Connection connection = DriverManager.getConnection(urlString, userNameString, passwordString);

		// 4. 执行sql的对象 去执行 sql, 可能存在结果，查看返回的结果
		Statement statement = connection.createStatement();

		// 5. 执行sql的对象，可能有结果，查看
		String sqlString = "SELECT * from `users`";

		ResultSet resultSet = statement.executeQuery(sqlString); // 返回的结果集, 结果集中封装了我们全部查询的结果，为链表
		// statement.executeQuery(sqlString); // 更新，插入，删除都用这个，返回一个受影响的行数

		while (resultSet.next()) {
			System.out.println("id=" + resultSet.getObject("id"));
			System.out.println("name=" + resultSet.getObject("name"));
			System.out.println("pwd=" + resultSet.getObject("password"));
			System.out.println("email=" + resultSet.getObject("email"));
			System.out.println("birth=" + resultSet.getObject("birthday"));
			System.out.println("=========================================");
		}

		// 6. 释放连接
		resultSet.close();
		statement.close();
		connection.close();

	}

}
