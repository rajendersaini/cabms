// this function is used to verify phone number.
jQuery.validator.addMethod("phone",
		function(value, element) {
			return this.optional(element)
					|| /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/.test(value);
		}, "Please specify the phone in format 999-999-9999");

function validateTab0(tab0) {
	tab0
			.validate({
				rules : {
					startdate : "required",
					starttime : "required",
					emailid : {
						required : true,
						email : true
					},
					phoneno : {
						required : true,
						phone : true
					}
				},
				messages : {
					startdate : "Please select booking start date",
					starttime : "Please select start time",
					emailid : {
						required : "We need your email address to contact you",
						email : "Your email address must be in the format of name@domain.com"
					},

					phoneno : {
						required : "We need your phone no to contact you",
						phone : "Your phone must be in the format 999-999-9999"
					}
				},
				errorElement : "em",
				success : function(label) {
					label.text("ok!").addClass("success");
				},
				highlight : function(element, errorClass) {
					var ele = 'em[for=' + element.name + ']';
					$(ele).attr('class', 'error');
				},
				focusCleanup : true
			});
	return tab0.valid();
}
function onValidateSucess(label) {
	label.text("ok!").addClass("success");
}
function onValidateHighlight(element, errorClass) {
	var ele = 'em[for=' + element.name + ']';
	$(ele).attr('class', 'error');

}
function validateTab1(tab1) {
	tab1.validate({
		rules : {
			street1 : "required",
			city : "required",
			state : "required",
			country : "required",
			zip : "required"
		},
		messages : {
			street1 : "Please enter travel start address",
			city : "Please enter tarvel start city",
			state : "Please enter travel start state",
			country : "Please enter travel start country",
			zip : "Please enter travel start zip"
		},
		errorElement : "em",
		success : function(label) {
			label.text("ok!").addClass("success");
		},
		highlight : function(element, errorClass) {
			var ele = 'em[for=' + element.name + ']';
			$(ele).attr('class', 'error');
		},
		focusCleanup : true
	});
	return tab1.valid();
}

(function($) {
	$("#bookingtabs").tabs({
		beforeActivate : function(event, ui) {
			var oid = ui.oldPanel.attr('id');
			alert("Old id is " + oid);
			alert(ui.newPanel.attr('id'));

		}
	});
})(jQuery);

$(function() {
	$("#startdate").datepicker({
		minDate : -0,
		maxDate : "+2M +10D",
		showOn : "both",
		buttonImage : "images/cal.jpg",
		buttonText : "Choose",
		constrainInput : true,
		dateFormat : "mm-dd-yy",
		buttonImageOnly : true
	}).datepicker("setDate", "0");

});
var d = new Date();
d.setHours(d.getHours() + 1)
$('#starttime').timepicker({
	showDuration : true,
	onSelect : function(timeStr) {
		// put start time based on date selected

	}
}).timepicker('setTime', d);
