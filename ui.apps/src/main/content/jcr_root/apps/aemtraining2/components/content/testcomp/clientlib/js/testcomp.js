  $(function() {
    $("#submit").click(function(e) {
        e.preventDefault();
        console.log("Hey");
        $.ajax({
    	type: "POST",
        url: "/bin/test4",
        data: $('form').serialize(),
  		success: function(resp) {
            alert("username:   " + resp.username + "password   :" + resp.password);
  }
});
    });
  });
