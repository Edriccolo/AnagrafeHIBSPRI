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
        <input type="hidden" id="checkMethod" value="<%= session.getAttribute("SelectMethod")%>">

        <!-- 
                AREA SCEGLI APPELLO PER STUDENTI
        
        -->

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

        <!-- 
            AREA SCEGLI CORSO PER PROFESSORI

        -->
        <div id="corsi" style="display: none">
            <br><h1 style="text-align:center"> Ecco la lista dei corsi da te selezionabili</h1>
            <div class="container">
                <form action="ExamInserted" method="post"> <br><br><br>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Inserisci la data  </label>
                        <input type="date" id="DataEsame" name="DataEsame"/><br><br>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label for="exampleFormControlSelect1">Seleziona il nome </label>
                                <select class="form-control" id="NomeEsame" name="NomeEsame">
                                    <option selected>Scegli...</option>
                                    <% int idProf = (int) session.getAttribute("Id");

                                        AddExam classes = new AddExam();
                                        List<Corsi> corsiList = classes.CheckCourses(idProf);
                                        Corsi[] arrayCorsi = corsiList.toArray(new Corsi[corsiList.size()]);

                                        for (int i = 0; i < corsiList.size(); i++) {
                                            out.println("<option value=" + arrayCorsi[i].getIdcorsi() + ">" + arrayCorsi[i].getNome() + "</option>");
                                        }
                                    %>

                                </select>
                            </div>
                        </div>
                        <br> <div style="text-align: center"><button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button></div>
                    </div>
                </form>
            </div>
        </div>

                    <!-- 
            AREA SCEGLI APPELLO PER PROFESSORI

                    -->
        <div id="appelli" style="display: none">
            <br><h1> Ecco la lista degli appelli da te inseriti</h1>
            <div class="container">
                <form action="ExamDeleted" method="post"> <br><br><br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Esame</label>
                        </div>
                        <select class="custom-select" id="Esame" name="Esame">
                            <option selected>Scegli...</option>
                            <%  int prof = (int) session.getAttribute("Id");

                                DeleteExam exam = new DeleteExam();
                                List<Appelli> exams = exam.ExamChoice(prof);
                                Appelli[] arrayExams = exams.toArray(new Appelli[exams.size()]);

                                for (int i = 0; i < exams.size(); i++) {

                                    out.println("<option value=" + arrayExams[i].getIdappelli() + ">" + "Nome: " + arrayExams[i].getCorsiIdcorsi().getNome() + "    Data Appello: " + arrayExams[i].getData() + "</option>");
                                }%>
                        </select>
                    </div>

                    <br><button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button>
                </form>
            </div>
        </div>

                        <!-- 
                AREA SCEGLI PRENOTAZIONE PER PROFESSORI

                        -->

        <div id="prenotazioni" style="display: none">
            <br><h1> Ecco la lista delle prenotazioni dello studente</h1>
            <div class="container">
                <form action="mettiVoto" method="post"> <br><br><br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Prenotazioni</label>
                        </div>
                        <select class="custom-select" id="Prenotazione" name="Prenotazione">
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

                                    out.println("<option value=" + idReserv + ">" + "  Studente:" + studName + "    Professore:" + profName + "    Appello:" + examName + "</option>");
                                }
                            %>
                        </select>
                    </div>

                    <label>Inserisci il voto</label> <input type='text' name='Vote' />
                    <br> <div style="text-align: center"><button type="submit" class="btn btn-success btn-rounded z-depth-1">Invio</button></div>
                </form>
            </div>
        </div>

    </body>
</html>
