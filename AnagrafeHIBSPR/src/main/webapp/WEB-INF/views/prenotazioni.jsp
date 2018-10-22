<%-- 
    Document   : prenotazioni
    Created on : 22-ott-2018, 13.34.52
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="net.agmsolutions.university.entity.Prenotazioni"%>
<%@page import="net.agmsolutions.university.businesslogic.ReadReservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecco la lista</title>
        <link rel="stylesheet" href="css/bodyTagCss.css" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
   <body style="background-color:lightgray; text-align:center">
       <div class="container">
                <h1>Ecco la lista delle prenotazioni attualmente online.</h1><br><br>
                <table class="table table-striped">
                <thead>
                <tr>
                <th>Nome del professore</th>
                <th>Nome esame</th>
                <th>Data</th>
                <th>Nome dello studente</th>
                </tr>
                </thead>
                 <tbody>
                        <%
                        ReadReservation reservations = new ReadReservation();
                            List<Prenotazioni> reservation = reservations.ReservList();
                            Prenotazioni[] arrayReservation = reservation.toArray(new Prenotazioni[reservation.size()]);

                            for (int i = 0; i < reservation.size(); i++) {

                                String profName = arrayReservation[i].getAppelliIdappelli().getCorsiIdcorsi().getProfessoriIdprofessori().getNome();
                                String examName = arrayReservation[i].getAppelliIdappelli().getCorsiIdcorsi().getNome();
                                String date = arrayReservation[i].getAppelliIdappelli().getData();
                                String studName = arrayReservation[i].getStudentiIdstudenti().getNome();

                                out.println("<tr>");
                                out.println("<td>" + profName + "</td>");
                                out.println("<td>" + examName + "</td>");
                                out.println("<td>" + date + "</td>");
                                out.println("<td>" + studName + "</td>");

                                out.println("</tr>");
                            }
    
                        %>
                    </tbody>
                </table>
       </div>
    </body>
</html>
