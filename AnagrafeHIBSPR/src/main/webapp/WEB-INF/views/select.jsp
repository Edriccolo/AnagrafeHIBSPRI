<%@page import="net.agmsolutions.university.entity.Appelli"%>
<%@page import="java.util.List"%>
<%@page import="net.agmsolutions.university.businesslogic.ReadAvailableExams"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scegli</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/SelectChecks.js"></script>
    
    </head>
    <body  style="background-color:lightgray; text-align:center">
        <input type="hidden" id="checkMethod" value="<%= session.getAttribute("SelectMethod")%>">
        <div id="student" style="display: none">
            <br><h1> Ecco la lista degli appelli disponibili</h1>"
            <div class="container">
                <form action="setReservation" method="post"><br><br><br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Esame</label>
                        </div>
                        <select class="custom-select" id="Esame" name="Esame">
                            <option selected>Scegli...</option>
                            <% ReadAvailableExams choices = new ReadAvailableExams();
                                List<Appelli> reservations = choices.ExamList();
                                Appelli[] arrayReservations = reservations.toArray(new Appelli[reservations.size()]);

                                for (int i = 0; i < reservations.size(); i++) {

                                    out.println("<option value=" + arrayReservations[i].getIdappelli() + ">" + arrayReservations[i].getCorsiIdcorsi().getNome() + "   Professore: " + arrayReservations[i].getCorsiIdcorsi().getProfessoriIdprofessori().getNome() + "    Data Appello: " + arrayReservations[i].getData() + "</option>");
                            }%>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button>
                </form>
            </div>
        </div>
    </body>
</html>
