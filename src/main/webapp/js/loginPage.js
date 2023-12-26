document.getElementById("login").addEventListener("click", function(){
    var url = new XMLHttpRequest();
    url.onreadystatechange = function (){
        if(url.readyState === 4 && url.status === 200){
            window.location.href ="login.jsp";
        }
    }

    url.open("GET","loginPage", true);
    url.send();
})