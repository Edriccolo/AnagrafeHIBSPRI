$(document).ready(function(){
   $("#Return").click(function(){
       window.history.go(-2);
   });
    $("#Logout").click(function(){
       window.location = "killSessionServlet";
   });
});