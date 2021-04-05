/**
 * 
 */
$(".itme").on("click",function(){
	$(this).addClass("active").siblings().removeClass("active");
});