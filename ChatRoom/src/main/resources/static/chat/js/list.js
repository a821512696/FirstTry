function getPriss(){
	var otherAcc = $(".message-btn").attr("data-acc");
var otherPic = $(".message-btn").attr("data-pic");
var otherNick = $(".message-btn").attr("data-nick");
console.log("目标acc是"+otherAcc+"目标昵称是"+otherNick+"目标头像是"+otherPic);
var myPic=$("#myInfo").attr("data-pic");

//开始调用聊天聊天记录
$.post("/getPri",{"otherAcc":otherAcc},function(data){
	console.log(data); 
	
	var htmls ="";
	for(var i=0;i<data.length;i++){
		console.log(""+data.senderNick==otherNick);
		
		console.log("  "+otherNick+"   "+data[i].senderNick);
		if(data[i].senderNick==otherNick){
			htmls+="<li class='leftLi'>"
			+"<div class='LuserContain'>"
			+"<div class='userPic'>"+otherPic+"</div>"		//头像
			+"<div class='userNick'>"+data[i].senderNick+"</div>"		//昵称
			+"</div>"
			+"<div class='LchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length){
			htmls+="<a href='#toto' name='toto'><span id='sp'>_</sapn></a>";		 
			}
			htmls+="</li>";
		} else{
			htmls+="<li class='rightLi'>"
				+"<div class='RuserContain'>"
				+"<div class='userPic'>"+myPic+"</div>"		//头像
				+"<div class='userNick'>"+data[i].senderNick+"</div>"		//昵称
				+"</div>"
				+"<div class='RchatContent'>"+data[i].content+"<br>"+data.time+"</div>";
			if(i==data.length-1){
				htmls+="<a href=\"#toto\" name=\"toto\"><span id='sp'>_</sapn></a>";		
			}
			htmls+="</li>";
		}
	}
	$("#messgesUl").html(htmls);
	
	});
}

function getPriss2(){
	var otherAcc = $(".message-btn").attr("data-acc");
var otherPic = $(".message-btn").attr("data-pic");
var otherNick = $(".message-btn").attr("data-nick");
console.log("目标acc是"+otherAcc+"目标昵称是"+otherNick+"目标头像是"+otherPic);
var myPic=$("#myInfo").attr("data-pic");

//开始调用聊天聊天记录
$.post("/getPri",{"otherAcc":otherAcc},function(data){
	console.log(data); 
	
	var htmls ="";
	for(var i=0;i<data.length;i++){
		console.log(""+data.senderNick==otherNick);
		
		console.log("  "+otherNick+"   "+data[i].senderNick);
		if(data[i].senderNick==otherNick){
			htmls+="<li class='leftLi'>"
			+"<div class='LuserContain'>"
			+"<div class='userPic'>"+otherPic+"</div>"		//头像
			+"<div class='userNick'>"+data[i].senderNick+"</div>"		//昵称
			+"</div>"
			+"<div class='LchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length){
			htmls+="<a href='#toto' name='toto'><span id='sp'>_</sapn></a>";		 
			}
			htmls+="</li>";
		} else{
			htmls+="<li class='rightLi'>"
				+"<div class='RuserContain'>"
				+"<div class='userPic'>"+myPic+"</div>"		//头像
				+"<div class='userNick'>"+data[i].senderNick+"</div>"		//昵称
				+"</div>"
				+"<div class='RchatContent'>"+data[i].content+"<br>"+data.time+"</div>";
			if(i==data.length-1){
				htmls+="<a href=\"#toto\" name=\"toto\"><span id='sp'>_</sapn></a>";		
			}
			htmls+="</li>";
		}
	}
	$("#messgesUl").html(htmls);
	$("#messgesUl a")[0].click();
	});
}


var intervalV = 0;
$(".chatList").click(function(){
	//停止上一次循环获取聊天内容
	clearInterval(intervalV);
	
	var otherAcc = $(this).attr("data-acc");
	var otherNick = $(this).attr("data-nick");
	var otherPic = $(this).attr("data-pic");
	alert($(this).attr("data-acc")+"  "+$(this).attr("data-nick")+"  "+$(this).attr("data-pic"));
	//将当前的 账号 头像 昵称 保存到发送按钮
	$("#message-btnss").attr("data-acc",otherAcc);
	$("#message-btnss").attr("data-pic",otherPic);
	$("#message-btnss").attr("data-nick",otherNick);
	
	//开始新的不断获取
	getPriss2();		//可以跳转到最下面一行
	intervalV = setInterval(getPriss,3000);
	
});
