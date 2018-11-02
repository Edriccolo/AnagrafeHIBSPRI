<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fine</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/bodyTagCss.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/successChoice.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %><br><br>
        <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 600px; height: 380px">

            <div><br><h1>Operazione conclusa con successo</h1></div>
            <br> <h2>Scegli se tornare alla schermata principale o effettuare il logout.</h2><br>
            <div style="text-align: left"><button type="button" class="btn btn-secondary" id="Return">Click</button> Torna indietro <br><br>
            <form action="logout" method="post">        
                <button type="submit" class="btn btn-secondary" id="Logout">Click</button> Logout
            </form></div></div>

    </body>
</html>
