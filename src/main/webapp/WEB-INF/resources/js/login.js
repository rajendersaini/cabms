$(document).ready(function() {

	$("#loginForm").validate({
		
		rules :{
			email : {
				required : true,
				email : true
				},
			password : {
				minlength : 5					
				},
			password_confirm : {
                 minlength : 5,
                    equalTo : "#password"
                }				
			}
			
		},
		messages :{
			
			email:{
				required : jQuery.i18n.prop("login.email.required"),
				email : jQuery.i18n.prop("login.email.valid")
			},
			password : {
				minlength :jQuery.i18n.prop("login.password.minlength")
			}
			
		}

	});

});