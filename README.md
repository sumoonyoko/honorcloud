# 王者荣耀-巅峰明月战队微服务项目

** 队长温馨提示：适度娱乐游戏，学业事业为重；谨防代练诈骗，保护财产安全！ **

** honorcloud.git项目地址 :  [honorcloud](https://github.com/sumoonyoko/honorcloud "honorcloud") **

honorcloud项目是专为王者荣耀-巅峰明月战队研发的官网微服务项目。
其中重要模块包括：
- [x] 战队基本信息资料概况
- [x] 战队加群途径方式
- [x] 战队规章制度公告
- [ ] 战队成员战绩图床
    - [ ] 公共上传途径
    - [ ] 公共下载途径
    - [ ] 公共展示界面
- [ ] 战队开黑组队预定
    - [ ] 战队赛组队
    - [ ] 战队内战
    - [ ] 战队开黑

## honorcloud-技术架构介绍

- 编程语言：    java
- 为核心框架：  springboot+mybtis-plus
- 日志输出：    logback+slf4j
- 数据库：      mysql
- 接口：       RESTful格式
- 文档：      http://localhost:8080/swagger-ui.html

## 数据库配置
```
 datasource:
    url: jdbc:mysql://106.12.216.153:3306/honor?autoReconnect=true&useUnicode=true&characterEncoding=utf8
    username: root
    password: Sumoon2812@top
    driver-class-name: com.mysql.cj.jdbc.Driver
```
##  RESTful接口设计
+ 用户登录
    + QQ登录
	+ 管理员登录
+ 权限系统
    + 管理员权限
    + 用户权限
+ 战绩
    * 上传
    * 下载
    * 查询
+ 组队
    * 创房间
    * 加入房间
    * 退出房间
	* 解散房间
