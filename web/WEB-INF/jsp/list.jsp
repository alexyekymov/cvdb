<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>List of resumes</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<br>
<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="com.github.alexyekymov.cvdb.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}">${resume.fullName}</a></td>
                <td>${resume.getContact(ContactType.MAIL)}</td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="fragments/footer.jsp"/>
</section>
</body>
</html>