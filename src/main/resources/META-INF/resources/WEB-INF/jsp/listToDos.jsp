<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<HTML>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <div>Welcome ${name}!</div>
        <hr>
        <h1>Your ToDos: ${toDos}</h1>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>TargetDate</th>
                    <th>Is Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach>
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</HTML>