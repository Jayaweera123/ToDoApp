# 📝 To-Do Task Web Application

A full-stack To-Do task management application built with React, Tailwind CSS, Spring Boot, and MySQL. The app allows users to create tasks, view the latest 5 tasks, and mark tasks as completed.

## 🚀 Features
✅ Create a new to-do task with a title and description.  
✅ Display only the most recent 5 uncompleted tasks.  
✅ Mark tasks as completed (they will be removed from the UI).  
✅ SweetAlert2 for better user notifications.  
✅ Fully containerized with Docker & Docker Compose.  
✅ Unit tests for the backend.  
✅ Unit tests for the frontend components.  

## 🛠 Tech Stack
**Frontend:** React, Vite, Tailwind CSS, SweetAlert2 (for alerts)  
**Backend:** Spring Boot  
**Database:** MySQL  

### Other Tools
- Docker (for containerization)  
- JUnit 5 (Backend Testing)  
- React Testing Library, Selenium IDE (Frontend Testing)  

## 📦 Setup & Installation

### Clone the Repository
```bash
git clone https://github.com/Jayaweera123/ToDoApp.git
cd todo-app
```

## 🐳 Running the App with Docker

### 1️⃣ Start the Containers
```bash
docker-compose up
```
This will pull the image from Docker Hub and run it.

This will:
- Start MySQL
- Start Spring Boot Backend
- Start React Frontend

It will take **3 minutes** to initialize the MySQL database. Until the initialization is complete, the backend will not start running.  
If the backend does not start after **5 minutes**, please restart the containers.

- The backend will run at 👉 **http://localhost:8080**  
- The frontend will be available at 👉 **http://localhost:4173**  

### 2️⃣ Stop the Containers
```bash
docker-compose down
```

## 🧪 Running Tests

### Backend (Spring Boot)
Run unit tests & integration tests:
```bash
cd backend
```
Open TaskControllerTest.java
Click the green Run icon next to each test method
Run all tests by clicking the green Run icon at the class level

### Frontend (React)
Run unit tests for components:
```bash
cd frontend
npm test
```

## 📡 API Endpoints

| Method | Endpoint      | Description             |
|--------|-------------|-------------------------|
| POST   | `/tasks`    | Create a new task       |
| GET    | `/tasks`    | Get the latest 5 tasks  |
| PUT    | `/tasks/{id}` | Mark a task as completed |

### Example request to create a task:
```json
{
  "title": "Learn Docker",
  "description": "Understand how to containerize applications"
}
```

## 📷 UI Preview
![ToDo App](https://github.com/user-attachments/assets/193c66f3-24cf-4674-9dd8-385fed596524)

## 🙌 Contribution
1. Fork this repository.  
2. Create a new branch.  
3. Commit your changes.  
4. Open a Pull Request.  
