$(document).ready(function () {

    var check = $("#checkMethod").val();
    if (check === "StudAppelli")
        $("#student").show();
    else if
        (check === "ProfCorsi")
        $("#corsi").show();
    else if
        (check === "ProfAppelli")
        $("#appelli").show();
    else
        (check === "ProfPrenot")
        $("#prenotazioni").show();
});