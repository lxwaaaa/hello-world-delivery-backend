# 1. DB相关

> 先把本地的MySQL和Redis关掉，或者换映射端口

## 1.1 启动数据库相关依赖

> 需要在当前工程目录下执行

~~~sh
docker-compose up
~~~

## 1.2 MySQL连接

- 账号：`root`

- 密码：`123456`

## 1.3 Redis

密码：`kBRRr6jdN5lcnstCl5jG`

# 2. Mapper

> Mapper直接继承我封装的BaseMapperX即可

# 3.代码注意事项

- 统一url：`http://127.0.0.1:9090/capgemini-demo/`
- 抛出业务异常直接使用BusinessException即可


