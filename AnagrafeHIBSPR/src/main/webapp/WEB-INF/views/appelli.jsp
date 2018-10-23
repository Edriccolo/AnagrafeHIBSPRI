<%@page import="net.agmsolutions.university.entity.Appelli"%>
<%@page import="java.util.List"%>
<%@page import="net.agmsolutions.university.businesslogic.ReadAvailableExams"%>
<html>
    <head>
        <title>Ecco la lista</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/indexPage.css" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body style="background-color:lightgray; text-align:center">
        <%@ include file = "header.jsp" %><br><br>
        <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 150px">

            
            <h1>Ecco la lista degli appelli attualmente disponibili.</h1></div>  <br><br>
    <div class="container">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nome del professore</th>
                            <th>Nome esame</th>
                            <th>Data</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% ReadAvailableExams exams = new ReadAvailableExams();
                            List<Appelli> exam = exams.ExamList();
                            Appelli[] arrayExams = exam.toArray(new Appelli[exam.size()]);

                            for (int i = 0; i < exam.size(); i++) {

                                String profName = arrayExams[i].getCorsiIdcorsi().getProfessoriIdprofessori().getNome();
                                String examName = arrayExams[i].getCorsiIdcorsi().getNome();
                                String date = arrayExams[i].getData();

                                out.println("<tr>");
                                out.println("<td>" + profName + "</td>");
                                out.println("<td>" + examName + "</td>");
                                out.println("<td>" + date + "</td>");
                                out.println("</tr>");
                    }%> 

                    </tbody>
                </table>
          </div>
    </body>
</html>