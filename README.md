# 🌿 VocabVault

> **Manage and dynamically practice English vocabulary with a custom-built full-stack platform.**

VocabVault is a web application designed to help English teachers and students organize vocabulary efficiently. Instead of relying on static word lists, this platform stores translations, English definitions, synonyms, and parts of speech to encourage context-based learning over literal translation. It also features a dynamic randomizer to generate warm-up activities for different classroom levels.

## ✨ Features
* **Full CRUD Functionality:** Add, view, and organize vocabulary words with detailed attributes (Definition, Synonyms, Part of Speech, Example Sentence).
* **Level-Based Categorization:** Words are classified by proficiency levels (Start Up 1 through 8, and TOEFL) for targeted studying.
* **Dynamic Randomizer:** Fetches a random word from the database either globally or filtered by level. Perfect for "Word of the Day" classroom icebreakers.
* **Aesthetic & Responsive UI:** A clean interface built from scratch without heavy frontend frameworks.

## 🛠️ Tech Stack
* **Backend:** Java 17, Spring Boot (REST API architecture)
* **Database:** MySQL, Spring Data JPA (Hibernate for ORM)
* **Frontend:** HTML5, CSS3, Vanilla JavaScript (Fetch API)
* **Architecture:** Object-Oriented Programming (OOP) and MVC-inspired structure.

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* MySQL or MariaDB running locally
* Maven

### Installation & Setup

1. **Clone the repository:**
git clone https://github.com/melanie-garza/vocabvault.git
cd vocabvault

2. **Database Configuration:**
Log into your local MySQL instance and create the database:
CREATE DATABASE vocab_db;

3. **Application Properties:**
Open src/main/resources/application.properties and update the MySQL credentials with your local username and password:
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

4. **Run the Application:**
Execute the following command in your terminal:
./mvnw spring-boot:run

The application will be available at http://localhost:8080.

---
*Built by (https://github.com/melanie-garza) - English Instructor & Computer Science Student*
