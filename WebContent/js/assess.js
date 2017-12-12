$(function(){
	
    avgStar();
	
	
	
	
	
	
	
	
	
	
	
	
	
});

function avgStar(){
	
	var avg = $('#avgScore').attr('src');
	avg=0;
	var xiaoshu=avg.toString().replace(/\d+\.(\d*)/,"$1")
	
	$('#star1').attr('class','fa fa-star');//全满
	
	$('#star1').attr('class','fa fa-star-half-full');//半满
	
	$('#star1').attr('class','fa fa-star-o');//空
	
	
	if(avg<1) {
		$('#star1').attr('class','fa fa-star-o');//空
		
		if(xiaoshu!=0) {
			
			$('#star1').attr('class','fa fa-star-half-full');//半满
		}
		
		
	} 
	
	if(avg>=1 && avg<2) {
		$('#star2').attr('class','fa fa-star-o');//空
		
		if(xiaoshu!=0) {
			
			$('#star2').attr('class','fa fa-star-half-full');//半满
		}
		
		
	} 
	if(avg>=2 && avg<3) {
		$('#star3').attr('class','fa fa-star-o');//空
		
		if(xiaoshu!=0) {
			
			$('#star3').attr('class','fa fa-star-half-full');//半满
		}
		
		
	} 
	if(avg>=3 && avg<4) {
		$('#star4').attr('class','fa fa-star-o');//空
		
		if(xiaoshu!=0) {
			
			$('#star4').attr('class','fa fa-star-half-full');//半满
		}
		
		
	} 
	if(avg>=4 && avg<5) {
		$('#star5').attr('class','fa fa-star-o');//空
		
		if(xiaoshu!=0) {
			
			$('#star5').attr('class','fa fa-star-half-full');//半满
		}
		
		
	} 
	
	
	
	
	
	
	
	
	
	
}