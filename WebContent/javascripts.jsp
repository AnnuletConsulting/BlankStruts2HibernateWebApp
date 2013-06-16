<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Calendar"%>
<%	StringBuffer date = new StringBuffer();
	Calendar now = Calendar.getInstance();
	date.append(now.get(Calendar.YEAR));
	date.append(now.get(Calendar.MONTH));
	date.append(now.get(Calendar.DATE));
	date.append(now.get(Calendar.HOUR));
	date.append(now.get(Calendar.MINUTE));
	date.append(now.get(Calendar.SECOND));
	String today = date.toString(); %>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="dwr/engine.js" ></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="struts/validationClient.js"></script>
<script type="text/javascript" src="struts/ajax/validation.js"></script>
<script type="text/javascript" src="struts/xhtml/validation.js"></script>
<script type="text/javascript" src="dwr/interface/Ajax.js?v=<%=today%>"></script>
<script type="text/javascript" src="dwr/interface/validator.js"></script>
<script type="text/javascript">
var today = "<%=today%>";
function checkUsers() {
	Ajax.getUserCount(function (data) {
		alert("There are "+data+" user accounts on this system.");
	});
}
function loadUsers() {
 	Ajax.getUsernames(function (data) {
		var selBox = document.getElementById("userSelect");
		selBox.options.length = 0;
		var empty = new Option();
		empty.value = "0";
		empty.text = "--- Choose a User below ---";
		selBox.appendChild(empty);
		for (var i=0; i<data.length; i++) {
			var newChild = new Option();
			newChild.value = data[i][1];
			newChild.text = data[i][2];
			selBox.appendChild(newChild);
		}
	});
}
</script>