# Junit5

## 1.总览

### 1.1 Junit5是什么？

要说什么是 JUnit 5，首先就得聊下 Java 单元测试框架 JUnit，它与另一个框架 TestNG  占据了 Java领域里单元测试框架的主要市场，其中 JUnit 有着较长的发展历史和不断演进的丰富功能，备受大多数 Java 开发者的青睐。

而说到 JUnit 的历史，JUnit 起源于 1997年，最初版本是由两位编程大师 Kent Beck 和 Erich Gamma 的一次飞机之旅上完成的，由于当时 Java 测试过程中缺乏成熟的工具，两人在飞机上就合作设计实现了 JUnit 雏形，旨在成为更好用的 Java 测试框架。如今二十多年过去了，JUnit 经过各个版本迭代演进，已经发展到了 5.x 版本，为 JDK 8以及更高的版本上提供更好的支持 (如支持 Lambda ) 和更丰富的测试形式 (如重复测试，参数化测试)。

了解过 JUint 之后，再回头来看下 JUnit 5，这个版本可以说是 JUnit 单元测试框架的一次重大升级，首先需要 Java 8 以上的运行环境，虽然在旧版本 JDK 也能编译运行，但要完全使用 JUnit 5 功能， JDK 8 环境是必不可少的。

除此之外，JUnit 5 与以前版本的 JUnit 不同，拆分成由三个不同子项目的几个不同模块组成。

**JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage**

- **JUnit Platform**： 用于JVM上启动测试框架的基础服务，提供命令行，IDE和构建工具等方式执行测试的支持。

- **JUnit Jupiter**：包含 JUnit 5 新的编程模型和扩展模型，主要就是用于编写测试代码和扩展代码。

- **JUnit Vintage**：用于在JUnit 5 中兼容运行 JUnit3.x 和 JUnit4.x 的测试用例。

