'use strict';
window.addEventListener('load', function () {

    const registrationForm = document.getElementById('registration-form');
    registrationForm.addEventListener('submit', onRegisterHandler);

    function onRegisterHandler(e) {
        e.preventDefault();
        const form = e.target;
        const data = new FormData(form);
        const userJSON = JSON.stringify(Object.fromEntries(data));
        createUser(data);
    }

    const baseUrl = 'http://localhost:8080';

    async function createUser(userJSON) {
        const settings = {
            method: 'POST',
            body: userJSON
        };

        const response = await fetch(baseUrl + '/registration', settings);
        const responseData = await response.json();

        console.log(responseData);

        window.location.href = baseUrl + "/login";
    }

});
