<%
	response.setContentType("application/json");
%>
"marcas":[
	{"nombre":"Ford",
		"modelos":[
		{"nombre":"Mondeo"},
		{"nombre":"Focus"},
		{"nombre":"Fiesta"} 
		]},
	{"nombre":"Chevrolet",
		"modelos": [
		{"nombre":"Camaro"},
		{"nombre":"Cruze"},
		{"nombre":"Sonic"}
	]},
	{"nombre":"Volkswagen",
		"modelos": [
		{"nombre":"Passat"},
		{"nombre":"Scirocco"}, 
		{"nombre":"Gol"}
	]}
]