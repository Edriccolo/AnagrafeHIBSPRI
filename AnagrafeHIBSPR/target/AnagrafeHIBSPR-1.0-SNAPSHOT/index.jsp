<!DOCTYPE html>
<html>
    <head>
        <!--IMPORT-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/bodyTagCss.css" media="screen"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


        <meta charset="UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%@ include file = "WEB-INF/views/header.jsp" %>
        <!-- Modal -->
        <div class="modal fade" id="darkModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog form-dark" role="document">
                <!--Content-->
                <div class="modal-content card card-image" style="background-color:darkslategray;">
                    <div class="text-white rgba-stylish-strong py-5 px-5 z-depth-4">
                        <!--Header-->
                        <div class="modal-header text-center pb-4">
                            <h3 class="modal-title w-100 white-text font-weight-bold" id="myModalLabel"><strong>LOGIN</strong></h3>
                            <button type="button" class="close white-text" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="login" method="post">
                                <input type="radio" name="switch" value="studente" checked="checked"> Studente
                                <input type="radio" name="switch" value="professore"> Professore

                           
                            <!--Body--> <br><br>
                         

                                <!--Body-->
                                <div class="md-form pb-3">

                                    <input type="text" class="form-control validate white-text" name="user">
                                    <label style="color:white">Nome Utente</label>
                                </div>

                                <div class="md-form pb-3">

                                    <input type="password" class="form-control validate white-text" name="pwd">
                                    <label style="color:white">Password</label>
                                </div>


                                <!--Grid row-->
                                <div class="row d-flex align-items-center mb-4">

                                    <!--Grid column-->
                                    <div class="text-center mb-3 col-md-12">
                                        <br><br>
                                        <button type="submit" class="btn btn-success btn-block btn-rounded z-depth-1">Login</button>

                                    </div>
                                    <!--Grid column-->

                                </div>

                            </form>
                        </div>

      
                    </div>

                </div>
            </div>
        </div>
        <!-- Modal -->


        <div class="text-center"><br><br> 
            <input type="button" class="btn btn-info" value="Cliccami per il login" data-toggle="modal" data-target="#darkModalForm">
        </div>

    </body>
</html>