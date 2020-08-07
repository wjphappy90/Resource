$(function() {
				
                
                $('.single-slider.one').jRange({
					from: 6,
					to: 30,
					step: 1,
					scale: [6, 12, 18, 24, 30],
					format: '%s',
					width: 300,
					showLabels: true,
					showScale: true

				});
				
				 $('.single-slider.two').jRange({
					from: 6,
					to: 30,
					step: 1,
					scale: [6, 12, 18, 24, 30],
					format: '%s',
					width: 300,
					showLabels: true,
					showScale: true

				});
				
				$('.single-slider').jRange({
					from: 12,
					to: 36,
					step: 1,
					scale: [12, 18, 24, 30, 36],
					format: '%s',
					width: 300,
					showLabels: true,
					showScale: true

				});
				
		
				var a = null;
				$(".num").click(function(){
					a=setInterval("time()",500);
				})
				$(".num").blur(function(){
					clearInterval(a);
				})

			});
			
			function time(){
					var nu = $(".num").val();
					if(null==nu||""==nu){
						$(".word").html("");
					}else{
					if(nu%100==0){
						$(".word").html("");
					}else{
						$(".word").html("请输入100的整数倍");
					}}
				
				
			}