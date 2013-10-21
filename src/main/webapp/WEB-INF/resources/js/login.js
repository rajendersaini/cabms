$(document)
		.ready(
				function() {
					$("#loginForm")
							.validate(
									{
										rules : {
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

										},
										messages : {
											email : {
												required : jQuery.i18n
														.prop("login.email.required"),
												email : jQuery.i18n
														.prop("login.email.valid")
											},

											password : {
												minlength : jQuery.i18n
														.prop("login.password.minlength")
											}
										},
										errorElement : "field_error",

										success : function(label) {
											label.addClass("success").text(
													"Ok!");
										},
										error: function (label) {
											label.addClass("error");
										},
										highlight : function(element, errorClass) {
											var ele = 'field_error[for=' + element.id + ']';
											$(ele).attr('class', 'error');
										},
										focusCleanup : true
										
									});

				});

/*
 * $().ready(function() {
 * 
 * $("#loginForm").validate({
 * 
 * rules : { email : { required : true, email : true }, password : { minlength :
 * 5 }, password_confirm : { minlength : 5, equalTo : "#password" } }, messages : {
 * 
 * email : { required : jQuery.i18n.prop("login.email.required"), email :
 * jQuery.i18n.prop("login.email.valid") }, password : { minlength :
 * jQuery.i18n.prop("login.password.minlength") } },
 * 
 * submitHandler : function(form) { form.submit(); },
 * 
 * errorClass : "field_error", errorPlacement : function(error, element) {
 * error.insertAfter(element); }, highlight : function(element, errorClass,
 * validClass) { element.addClass(errorClass).removeClass(validClass); },
 * unhighlight : function(element, errorClass, validClass) {
 * element.removeClass(errorClass).addClass(validClass); }
 * 
 * });
 * 
 * });
 */