![img](https://user-gold-cdn.xitu.io/2019/9/17/16d3f06f79a94208?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

### 1.2 支持的Java版本

Junit5需要Java8及以上的环境，但也可以测试之前低版本的JDK编译的代码。

### 1.3 获取帮助

Stack Overflow: https://stackoverflow.com/questions/tagged/junit5
Gitter:https://gitter.im/junit-team/junit5

### 1.4 开始

#### 1.4.1 下载依赖

- bom

  groupId：org.junit

  artifactId：junit-bom

- junit

  ```xml
  <properties>
    <junit.jupiter.version>5.3.2</junit.jupiter.version>
  </properties>
  
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>${junit.jupiter.version}</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-params</artifactId>
      <version>${junit.jupiter.version}</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>${junit.jupiter.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  ```

#### 1.4.2 Junit5特性

- [Writing Tests in JUnit Jupiter](https://junit.org/junit5/docs/current/user-guide/#writing-tests)
- [Migrating from JUnit 4 to JUnit Jupiter](https://junit.org/junit5/docs/current/user-guide/#migrating-from-junit4)
- [Running Tests](https://junit.org/junit5/docs/current/user-guide/#running-tests)
- [Extension Model for JUnit Jupiter](https://junit.org/junit5/docs/current/user-guide/#extensions)
- Advanced Topics
  - [JUnit Platform Launcher API](https://junit.org/junit5/docs/current/user-guide/#launcher-api)
  - [JUnit Platform Test Kit](https://junit.org/junit5/docs/current/user-guide/#testkit)

### 1.4.3 示例工程

## 2.编写测试

### 2.1 注解

| Annotation               | Description                                                  |
| :----------------------- | :----------------------------------------------------------- |
| `@Test`                  | Denotes that a method is a test method. Unlike JUnit 4’s `@Test` annotation, this annotation does not declare any attributes, since test extensions in JUnit Jupiter operate based on their own dedicated annotations. Such methods are *inherited* unless they are *overridden*. |
| `@ParameterizedTest`     | Denotes that a method is a [parameterized test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests). Such methods are *inherited* unless they are *overridden*. |
| `@RepeatedTest`          | Denotes that a method is a test template for a [repeated test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests). Such methods are *inherited* unless they are *overridden*. |
| `@TestFactory`           | Denotes that a method is a test factory for [dynamic tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests). Such methods are *inherited* unless they are *overridden*. |
| `@TestTemplate`          | Denotes that a method is a [template for test cases](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-templates) designed to be invoked multiple times depending on the number of invocation contexts returned by the registered [providers](https://junit.org/junit5/docs/current/user-guide/#extensions-test-templates). Such methods are *inherited* unless they are *overridden*. |
| `@TestMethodOrder`       | Used to configure the [test method execution order](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order) for the annotated test class; similar to JUnit 4’s `@FixMethodOrder`. Such annotations are *inherited*. |
| `@TestInstance`          | Used to configure the [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) for the annotated test class. Such annotations are *inherited*. |
| `@DisplayName`           | Declares a custom [display name](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names) for the test class or test method. Such annotations are not *inherited*. |
| `@DisplayNameGeneration` | Declares a custom [display name generator](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator) for the test class. Such annotations are *inherited*. |
| `@BeforeEach`            | Denotes that the annotated method should be executed *before* **each** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, or `@TestFactory` method in the current class; analogous to JUnit 4’s `@Before`. Such methods are *inherited* unless they are *overridden*. |
| `@AfterEach`             | Denotes that the annotated method should be executed *after* **each** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, or `@TestFactory` method in the current class; analogous to JUnit 4’s `@After`. Such methods are *inherited* unless they are *overridden*. |
| `@BeforeAll`             | Denotes that the annotated method should be executed *before* **all** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, and `@TestFactory` methods in the current class; analogous to JUnit 4’s `@BeforeClass`. Such methods are *inherited* (unless they are *hidden* or *overridden*) and must be `static` (unless the "per-class" [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) is used). |
| `@AfterAll`              | Denotes that the annotated method should be executed *after* **all** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, and `@TestFactory` methods in the current class; analogous to JUnit 4’s `@AfterClass`. Such methods are *inherited* (unless they are *hidden* or *overridden*) and must be `static` (unless the "per-class" [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) is used). |
| `@Nested`                | Denotes that the annotated class is a non-static [nested test class](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested). `@BeforeAll` and `@AfterAll` methods cannot be used directly in a `@Nested` test class unless the "per-class" [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) is used. Such annotations are not *inherited*. |
| `@Tag`                   | Used to declare [tags for filtering tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering), either at the class or method level; analogous to test groups in TestNG or Categories in JUnit 4. Such annotations are *inherited* at the class level but not at the method level. |
| `@Disabled`              | Used to [disable](https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling) a test class or test method; analogous to JUnit 4’s `@Ignore`. Such annotations are not *inherited*. |
| `@Timeout`               | Used to fail a test, test factory, test template, or lifecycle method if its execution exceeds a given duration. Such annotations are *inherited*. |
| `@ExtendWith`            | Used to [register extensions declaratively](https://junit.org/junit5/docs/current/user-guide/#extensions-registration-declarative). Such annotations are *inherited*. |
| `@RegisterExtension`     | Used to [register extensions programmatically](https://junit.org/junit5/docs/current/user-guide/#extensions-registration-programmatic) via fields. Such fields are *inherited* unless they are *shadowed*. |
| `@TempDir`               | Used to supply a [temporary directory](https://junit.org/junit5/docs/current/user-guide/#writing-tests-built-in-extensions-TempDirectory) via field injection or parameter injection in a lifecycle method or test method; located in the `org.junit.jupiter.api.io` package. |

#### 2.1.1 元注解与组合注解

可以通过JUnit Jupiter的注解自定义组合注解进行使用。

定义：

```Java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
```

使用：

```Java
@Fast
@Test
void myFastTest() {
    // ...
}
```

### 2.2 测试类与方法

**Test Class**: any top-level class, `static` member class, or [`@Nested` class](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested) that contains at least one *test method*.

Test classes must not be `abstract` and must have a single constructor.

**Test Method**: any instance method that is directly annotated or meta-annotated with `@Test`, `@RepeatedTest`, `@ParameterizedTest`, `@TestFactory`, or `@TestTemplate`.

**Lifecycle Method**: any method that is directly annotated or meta-annotated with `@BeforeAll`, `@AfterAll`, `@BeforeEach`, or `@AfterEach`.

