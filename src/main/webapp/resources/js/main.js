
var elementId;
var elementText;
var elementOrderNo;

function activateElement(id, text, orderNo){
    elementId = id;
    elementText = text;
    elementOrderNo = orderNo;
};

$(document).ready(function(){
        var text;
        $(".table-element-text").click(function(){
        text = $(this).html();

        $(".input-text" ).val( function() {
            return text;
        });

        $(".config-buttons button").removeClass('button-disable');

    });

    $("#add-button").click(function(){
       var toSave = $(".input-text").val();
        if (toSave != '')
            doCall("POST", "/save",toSave);
        else
            alert('Введите значение для сохранения');

        clearInput();
    });

    $("#save-button").click(function(){

        var toSave = {
            text: $(".input-text").val(),
            id: elementId
        };

        if (toSave != '')
            doCall("POST", "/update",toSave);

        $(".config-buttons button").addClass('button-disable');

        clearInput();
    });

    $("#remove-button").click(function(){

        doCall("POST", "/delete/"+elementId,null);

        $(".config-buttons button").addClass('button-disable');

        clearInput();

    });

    $("#up-button").click(function(){

        doCall("POST", "/move-up/"+elementId,null);

        $(".config-buttons button").addClass('button-disable');

        clearInput();
    });

    $("#down-button").click(function(){

        doCall("POST", "/move-down/"+elementId,null);

        $(".config-buttons button").addClass('button-disable');

        clearInput();
    });

    function doCall(method,url,data) {

        $.ajax({
            method: method,
            url: url,
            data: data
        });
    }

    function clearInput() {
        $('#input-field').val("");
    }
});
