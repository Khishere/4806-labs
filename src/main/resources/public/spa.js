$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/addressBook?id=1"
    }).then(function (data) {
        if (data) {
            $('.addressbook-id').append("Address Book ID: " + data.id);
            for (i = 0; i < data.buddies.length; i++) {
                $('.addressbook-contents').append("Name: " + data.buddies[i].name + ", ").append("Phone Number: " + data.buddies[i].phoneNumber).append("<br>");
            }
        }
    });
});