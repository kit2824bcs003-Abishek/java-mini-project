# 📝 Online Exam Portal (Java + JDBC)

A simple console-based Online Exam Portal built using Java and JDBC with MySQL database connectivity. This project allows users to log in, take a multiple-choice exam, and view their score.

---

## 🚀 Features

* User authentication (login system)
* Questions fetched dynamically from database
* Multiple-choice exam system
* Automatic score calculation
* Simple console-based interface

---

## 🛠️ Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL
* SQL

---

## 📂 Project Structure

```
OnlineExamPortal.java
```

---

## ⚙️ Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE exam_portal;

USE exam_portal;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question TEXT,
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    correct_option INT
);

INSERT INTO users(username, password) VALUES ('admin', '1234');

INSERT INTO questions(question, option1, option2, option3, option4, correct_option) VALUES
('Java is?', 'Programming Language', 'Database', 'OS', 'Browser', 1),
('JDBC stands for?', 'Java Database Connectivity', 'Java Data Code', 'Joint DB Code', 'None', 1);
```

---

## 🔌 JDBC Setup

1. Download MySQL Connector/J
2. Add the `.jar` file to your project classpath

---

## ▶️ How to Run

1. Compile the program:

```
javac OnlineExamPortal.java
```

2. Run the program:

```
java OnlineExamPortal
```

---

## 🔐 Default Login Credentials

```
Username: admin
Password: 1234
```

---

## 📸 Sample Output

```
===== LOGIN =====
Username: admin
Password: 1234

Java is?
1. Programming Language
2. Database
3. OS
4. Browser
Your Answer: 1

===== RESULT =====
Your Score: 2
```

---

## 📌 Future Enhancements

* GUI using Swing or JavaFX
* Timer-based exams
* Admin panel to add/edit questions
* Web-based version using Servlets/JSP
* Result storage and analytics

---

## 🤝 Contributing

Contributions are welcome. Feel free to fork this repository and submit a pull request.

---

## 📄 License

This project is open-source and available under the MIT License.
