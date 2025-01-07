<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <h1>Username or Password is Wrong</h1>
    <div th:if="${errorMessage}" th:text="${errorMessage}" class="error-message"></div>
    <!-- Additional error handling or styling can be added here -->
</body>
</html>