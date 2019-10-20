# stuInfoManagerSys_shiro（采用shiro的学生管理系统）
项目中使用到的主要技术：后端：springBoot、shiro、Redis，前端主要使用thymeleaf模板引擎
下载项目后，到数据库执行sql脚本，src\main\resources\stuinfosys_shiro.sql，然后修改mysql和Redis等连接信息，启动项目后，在地址栏输入http://localhost:8080/login即可访问项目
项目中使用shiro实现了按钮级别的细粒度权限控制，对于管理员、老师和学生拥有不同的权限
