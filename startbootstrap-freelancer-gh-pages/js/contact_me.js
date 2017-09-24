$(function() {

  $("form#data").submit(function(){
    alert(1);
        var formData = new FormData(this);
    
        $.ajax({
            url:  "http://localhost:8092/image",
            type: 'POST',
            data: formData,
            async: false,
            success: function (data) {
                console.log(data)
               // console.log(JSON.parse(data))
                $('.res h2').contents().first().replaceWith('Result');
                $("#mainResult").html(
                "<div class=\"container\">"+
                "<div class=\"row\">"+
                "<br>"+
                "<p><h3 class=\"text-center\">Lung tumor: " + data.unhealthy + "%</h3></p>" +
                // "  <div class=\"col-lg-16 ml-auto\">"+
                // "    <p> - Two main types of tumors: malignant or cancerous tumors and benign tumors.</p>"+
                // "  </div>"+
                // "  <div class=\"col-lg-4 mr-auto\">"+
                // "    <p> - IoT device connected to smartphone</p>"+
                // "  </div>"+
                "</div>"+
                "</div>")
            },
            cache: false,
            contentType: false,
            processData: false
        });
    
        return false;
    });

});
