/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 12/17/16
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */

$(function() {
    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});
