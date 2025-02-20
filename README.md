# 📝 To-Do Task Web Application

A full-stack To-Do task management application built with *React, Tailwind CSS, Spring Boot, and MySQL*. The app allows users to create tasks, view the latest 5 tasks, and mark tasks as completed.

---

## 🚀 Features
✅ Create a new to-do task with a title and description.  
✅ Display only the *most recent 5 uncompleted* tasks.  
✅ Mark tasks as completed (they will be removed from the UI).  
✅ *SweetAlert2* for better user notifications.  
✅ Fully containerized with *Docker & Docker Compose*.  
✅ *Unit and integration tests* for the backend.  
✅ *Unit tests* for the frontend components.  

---

## 🛠 Tech Stack
### *Frontend*
- ⚛ React  
- 🎨 Tailwind CSS  
- 🔔 SweetAlert2 (for alerts)  

### *Backend*
- ☕ Spring Boot  
- 🗄 MySQL  
- 🔄 RESTful API  

### *Other Tools*
- 🐳 Docker (for containerization)  
- 🧪 JUnit 5, Mockito (Backend Testing)  
- 🧪 React Testing Library, Jest (Frontend Testing)  

---

## 📂 Project Structure


/todo-app
│── backend/                     # Spring Boot Backend
│   ├── src/main/java/com/todo/  # Java Source Code
│   ├── src/test/java/com/todo/  # Unit & Integration Tests
│   ├── Dockerfile               # Backend Dockerfile
│   ├── pom.xml                  # Maven Dependencies
│── frontend/                    # React Frontend
│   ├── src/                     # React Source Code
│   ├── src/components/          # React Components
│   ├── src/tests/               # Unit Tests
│   ├── Dockerfile               # Frontend Dockerfile
│   ├── package.json             # Dependencies
│── docker-compose.yml           # Docker Compose Config
│── README.md                    # Project Documentation


---

## 📦 Setup & Installation

### *1️⃣ Clone the Repository*
bash
git clone https://github.com/your-username/todo-app.git
cd todo-app


### *2️⃣ Set Up Environment Variables*
Create a .env file inside backend/ with the following values:


SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/tododb
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root


---

## 🐳 Running the App with Docker

### *1️⃣ Start the Containers*
bash
docker-compose up --build

This will:
- Start *MySQL*
- Start *Spring Boot Backend*
- Start *React Frontend*  

The *backend* will run at 👉 http://localhost:8080  
The *frontend* will be available at 👉 http://localhost:3000

### *2️⃣ Stop the Containers*
bash
docker-compose down


---

## 🧪 Running Tests

### *Backend (Spring Boot)*
Run *unit tests & integration tests*:
bash
cd backend
mvn test


### *Frontend (React)*
Run *unit tests for components*:
bash
cd frontend
npm test


---

## 📡 API Endpoints

| Method | Endpoint          | Description |
|--------|------------------|-------------|
| POST   | /tasks         | Create a new task |
| GET    | /tasks         | Get the latest 5 tasks |
| PUT    | /tasks/{id}/done | Mark a task as completed |

Example request to create a task:
json
{
  "title": "Learn Docker",
  "description": "Understand how to containerize applications"
}


---

## 📷 UI Preview
<img src="https://via.placeholder.com/600x300" alt="UI Preview" />

---

## 🙌 Contribution
1. *Fork* this repository.  
2. Create a *new branch*.  
3. *Commit* your changes.  
4. Open a *Pull Request*.  

---