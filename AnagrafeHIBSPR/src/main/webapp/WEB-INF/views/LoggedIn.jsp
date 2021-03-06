<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/bodyTagCss.css" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/LoginChecks.js"></script>
        <title>Login</title>
    </head>
    <body>
        <%@ include file = "header.jsp" %><br><br>
        <input type="hidden" id="checkLogin" value="<%= session.getAttribute("Id")%>">
         <input type="hidden" id="checkRole" value="<%= session.getAttribute("Role")%>">
        <div id="logged" style="display:none">

           <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 150px"> <br><h1>Ciao <%=session.getAttribute("Name")%> </h1>

               <h2>Cosa vuoi fare?</h2><br><br> </div><br><br>
                    
            
                <div class="container">
                    <div id="ProfLogged" style="display:none">
                    <div id="choiceProf">
                        <div class="col-md-12" style="text-align: left">
                            <form action="scegliCorso" method="post">
                                <div style=" background-color: whitesmoke; border-radius:16px; width: 300px; height: 280px"><br><button type="submit" class="btn btn-secondary" id="AddExamButton">Click</button> Aggiungere un appello <br><br></form>
                            <form action="eliminaScelta" method="post">
                                <button type="submit" class="btn btn-secondary">Click</button> Eliminare un appello <br><br></form>
                            <form action="prenotazioni" method="post">
                                <button type="submit" class="btn btn-secondary">Click</button> Lista delle prenotazioni <br><br></form>

                            <button type="button" class="btn btn-secondary" id="ApproveExamButton">Click</button> Segnare un esame passato
                        </div> </div></div>

                    <div id="ApproveExam" style="display:none">
                        <form action="cercaStudente" method="post">
                            <label>Inserisci il nome dello studente, con la lettera iniziale maiuscola:</label>
                            <input type="text" id="NomeStud" name="NomeStud"/>
                            <button type="submit" class="btn btn-primary">Invio</button>

                        </form>
                    </div>

                </div>

            <div id="StudLogged" style="display:none">
                <div style="text-align:left">
                    <form action="appelli" method="post">
                        <div style=" background-color: whitesmoke; border-radius:16px; width: 300px; height: 150px"><br>  <button type="submit" class="btn btn-secondary">Click</button> Leggere gli appelli disponibili <br><br></form>
                    <form action="scegliAppello" method="post">
                        <button type="submit" class="btn btn-secondary">Click</button> Fai una prenotazione </div><br><br></form>
                </div>    
            </div>
        </div>
            </div>

        <div id="notLogged" style="display: none">
            <h1>L'utente non esiste.</h1>
        </div>
    </body>
</html>
