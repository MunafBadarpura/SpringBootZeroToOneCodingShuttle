# Home Work 3

## List of all the annotations I have seen so far in the Week 3

### JPA and Hibernate Annotations

1. `@Entity`
2. `@Table`
3. `@Id`
4. `@GeneratedValue(strategy = GenerationType.IDENTITY)`
5. `@Column(name = "name", nullable = false, length = 50)`
6. `@CreationTimestamp`
7. `@UpdateTimestamp`
8. `@UniqueConstraint(columnNames = {"email"})`
9. `@Index(name = "idx_name", columnList = "name")`
10. `@Index(name = "idx_department", columnList = "department")`
11. `@ManyToOne`
12. `@OneToMany`
13. `@JoinColumn`
14. `@JoinTable`

### Configuration Properties

1. `spring.jpa.hibernate.ddl-auto`
2. `spring.jpa.show-sql`
3. `spring.jpa.properties.hibernate.format_sql`
4. `spring.jpa.properties.hibernate.dialect`

### Relationship Annotations

1. `@OneToOne`
2. `@ManyToMany`

### Cascade Types

1. `CascadeType.ALL`
2. `CascadeType.PERSIST`
3. `CascadeType.MERGE`
4. `CascadeType.REMOVE`
5. `CascadeType.REFRESH`
6. `CascadeType.DETACH`

### Fetch Types

1. `FetchType.LAZY`
2. `FetchType.EAGER`

## HomeWork Project Files

-   [Course Managment System - Github](https://github.com/rudradcruze/CourseManagementSystem)
-   [Library Mangement System - Github](https://github.com/rudradcruze/LibraryManagementSystem)
