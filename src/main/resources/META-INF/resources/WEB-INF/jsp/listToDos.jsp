<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>ToDos</title>
    </head>
    <body>
        <div class="container">
            <h1>Your ToDos:</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Description</th>
                        <th>TargetDate</th>
                        <th>Is Done?</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="todo" items="${toDos}">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
    </body>
</HTML>