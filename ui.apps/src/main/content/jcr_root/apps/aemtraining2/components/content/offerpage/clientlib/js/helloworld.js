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