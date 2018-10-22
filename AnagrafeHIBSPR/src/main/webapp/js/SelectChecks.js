$(document).ready(function () {

    var check = $("#checkMethod").val();
    if (check === "StudAppelli")
        $("#student").show();
    else
        $("#logged").show();//da cambiare
});