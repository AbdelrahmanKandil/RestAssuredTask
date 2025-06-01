# API Testing Automation Framework

This project demonstrates automated API testing using Rest Assured, TestNG, and Java. It includes test cases for multiple APIs including PetStore and Reqres.

## 🚀 Features

- **PetStore API Testing**
  - Create new pets
  - Retrieve available pets
  - Validate pet details and status

- **Reqres API Testing**
  - User authentication
  - Token-based authorization
  - User data retrieval

## 🛠️ Technologies Used

- Java
- Rest Assured
- TestNG
- Maven
- Hamcrest Matchers
- SLF4J for logging

## 📋 Prerequisites

- Java JDK 8 or higher
- Maven
- IDE (IntelliJ IDEA recommended)

## 🔧 Setup and Installation

1. Clone the repository:
```bash
git clone https://github.com/AbdelrahmanKandil/RestAssuredTask.git
```

2. Navigate to project directory:
```bash
cd RestAssuredTask
```

3. Install dependencies:
```bash
mvn clean install
```

## 🧪 Running Tests

To run all tests:
```bash
mvn test
```

To run specific test class:
```bash
mvn test -Dtest=PetStoreTests
```

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── api/
│               └── test/
└── test/
    └── java/
        └── com/
            └── api/
                └── test/
                    ├── CreatePetTest.java
                    ├── PetStoreTests.java
                    └── ReqresLoginTest.java
```

## 🧪 Test Cases

### PetStore Tests
- `CreatePetTest`: Tests the creation of new pets
- `PetStoreTests`: Tests retrieving available pets

### Reqres Tests
- `ReqresLoginTest`: Tests user authentication and data retrieval

## 📝 API Documentation

### PetStore API
- Base URL: `https://petstore.swagger.io/v2`
- Endpoints:
  - POST `/pet`: Create a new pet
  - GET `/pet/findByStatus`: Get pets by status

### Reqres API
- Base URL: `https://reqres.in`
- Endpoints:
  - POST `/api/login`: User authentication
  - GET `/api/users/{id}`: Get user details

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- [Abdelrahman Kandil](https://github.com/AbdelrahmanKandil) - Initial work

## 🙏 Acknowledgments

- Rest Assured documentation
- TestNG documentation
- PetStore API documentation
- Reqres API documentation 