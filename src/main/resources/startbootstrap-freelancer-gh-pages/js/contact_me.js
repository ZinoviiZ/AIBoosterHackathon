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
                alert(data)
            },
            cache: false,
            contentType: false,
            processData: false
        });
    
        return false;
    });

});
