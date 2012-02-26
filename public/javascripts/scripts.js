var flag =1;

$(document).ready( function() {
//	$("#main").html("injected test");
	$(".arrow").addClass("no-horizon-margin");
	$("#leftarrow").click(function(){
		if(flag>=3)return;
		$("#slide"+flag).fadeOut(100, function(){
			flag++;
			$("#slide"+flag).fadeIn(300);
		});
	})
	
	$("#rightarrow").click(function(){
		if(flag<=1)return;
		$("#slide"+flag).fadeOut(100, function(){
			flag--;
			$("#slide"+flag).fadeIn(300);
		});
	})
	
});