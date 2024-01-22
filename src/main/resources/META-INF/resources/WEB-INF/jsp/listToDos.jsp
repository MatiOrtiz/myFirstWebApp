<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <h1>Your ToDos:</h1>
    <table class="table">
        <thead>
            <tr>
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
<%@ include file="common/footer.jspf" %>