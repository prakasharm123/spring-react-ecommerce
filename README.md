
```markdown
# Full-Stack E-commerce Project

A modern full-stack e-commerce web application built using **Spring Boot** for the backend and **React.js** for the frontend.

## 🚀 Technologies Used
* **Backend:** Java, Spring Boot, Spring Data JPA
* **Frontend:** React.js, Vite, Axios
* **Database:** PostgreSQL
* **Build Tool:** Maven

## 📋 Prerequisites
Ensure the following tools are installed on your machine before getting started:
* [JDK 17+](https://adoptium.net/)
* [Node.js (LTS version)](https://nodejs.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [VS Code](https://code.visualstudio.com/)

## 🛠️ Setup Instructions

### 1. Clone the Repository
```bash
git clone [https://github.com/prakasharm123/spring-react-ecommerce.git](https://github.com/prakasharm123/spring-react-ecommerce.git)
cd spring-react-ecommerce

```

### 2. Database Setup

1. Create a new database in PostgreSQL:
`CREATE DATABASE your_db_name;`
2. Navigate to `SpringEcommApplication/src/main/resources/application.properties` and update your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password

```



### 3. Backend Setup

1. Open the `SpringEcommApplication` folder in IntelliJ IDEA.
2. Run the `SpringEcommApplication.java` file.
*The application will start at `http://localhost:8080`.*

### 4. Frontend Setup

1. Open your terminal in the `t-ecom` folder:
```bash
cd t-ecom

```


2. Install dependencies:
```bash
npm install

```


3. Start the development server:
```bash
npm run dev

```


*The frontend will be available at `http://localhost:5173`.*

## 💡 Contribution

Contributions are welcome! Please feel free to open a Pull Request for any bug fixes or feature enhancements.

---

*Developed by Prakash Sharma*


