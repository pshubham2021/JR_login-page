# React + Spring Boot Auth App

This project is a full-stack web application with a React frontend and a Java Spring Boot backend. It supports user login and signup with authentication, using a JSON file for temporary user data storage (no database required).

## Prerequisites
- Node.js (v18+ recommended)
- npm (comes with Node.js)
- Java 17 or newer

## Getting Started

### 1. Clone or Download the Project

```
git clone <this-repo-url>
cd Application-app
```

### 2. Start the Backend (Spring Boot)

Open a terminal and run:

```
cd backend/backend
./mvnw spring-boot:run -DskipTests
```

- The backend will start on [http://localhost:8080](http://localhost:8080)
- User data is stored in `backend/backend/users.json`

### 3. Start the Frontend (React)

Open a new terminal and run:

```
cd frontend
npm install
npm start
```

- The frontend will start on [http://localhost:3000](http://localhost:3000)
- It will automatically proxy API requests to the backend

### 4. Usage
- Open [http://localhost:3000](http://localhost:3000) in your browser
- Sign up for a new account or log in with an existing one
- After login, you'll see a welcome landing page

## Notes
- No real database is used; all user data is stored in a local JSON file for demo purposes.
- For production, use a real database and secure authentication.
- If you change ports or run on a different host, update the `proxy` field in `frontend/package.json` and CORS settings in the backend.

## Troubleshooting
- If you see CORS or network errors, make sure both servers are running and accessible.
- If you change the backend port, update the proxy in `frontend/package.json`.

---

Enjoy building with React and Spring Boot!
