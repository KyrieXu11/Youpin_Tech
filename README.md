# 项目所用到的包

本项目采用的包如下：

+ SpringBoot 2.2.2 RELEASE
+ Mybatis
+ Lombok
+ Swagger（切换回2.9.2的版本就没问题了）
+ JJWT （jwt的一种实现）
+ druid

项目采用MAVEN多模块构建，依赖由下至上分别为 model -> dao -> service -> controller

数据库连接池采用的是druid

# 项目的大体思路

由于给一个表进行增删改查较容易，所以只说说第二个需求的实现思路。

首先将所有的请求都进行拦截，只放开登陆的请求

用户登陆的时候，进行校验，查询数据库中是否有这个用户的用户名，如果有的话将用户信息查询出来，和前端传递进来的用户的加密后的密码进行比对，如果一样则登陆成功，返回token

每次操作都需要将请求头中添加一个字段，”token“，并且值是登陆成功后返回的token

## 接口说明

| API                    | 请求方式 | 请求参数                             | 返回值             |
| ---------------------- | -------- | ------------------------------------ | ------------------ |
| /login                 | POST     | username,password                    | obj对应的即为token |
| /adduser               | POST     | username(非空), password(非空),email | 是否添加成功       |
| /deleteuser/{username} | delete   | username                             | 是否删除成功       |
| /updateuser            | PUT      | username（非空）,password,email      | 是否修改成功       |
| /allusers              | GET      |                                      | 查询所有的用户信息 |

## 操作演示

### 登陆

![aAInjU.png](https://s1.ax1x.com/2020/07/28/aAInjU.png)

### 添加用户

![aAI1E9.png](https://s1.ax1x.com/2020/07/28/aAI1E9.png)

### 修改用户信息

![aATQYR.png](https://s1.ax1x.com/2020/07/28/aATQYR.png)



### 查询所有的用户（密码没有设置为null，采用MD5加密）

![aATiYn.png](https://s1.ax1x.com/2020/07/28/aATiYn.png)

## 全局异常处理

使用全局异常处理来捕捉代码抛出的异常（自定义异常类）从而返回给前端一个正确的指引的消息

## 项目文档地址
```
http://localhost:8080/swagger-ui.html
```