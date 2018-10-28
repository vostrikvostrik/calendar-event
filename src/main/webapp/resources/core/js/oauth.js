function setAuthInfo(tokenId) {
    console.log('inside');
    $.ajax({
        type: 'POST',//тип запроса
        data: {tokenId: tokenId},//параметры запроса
        url: "google_auth",//url адрес обработчика
        success: function(result) {
            //alert(result);
            setUserName(result);
            location.reload();
        }, //возвращаемый результат от сервера
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }
    });

};
$(document).ready(onDocumentReady());

function onDocumentReady() {
    $(document).ready(function () {
        console.log("ready!");
    });
};

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    setProfileImage(profile.getImageUrl());
    setUserName(profile.getName());
    setAuthInfo(googleUser.getAuthResponse().id_token);
    if (profile.getId() != "")
        signInOutBlockChange("IN");
};

function setProfileImage(srcUrl) {
    var element = document.getElementById("profileImage");
    if (srcUrl == null) {
        element.style.display = "none";
        element.src = "";
        element.style.visibility = "hidden";
    } else {
        element.style.display = "block";
        element.src = srcUrl;
    }
};

function setUserName(userName) {
    var element = document.getElementById("user-name");
    if (userName == null) {
        element.style.display = "none";
        element.innerHTML = "";
    } else {
        element.style.display = "block";
        element.innerHTML = userName;
    }
};

function signInOutBlockChange(displayState) {
    if (displayState == 'IN') {
        signOutBlockChange('block');
        signInBlockChange('none');
    }
    else {
        signOutBlockChange('none');
        signInBlockChange('block');
    }
};

function signInBlockChange(displayState) {
    var x = document.getElementById("signInBut");
    if (displayState == "none") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
};

function signOutBlockChange(displayState) {
    var x = document.getElementById("signOutBut");
    if (displayState == "none") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
};

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
        signInBlockChange("none");
    });
    location.reload();
}
