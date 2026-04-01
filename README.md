# 🧑‍💼 Employee Management System

A full-stack **Employee Management System** built using **Spring Boot**, **Thymeleaf**, and **Spring Security**.
This application allows managing employees with role-based access control, form validation, and a user-friendly UI.

---

## 🚀 Features

* 🔐 **Authentication & Authorization**

  * Secure login/logout using Spring Security
  * Role-based access control (`ADMIN`, `EMPLOYEE`)
  * Restricted endpoints based on roles

* 👨‍💻 **Employee Management**

  * Add new employees
  * Update existing employee details
  * Delete employees (Admin only)
  * View employee list

* ✅ **Form Validation**

  * Input validation using `@Valid` and custom constraints
  * Error handling with user-friendly messages

* ⚠️ **Custom Error Handling**

  * Custom **404 page** for invalid URLs
  * Graceful error handling for better UX

* 🎨 **UI with Thymeleaf + Bootstrap**

  * Responsive design
  * Clean and simple interface

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot, Spring MVC
* **Security:** Spring Security
* **Persistence:** JPA / Hibernate
* **Frontend:** Thymeleaf, Bootstrap
* **Database:** MySQL
* **Build Tool:** Maven

---

## 📂 Project Structure

```
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── entity
 └── security

src/main/resources
 ├── templates
 ├── static
 └── application.properties
```

---

## 🔑 Roles & Access

| Role     | Permissions                         |
| -------- | ----------------------------------- |
| ADMIN    | Add, Update, Delete, View Employees |
| EMPLOYEE | View Employees only                 |

---

## ⚙️ Setup & Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   ```

2. Navigate to the project folder:

   ```bash
   cd employee-management-system
   ```

3. Configure database in `application.properties`

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Open in browser:

   ```
   http://localhost:8080
   ```



## 📌 Future Improvements

* 🌐 REST API version
* 🔍 Search & Pagination
* ☁️ Deployment (AWS / Render)



## 🙌 Acknowledgements

Built as part of learning **Spring Boot** and real-world backend development.

---

## 📬 Contact

If you have any questions or suggestions, feel free to connect!

- 🔗 GitHub: [aryansiwach003](https://github.com/aryansiwach003)


---
