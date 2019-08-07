# this project is demo in Java
## document
+ mysql: 初始化数据库数据

## mybatis generator demo
执行 com.zhengcj.demo.mybatis.generator.Generator.main()，就可以生成：
+ com.zhengcj.demo.mybatis.mapper (in src/main/java/)
+ com.zhengcj.demo.mybatis.pojo (in src/main/java, 生成包含用户`swagger api`的相关信息)
+ mapper (src/main/resources)
> 多次执行，不会覆盖 `mapper`，而是append，导致重复定义问题。

详细实现步骤可参考 [链接](https://blog.csdn.net/u010358168/article/details/86246351)
