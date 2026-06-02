````md
# 📧 Email Automation Service

A Spring Boot project that allows users to send **HTML emails with file attachments** using **Gmail SMTP**. This project also includes **scheduled email functionality** and **asynchronous email processing**.

---

# Features

- Send HTML emails dynamically
- Upload file attachments
- Gmail SMTP integration
- Async email sending using `@Async`
- Scheduled email using `@Scheduled`
- Request validation using Jakarta Validation
- Multipart form-data support

---

# 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Mail
- Spring Web
- Jakarta Validation
- Spring Scheduler
- Maven
- Gmail SMTP
- Postman

---

# Project Structure

```text
src/main/java
│
├── com.work.EmailFile
│   ├── controller
│   │   └── MailWorkController.java
│   │
│   ├── dto
│   │   └── RequestWork.java
│   │
│   ├── scheduler
│   │   └── EmailScheduler.java
│   │
│   ├── service
│   │   └── EmailService.java
│   │
│   └── EmailFileApplication.java
```

Each layer has a different responsibility:

- **Controller** → Handles API requests
- **DTO** → Stores request data
- **Service** → Contains business logic for sending emails
- **Scheduler** → Sends automated emails at a fixed time

---

# API Endpoint

## Send Email API

### URL

```http
http://localhost:8080/send
```

### Method

```http
POST
```

### Content-Type

```http
multipart/form-data
```

---

# Postman Testing

Go to:

```text
Body → form-data
```

Add:

| Key | Type | Example |
|------|------|----------|
| toEmail | Text | user@gmail.com |
| subject | Text | Project Update |
| body | Text | `<h1>Hello</h1>` |
| file | File | image.png |

Example Request:

```text
toEmail = user@gmail.com
subject = Project Update
body = <h1>Hello User</h1>
file = image.png
```

Click:

```text
Send
```

Success Response:

```json
{
  "message": "Email is being processed and sent!"
}
```

---

# application.properties

File Path:

```text
src/main/resources/application.properties
```

Configuration:

```properties
spring.application.name=EmailFile

spring.mail.host=smtp.gmail.com
spring.mail.port=587

spring.mail.username=${FROM_EMAIL}
spring.mail.password=${APP_PASSWORD}

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Explanation

| Property | Purpose |
|----------|---------|
| smtp.gmail.com | Gmail SMTP server |
| 587 | TLS port |
| FROM_EMAIL | Sender Gmail |
| APP_PASSWORD | Gmail App Password |

---

# Environment Variables

Set:

```env
FROM_EMAIL=yourgmail@gmail.com
APP_PASSWORD=your_app_password
```

---

# Gmail App Password Setup

1. Open Google Account  
2. Enable 2-Step Verification  
3. Open App Passwords  
4. Generate password for Mail  
5. Copy generated password  
6. Add it into:

```env
APP_PASSWORD
```

---

# 🔄 Project Flow

```text
Postman Request
      ↓
Controller Layer
      ↓
DTO Validation
      ↓
Service Layer
      ↓
Create MimeMessage
      ↓
Attach HTML + File
      ↓
Gmail SMTP
      ↓
Email Delivered
```

---

# ▶️ Run Project

Clone repository:

```bash
git clone https://github.com/your-username/EmailFile.git
```

Install dependencies:

```bash
mvn clean install
```

Run application:

```bash
mvn spring-boot:run
```

Or run:

```text
EmailFileApplication.java
```

---

# 👩‍💻 Author

**Prachi Prajapati**
````
