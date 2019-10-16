function myFunction() {
$.ajax({
  url: "/bin/test?q=testing",
    type: "GET",
    datatype:'json',
  success: function(data) {
    console.log(data);
      document.getElementById("demo").innerHTML = "hello";
  }
});
}

  $(function() {
    $("#ok").click(function(e) {
        e.preventDefault();
        $.ajax({
    	type: "POST",
        url: "/bin/test5",
        data: $('form').serialize(),
  		success: function(resp) {
            alert("title:   " + resp.title + "desc   :" + resp.desc);
            $('#change').text(resp.title);
  }
});
    });
  });
