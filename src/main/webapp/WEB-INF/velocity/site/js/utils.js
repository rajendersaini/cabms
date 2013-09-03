if (!window.console) 
{
			window.console = {
				log : function() {
				}
			};
}

cabms // top level namespace
{
	utils : {

		// ulitity function to execute function by name
		executeFunctionByName : function(functionName, context /* , args */) {
			var args = Array.prototype.slice.call(arguments, 2);
			var namespaces = functionName.split(".");
			var func = namespaces.pop();
			for ( var i = 0; i < namespaces.length; i++) {
				context = context[namespaces[i]];
			}
			return context[func].apply(context, args);
		}	

	}
}