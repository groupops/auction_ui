$(document).ready(function () {
    $('#register').validate(
        {
            rules: {
                login: {
                    minlength: 4,
                    required: true
                },
                password: {
                    required: true
                },
                confirmPassword: {
                    minlength: 4,
                    required: true,
                    equalTo: "#password"
                }
            },
            messages: {
                login: "Please enter your login",
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 5 characters long"
                },
                confirmPassword: {
                    equalTo: "Not match"
                }
            },
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('success').addClass('error');
            },
            success: function (element) {
                element.removeClass('error').addClass('success');
                $(element).closest('.form-group').removeClass('error').addClass('success');
            }
        });
});