# Spring Boot Starter Mail

Spring Boot Starter Mail is a starter module provided by Spring Boot that simplifies the configuration and usage of email functionality in a Spring Boot application. It provides auto-configuration for email sending capabilities using the JavaMail API.

By including the spring-boot-starter-mail dependency in your project, you can easily configure and use email functionality without dealing with the low-level details of setting up the mail infrastructure.

The Spring Boot Starter Mail module includes the necessary dependencies and auto-configuration to work with popular email servers and protocols. It sets up the JavaMailSender bean, which you can inject into your components or services to send emails.

Additionally, Spring Boot Starter Mail also provides configuration properties in the application.properties file to customize the email settings such as the host, port, username, password, and more.

# Sending Emails

To send emails, follow these steps:

1. Create a service class for sending emails.

2. Inject the JavaMailSender bean into your service.

3. Use the JavaMailSender to create a SimpleMailMessage  object and set the necessary properties like recipients, subject, and body.

4. Call the send() method of the JavaMailSender to send the email.

The JavaMailSender is configured automatically by Spring Boot based on the properties defined in the application.properties file.

With this setup, we can send emails in your Spring Boot application without dealing with the low-level details of configuring the email server and protocols.

# Java Mail Sender

JavaMailSender is an interface provided by the Spring Framework that serves as a high-level abstraction for sending emails using the JavaMail API. It encapsulates the functionality required to send email messages, allowing for easy integration and configuration within a Spring application.

The JavaMailSender interface provides a set of methods for sending email messages, including plain text emails, HTML emails, and emails with attachments. It abstracts the underlying email-sending mechanism, allowing you to focus on composing and sending emails rather than dealing with the intricacies of the JavaMail API.

# Simple Mail Message

SimpleMailMessage is a class provided by the Spring Framework that represents a simple email message. It is a convenient way to construct and send basic text-based emails using the JavaMail API.

The SimpleMailMessage class provides methods to set various properties of an email, such as the sender, recipient(s), subject, and text body. It is a lightweight class that simplifies the process of creating and sending plain text emails without attachments or complex formatting.

# Further Conclusion

If you need to send emails with HTML content or attachments, you may need to use MimeMessage instead, which provides more flexibility and functionality.

---------------
# Extra Terms

# Entity Annotation

The `@Entity` annotation is used in the Java Persistence API (JPA) to designate a Java class as an entity, representing a table in a relational database. It indicates that instances of the class can be persisted to a database table using the ORM (Object-Relational Mapping) approach.

When an entity class is annotated with `@Entity`, it is expected to have a corresponding table in the database with the same name as the entity class (unless specified otherwise using the `@Table` annotation).

An entity class must have a no-argument constructor, and it can have additional constructors for convenience.

# Id Annotation

The `@Id` annotation is used in the Java Persistence API (JPA) to mark a field or property as the primary key of an entity. It specifies that the annotated field or property represents the unique identifier for instances of the entity class.

By default, JPA assumes that the primary key is a column named "id" in the corresponding database table. However, you can customize the column name and other aspects using additional JPA annotations like `@Column` or `@GeneratedValue`.

The `@Id` annotation can be used with different types of primary keys, including simple types (such as `Long`, `Integer`, or `String`) or composite keys (using multiple fields or embedded objects).

# Table Annotation

The `@Table` annotation is used in the Java Persistence API (JPA) to specify the details of the database table associated with an entity class. It allows you to customize the table name, schema, and other properties related to the table mapping.

By default, JPA assumes that the table name matches the entity class name. However, you can override this default behavior by providing a different table name as a parameter to the name attribute of the `@Table` annotation.

# GeneratedValue Annotation

The `@GeneratedValue(strategy = GenerationType.IDENTITY)` annotation is used in the Java Persistence API (JPA) to specify the strategy for generating unique identifier values for entities automatically. It is typically applied to a field or property annotated with `@Id` to indicate how the primary key values should be generated.

The `GenerationType.IDENTITY` strategy indicates that the primary key values will be automatically generated by the underlying database system. It relies on an auto-incrementing column in the database to assign unique identifiers.

When using the `GenerationType.IDENTITY` strategy, the database is responsible for generating and assigning the primary key values when new entities are persisted.

Other strategies include:

- `GenerationType.AUTO`: This strategy allows the persistence provider to choose an appropriate generation strategy based on the database capabilities.
- `GenerationType.SEQUENCE`: This strategy uses a database sequence to generate unique identifier values.
- `GenerationType.TABLE`: This strategy uses a separate database table to generate unique identifier values.
- `GenerationType.UUID`: This strategy generates a unique identifier using the universally unique identifier (UUID) algorithm.

For MySQL databases, the most commonly recommended strategy for generating primary key values is `GenerationType.IDENTITY`.

# Column Annotation

The `@Column(columnDefinition = "datetime")` annotation is used in the Java Persistence API (JPA) to specify the SQL column definition for a specific field or property of an entity. It allows you to define the exact database column type and constraints for the annotated attribute.

In the case of `@Column(columnDefinition = "datetime")`, it explicitly sets the database column type to `datetime`. This means that the corresponding column in the database table will have the datetime data type, which represents a date and time value.

Using `columnDefinition` allows you to define the column type directly, bypassing any implicit type mapping done by the JPA provider. This can be useful in scenarios where you need to use database-specific types or override the default mapping behavior.

Other attributes such as `name`, `nullable`, `length`, and `precision` provide additional control over the column mapping and constraints.
