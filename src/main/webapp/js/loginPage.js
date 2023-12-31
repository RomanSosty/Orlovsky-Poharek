var form = document.getElementById("loginForm");

form.addEventListener("submit", function (event) {
    event.preventDefault();
    validateLoginForm();
});

function validateLoginForm(){
    const login = document.getElementById("login").value;
    const password = document.getElementById("password").value;

    const user = {
        login: login,
        password: password
    };

    fetch('/JAT_war_exploded/loginPage', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        })
            .then(response => response.json())
            .then(data => console.log(data))
            .catch(error => localStorage.setItem("Error:", error));
}