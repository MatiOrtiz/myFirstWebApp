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
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="toDo" items="${toDos}">
                        <tr>
                            <td>${toDo.id}</td>
                            <td>${toDo.description}</td>
                            <td>${toDo.targetDate}</td>
                            <td>${toDo.done}</td>
                            <td><a href="delete-todo?id=${toDo.id}" class="btn btn-warning">Delete</a> </td>
                            <td><a href="update-todo?id=${toDo.id}" class="btn btn-success">Update</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add ToDo</a>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
    </body>
</HTML>