// this function handles tabs on booking page
jQuery.validator.addMethod("phone",
		function(value, element) {
			return this.optional(element)
					|| /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/.test(value);
		}, "Please specify the phone in format 999-999-9999");

$("#tabs")
		.tabs(
				{
					select : function(event, tab) {
						if (tab.index != 0) {
							// validate first tab
							var tab0 = $("#bookingtab0");
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
											label.text("ok!").addClass(
													"success");
										},
										highlight : function(element,
												errorClass) {
											var ele = 'em[for=' + element.name
													+ ']';
											$(ele).attr('class', 'error');
										},
										focusCleanup : true
									});
							return tab0.valid();
						}
						return true;
					}
				});

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
