<html>
    <head>
        <title>Fine</title>
        <link rel="stylesheet" href="css/bodyTagCss.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/successChoice.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %><br><br>
        <div style=" margin: auto; background-color: whitesmoke; border-radius:16px; width: 400px; height: 150px">

            <div><br><h1>Operazione conclusa con successo</h1></div>
            <br> <h2>Scegli se tornare alla schermata principale o effettuare il logout.</h2></div>
            <button type="button" class="btn btn-secondary" id="Return">Click</button> Torna indietro <br><br>
            <form action="logout" method="post">        
                <button type="submit" class="btn btn-secondary" id="Logout">Click</button> Logout
            </form>
      
    </body>
</html>
