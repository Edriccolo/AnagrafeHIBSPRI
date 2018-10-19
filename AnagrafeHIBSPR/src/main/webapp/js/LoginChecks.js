$(document).ready(function(){
    
    var check=$("#checkLogin").val();
    if(check==="0")
         $("#notLogged").show();
    else
       $("#logged").show();
    
     var check2=$("#checkRole").val();
    if(check2==="studente")
         $("#StudLogged").show();
    else
       $("#ProfLogged").show();
    
    
    $("#ApproveExamButton").click(function(){
       $("#choiceProf").hide();
       $("#ApproveExam").show();
   });
});