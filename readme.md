# School Management Website

This repository contains the codebase for a School Management Website developed using Java Spring Boot 3, MapStruct, and Lombok. The website encompasses functionalities related to students, teachers, classrooms, and administration, with specific roles and features for students.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used

- Java Spring Boot 3
- MapStruct
- Lombok

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone <repository_url>
   cd school-management-website
   ```

2. **Build and Run using Maven:**

   ```bash
   mvn clean install
   java -jar target/school-management-website-<version>.jar
   ```

3. **Access the Website:**

   Open a web browser and go to `http://localhost:8080`.

## Project Structure

The project structure follows a standard Maven Spring Boot application structure. Key components and packages include:

- `src/main/java/com/example/schoolmanagement`: Main package for the application.

  - `controller`: Contains API controllers.
  - `dto`: Data Transfer Objects (DTOs) used for mapping.
  - `mapper`: MapStruct mappers for entity to DTO mapping.
  - `model`: Entity classes representing data models (e.g., Student, Teacher, Classroom).
  - `service`: Service classes handling business logic.
  - `repository`: Data repositories and database access logic.
  - `SchoolManagementApplication.java`: Entry point of the Spring Boot application.

- `src/main/resources`: Contains application properties and configuration.

## Usage

The School Management Website provides the following functionalities:

- **Student Role:**

  - View student profile.
  - Access and manage personal information.

- **Teacher Role:**

  - View teacher profile.
  - Access and manage personal information.
  - View and manage classroom information.

- **Classroom Management:**

  - Add, update, and remove classrooms.

- **Admin Role:**
  - Access and manage all functionalities.
  - Add, update, and remove students, teachers, and classrooms.

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature/your-feature`.
3. Make your changes and commit them: `git commit -m 'Add a new feature'`.
4. Push to the branch: `git push origin feature/your-feature`.
5. Submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
