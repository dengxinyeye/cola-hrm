# 人事管理系统（Spring MVC + MyBatis + MySQL）

随着信息化与数字化进程的持续加速，传统以纸质与零散表格为主的人事管理方式，存在数据更新不及时、检索效率低、流程协同困难等问题，难以支撑现代企业在人员信息维护、岗位配置、通知公告与文档共享等方面的精细化需求。

本项目基于 B/S 架构，将人事数据集中存储于服务器端，通过标准浏览器即可访问与操作，不仅显著降低了客户端维护成本，也提升了业务流程的一致性与透明度。

## 一、项目简介

- 架构模式：B/S 架构
- 核心技术栈：
  - 后端：Spring MVC + MyBatis
  - 数据库：MySQL 8.x
  - 视图层：JSP / JSTL + jQuery + 常用 UI 插件
  - 容器：Apache Tomcat 9.0.x
  - 构建工具：Maven（打包类型为 `war`）
- 功能模块：
  - 用户登录与权限基础支持
  - 员工信息管理
  - 部门与岗位管理
  - 公告发布与维护
  - 文档维护与共享

数据访问层采用注解与动态 SQL Provider 的方式实现，既保障了 SQL 的可控与可优化性，又兼顾了开发维护的清晰性；视图层通过 JSP/JSTL 与 jQuery 等插件，实现表单交互、列表展示与统一的页面风格。应用部署于 Tomcat 容器，支持快速打包与迭代。

## 二、设计目标

1. 掌握基于 B/S 架构的人事管理系统的基本模块与数据流。
2. 熟悉 MySQL 在数据存储、约束与查询优化方面的常用实践，理解外键与检查约束如何保障数据一致性。
3. 通过 Spring MVC + MyBatis 的分层实现，强化对控制层、服务层与持久层职责边界的认识。
4. 在真实场景中验证动态 SQL、分页查询与事务管理的效果与注意事项，为后续扩展与优化提供实践基础。

后续可扩展方向包括但不限于：权限控制与审计日志的引入、复杂查询与索引优化、前端交互与用户体验增强、以及向 Spring Boot 的迁移以简化配置与部署流程。

## 三、运行环境与开发工具

- 操作系统：Windows 10 / 11
- JDK：JDK 1.8（需正确配置环境变量，`java -version` 可正常输出）
- Web 服务器：Apache Tomcat 9.0.x
- 数据库：MySQL 8.x
- 开发工具（任选其一）：
  - VS Code（安装 Java 相关扩展）
  - IntelliJ IDEA
- 依赖管理：Maven（项目类型为 `war`，可使用 Maven 打包或使用已有 hrmapp 目录部署）

## 四、数据库安装与初始化

1. 安装 MySQL 8.x，设置好 `root` 账号及密码。
2. 新建本系统使用的数据库，例如：

   ```sql
   CREATE DATABASE hrm_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   ```

3. 执行项目提供的 SQL 脚本以初始化表结构和基础数据：

   - 脚本位置（任选其一）：
     - DataStudio_20260112.sql
     - db.sql

   使用 MySQL 客户端或图形工具（如 Navicat）执行上述脚本后，将自动创建用户、员工、部门、公告等业务数据表并插入部分初始化数据。

## 五、项目导入与配置

1. 将项目源码复制到本地，例如 `cola-hrm` 目录。
2. 在 VS Code / IntelliJ IDEA 中以 **Maven 工程** 方式导入项目（根目录包含 pom.xml）。
3. 修改数据库配置文件：

   - 文件路径：db.properties
   - 配置内容（示例）：

     ```properties
     jdbc.driver=com.mysql.cj.jdbc.Driver
     jdbc.url=jdbc:mysql://localhost:3306/hrm_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
     jdbc.username=你的用户名
     jdbc.password=你的密码
     ```

4. 保存后，确保该配置文件会被打包/拷贝到 `WEB-INF/classes` 目录中（Maven 默认会将 resources 内容复制到 classes 及 `WEB-INF/classes`）。

## 六、项目构建与打包

可任选一种方式完成构建与打包。

### 方式一：使用 Maven 打包

在项目根目录执行：

```bash
mvn clean package -Dmaven.test.skip=true
```

构建成功后将生成：

- `target/hrmapp.war`
- 展开目录 hrmapp

### 方式二：使用 IDE / VS Code 编译

1. 在 IDE 中执行项目构建（Build/Compile），确保：
   - java 下的源码编译输出到 classes。
2. 使用已展开的 Web 应用目录：
   - 将 hrmapp 目录作为 Web 应用部署到 Tomcat 的 `webapps` 目录中。

## 七、部署到 Tomcat

1. 确认本机已有 Tomcat 9.0.x 安装目录（例如 `apache-tomcat-9.0.87`）。
2. 将生成的应用拷贝到 `tomcat/webapps/` 目录中：

   - 若使用 `hrmapp.war`：
     - 将 `target/hrmapp.war` 复制到 `tomcat/webapps/`，Tomcat 启动时会自动解压。
   - 若使用已展开目录：
     - 将 hrmapp 整个目录复制到 `tomcat/webapps/`，以 Exploded 方式运行。

3. 如有需要，可设置环境变量：

   - `CATALINA_HOME`：指向 Tomcat 安装目录
   - `CATALINA_BASE`：指向 Tomcat 实例目录（一般与安装目录一致）

4. 通过命令行启动 Tomcat（Windows）：

   ```bash
   cd %CATALINA_HOME%\bin
   startup.bat
   ```

## 八、系统运行与访问

1. 启动成功后，Tomcat 默认监听 `8080` 端口。
2. 在浏览器中访问系统首页：

   ```text
   http://localhost:8080/hrmapp/
   ```

3. 使用预置的测试账号登录系统，即可体验以下功能：

   - 用户管理
   - 员工信息管理
   - 部门与岗位管理
   - 公告管理
   - 文档维护等

> 如需调整上下文路径（`/hrmapp`），可修改 Tomcat 中对应应用的部署名称或 `server.xml` 中的 `<Context>` 配置。
