<%@page import="net.agmsolutions.university.businesslogic.ApproveReservation"%>
<%@page import="net.agmsolutions.university.entity.Prenotazioni"%>
<%@page import="net.agmsolutions.university.businesslogic.DeleteExam"%>
<%@page import="net.agmsolutions.university.entity.Corsi"%>
<%@page import="net.agmsolutions.university.businesslogic.AddExam"%>
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
        <%@ include file = "header.jsp" %><br><br>
        <input type="hidden" id="checkMethod" value="<%= session.getAttribute("SelectMethod")%>">

        <!-- 
                AREA SCEGLI APPELLO PER STUDENTI
        
        -->

        <div id="student" style="display: none">
                    <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 150px">
            <br><h1> Ecco la lista degli appelli disponibili</h1></div>
            <div class="container">
                <form action="setReservation" method="post"><br><br><br>
                    <div class="form-group">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Clicca per selezionare</th>
                                    <th>Nome del professore</th>
                                    <th>Nome esame</th>
                                    <th>Data</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% ReadAvailableExams choices = new ReadAvailableExams();
                                    List<Appelli> reservations = choices.ExamList();
                                    Appelli[] arrayReservations = reservations.toArray(new Appelli[reservations.size()]);

                                    for (int i = 0; i < reservations.size(); i++) {
                                        out.println("<tr>");
                                        out.println("<td> <input type='radio' name='idStudExam' value=" + arrayReservations[i].getIdappelli() + "> </td>");
                                        out.println("<td>" + arrayReservations[i].getCorsiIdcorsi().getProfessoriIdprofessori().getNome() + "</td>");
                                        out.println("<td>" + arrayReservations[i].getCorsiIdcorsi().getNome() + "</td>");
                                        out.println("<td>" + arrayReservations[i].getData() + "</td>");
                                        out.println("</tr>");
                                    }%>
                            </tbody>
                        </table>


                        <button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button>
                </form>
            </div>
        </div>
</div>
        <!-- 
            AREA SCEGLI CORSO PER PROFESSORI

        -->
        <div id="corsi" style="display: none">
                    <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 150px">

            <br><h1 style="text-align:center"> Ecco la lista dei corsi da te selezionabili</h1></div>
            <div class="container">
                <form action="ExamInserted" method="post"> <br><br><br>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Inserisci la data  </label>
                        <input type="date" id="DataEsame" name="DataEsame"/><br><br>                        
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Clicca per selezionare</th>
                                            <th>Nome corso</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% int idProf = (int) session.getAttribute("Id");

                                            AddExam classes = new AddExam();
                                            List<Corsi> corsiList = classes.CheckCourses(idProf);
                                            Corsi[] arrayCorsi = corsiList.toArray(new Corsi[corsiList.size()]);

                                            for (int i = 0; i < corsiList.size(); i++) {
                                                out.println("<tr>");
                                                out.println("<td> <input type='radio' name='idCorsi' value=" + arrayCorsi[i].getIdcorsi() + "> </td>");
                                                out.println("<td>" + arrayCorsi[i].getNome() + "</td>");
                                                out.println("</tr>");
                                            }
                                        %>
                                    </tbody>
                                </table>

                            
                        <br> <div style="text-align: center"><button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button></div>
                    </div>
                </form>
            </div>
        </div>

        <!-- 
AREA SCEGLI APPELLO PER PROFESSORI

        -->
        <div id="appelli" style="display: none">
                    <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 150px">
            <br><h1> Ecco la lista degli appelli da te inseriti</h1></div>
            <div class="container">
                <form action="ExamDeleted" method="post"> <br><br><br>
                  <div class="form-group">
                        
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Clicca per selezionare</th>
                                    <th>Nome esame</th>
                                    <th>Data</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%  int prof = (int) session.getAttribute("Id");

                                    DeleteExam exam = new DeleteExam();
                                    List<Appelli> exams = exam.ExamChoice(prof);
                                    Appelli[] arrayExams = exams.toArray(new Appelli[exams.size()]);

                                    for (int i = 0; i < exams.size(); i++) {
                                        out.println("<tr>");
                                        out.println("<td> <input type='radio' name='idAppelli' value=" + arrayExams[i].getIdappelli() + "> </td>");
                                        out.println("<td>" + arrayExams[i].getCorsiIdcorsi().getNome() + "</td>");
                                        out.println("<td>" + arrayExams[i].getData() + "</td>");
                                        out.println("</tr>");
                                    }%>
                            </tbody>
                        </table>

                            <div style="text-align: center"><br><button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button></div>
                </form>
            </div>
        </div>
</div>
        <!-- 
AREA SCEGLI PRENOTAZIONE PER PROFESSORI

        -->

        <div id="prenotazioni" style="display: none">
                    <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 190px">
            <br><h1> Ecco la lista delle prenotazioni dello studente</h1></div>
            <div class="container">
                <form action="mettiVoto" method="post"> <br><br><br>
                          <div class="form-group">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Clicca per selezionare</th>
                                    <th>Nome del professore</th>
                                    <th>Nome esame</th>
                                    <th>Data</th>
                                    <th>Nome dello studente</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    String NomeStud = request.getParameter("NomeStud");
                                    ApproveReservation approve = new ApproveReservation();
                                    List<Prenotazioni> reservation = approve.GetReservByStud(NomeStud);

                                    Prenotazioni[] arrayReservation = reservation.toArray(new Prenotazioni[reservation.size()]);

                                    for (int i = 0; i < reservation.size(); i++) {
                                        Integer idReserv = arrayReservation[i].getIdprenotazioni();
                                        String profName = arrayReservation[i].getAppelliIdappelli().getCorsiIdcorsi().getProfessoriIdprofessori().getNome();
                                        String examName = arrayReservation[i].getAppelliIdappelli().getCorsiIdcorsi().getNome();
                                        String studName = arrayReservation[i].getStudentiIdstudenti().getNome();
                                        String date = arrayReservation[i].getAppelliIdappelli().getData();

                                        out.println("<tr>");
                                        out.println("<td> <input type='radio' name='idReserv' value=" + idReserv + "> </td>");
                                        out.println("<td>" + profName + "</td>");
                                        out.println("<td>" + examName + "</td>");
                                        out.println("<td>" + date + "</td>");
                                        out.println("<td>" + studName + "</td>");

                                        out.println("</tr>");
                                    }
                                %>
                            </tbody>
                        </table>


                            <br><br><label for="exampleFormControlSelect1">Inserisci il voto</label> <input type='text' name='Vote' />
                        <br> <div style="text-align: center"><button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button></div>
                </form>
            </div>
        </div>
</div></div>
    </body>
</html>
