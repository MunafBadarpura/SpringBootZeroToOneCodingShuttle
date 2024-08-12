# Home Work 5

## HomeWork Project Files

Security Application

-   [https://github.com/rudradcruze/SecurityApplication](https://github.com/rudradcruze/SecurityApplication)
-   [Security Application Local Zip](./SecurityApplication.zip)

## Detailed Report on the Internal Working of Spring Security

### Detailed Report on the Internal Working of Spring Security

Spring Security is a robust and customizable framework for securing Java applications, particularly web-based applications. It provides comprehensive security features, including authentication, authorization, and protection against common attacks like CSRF (Cross-Site Request Forgery). Understanding the internal workings of Spring Security involves delving into its key components and how they interact to enforce security policies in an application.

#### 1. **Core Components of Spring Security**

-   **SecurityContextHolder:**

    -   The `SecurityContextHolder` is at the heart of Spring Security. It stores the `SecurityContext`, which contains the `Authentication` object representing the currently authenticated user. The `Authentication` object holds details like the principal (user), credentials, and authorities (roles or permissions).
    -   The `SecurityContextHolder` can operate in three different modes:
        -   **ThreadLocal (default):** Associates the `SecurityContext` with the current thread, making it available throughout the entire request lifecycle.
        -   **InheritableThreadLocal:** Similar to `ThreadLocal`, but the context is inherited by child threads.
        -   **Global:** A single `SecurityContext` is shared across all threads.

-   **Authentication:**

    -   `Authentication` is the principal interface for representing the user’s credentials and authorities. It typically contains:
        -   **Principal:** The user's identity, often an instance of `UserDetails`.
        -   **Credentials:** Information used to authenticate the user, like a password.
        -   **Authorities:** A collection of `GrantedAuthority` objects representing the user's roles or permissions.
    -   When a user authenticates, an `Authentication` object is created and stored in the `SecurityContext`.

-   **AuthenticationManager:**

    -   The `AuthenticationManager` is responsible for authenticating a user. It processes an `Authentication` request and returns a fully authenticated object if successful.
    -   The `AuthenticationManager` is often implemented using `ProviderManager`, which delegates the authentication process to a chain of `AuthenticationProvider`s.

-   **AuthenticationProvider:**

    -   An `AuthenticationProvider` is responsible for performing specific authentication logic. Spring Security allows multiple `AuthenticationProvider`s to be configured, enabling various authentication mechanisms (e.g., LDAP, JDBC, OAuth).
    -   Each `AuthenticationProvider` tries to authenticate the request, and if one succeeds, the user is authenticated.

-   **UserDetailsService:**
    -   The `UserDetailsService` interface is a core component for loading user-specific data. It provides the `UserDetails` object, which contains user information such as username, password, and granted authorities.
    -   A typical implementation of `UserDetailsService` fetches user data from a database or other persistent storage.

#### 2. **Authorization Components**

-   **AccessDecisionManager:**

    -   The `AccessDecisionManager` is responsible for making authorization decisions. It takes the authenticated user’s details, the current request, and the security configuration, and determines whether the user has the required permissions to access a particular resource.
    -   `AccessDecisionManager` typically works with a collection of `AccessDecisionVoter`s, each of which votes on whether the access should be granted or denied.

-   **AccessDecisionVoter:**

    -   An `AccessDecisionVoter` is a strategy interface used by `AccessDecisionManager` to vote on authorization decisions. Each voter can either grant, deny, or abstain from voting based on the given security context.
    -   Common voters include `RoleVoter` (checks roles/authorities), `AuthenticatedVoter` (checks if the user is authenticated), and `WebExpressionVoter` (evaluates SpEL expressions).

-   **Security Interceptors:**
    -   Spring Security uses interceptors to enforce security at various levels of the application. There are different interceptors based on the context:
        -   **FilterSecurityInterceptor:** Secures HTTP requests and checks if the authenticated user has access to the requested resource.
        -   **MethodSecurityInterceptor:** Secures method invocations based on security annotations like `@PreAuthorize`, `@Secured`, etc.
        -   **AspectJMethodSecurityInterceptor:** An alternative to `MethodSecurityInterceptor`, specifically for securing methods using AspectJ.

#### 3. **Filter Chain and Security Filters**

-   **DelegatingFilterProxy:**

    -   The `DelegatingFilterProxy` is a bridge between the `Filter` in the Servlet API and Spring's managed beans. It delegates the filtering work to a Spring-managed bean, typically `FilterChainProxy`.

-   **FilterChainProxy:**

    -   The `FilterChainProxy` manages a list of security filters that apply to a specific request. Each filter in the chain is responsible for a different aspect of security (e.g., authentication, authorization, session management).
    -   The default filter chain in Spring Security includes filters like `UsernamePasswordAuthenticationFilter`, `BasicAuthenticationFilter`, `CsrfFilter`, `ExceptionTranslationFilter`, etc.

-   **Security Filters:**
    -   **UsernamePasswordAuthenticationFilter:** Handles form-based login and submits the user’s credentials to the `AuthenticationManager`.
    -   **BasicAuthenticationFilter:** Implements HTTP Basic Authentication by processing the `Authorization` header.
    -   **CsrfFilter:** Protects against CSRF attacks by ensuring that each request that can cause a change in the server state contains a valid CSRF token.
    -   **ExceptionTranslationFilter:** Catches any exceptions thrown during the security filter chain and handles them appropriately (e.g., redirecting to a login page on `AuthenticationException`).

#### 4. **Advanced Topics**

-   **OAuth2 and JWT:**

    -   Spring Security provides comprehensive support for OAuth2 and JWT-based authentication. OAuth2 is used for delegated authorization, allowing users to log in via third-party providers (like Google or Facebook), while JWT (JSON Web Token) provides a token-based authentication mechanism where the server issues tokens that clients present for subsequent requests.

-   **Method Security:**

    -   Method-level security in Spring Security can be implemented using annotations like `@Secured`, `@PreAuthorize`, and `@PostAuthorize`. These annotations check security constraints before or after method invocation.
    -   The `MethodSecurityInterceptor` works closely with the `AccessDecisionManager` to enforce these constraints.

-   **Security Expressions:**
    -   Spring Security provides powerful expression-based access control via SpEL (Spring Expression Language). Developers can define complex security rules directly in the configuration, such as `hasRole('ADMIN') and isFullyAuthenticated()`.

#### 5. **Spring Security Architecture**

The architecture of Spring Security is layered, allowing it to be highly customizable and extensible. The main layers include:

-   **Web Security Layer:**

    -   Deals with securing web requests using filters and interceptors. This is where most of the HTTP-based security configurations, such as URL-based authorization, CSRF protection, and session management, are applied.

-   **Service Layer:**

    -   Manages user details, roles, and permissions. The `UserDetailsService` and related components typically reside here.

-   **Domain Layer:**
    -   Contains the actual application logic and domain entities. Security annotations and method-level security apply in this layer.

#### Conclusion

Spring Security is a comprehensive framework designed to secure Java applications, offering a range of features for both authentication and authorization. Its flexible architecture allows developers to customize security configurations to meet their specific needs, whether that involves traditional form-based login, token-based authentication, or complex access control rules. Understanding the key components and their interactions is crucial for effectively using and extending Spring Security in any enterprise application.
