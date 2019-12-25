$(document).ready(function() {
	$('#header').load('header.html');
	$('#left').load('left.html');
	$('#right').load('right.html');
});

function menuClick(menuUrl) {
	$('#right').load(menuUrl, function() {
		var sc = document.createElement("script");
		sc.src = "/static/js/table.js";
		$("body").append(sc);
	});
}
