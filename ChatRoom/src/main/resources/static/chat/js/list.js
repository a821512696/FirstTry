//私聊
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
			if(i==data.length-1){
			htmls+="<a href='#toto' name='toto'><span id='sp'>_</sapn></a>";		 
			}
			htmls+="</li>";
		} else{
			htmls+="<li class='rightLi'>"
				+"<div class='RuserContain'>"
				+"<div class='userPic'>"+myPic+"</div>"		//头像
				+"<div class='userNick'>"+data[i].senderNick+"</div>"		//昵称
				+"</div>"
				+"<div class='RchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
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
			if(i==data.length-1){
			htmls+="<a href='#toto' name='toto'><span id='sp'>_</sapn></a>";		 
			}
			htmls+="</li>";
		} else{
			htmls+="<li class='rightLi'>"
				+"<div class='RuserContain'>"
				+"<div class='userPic'>"+myPic+"</div>"		//头像
				+"<div class='userNick'>"+data[i].senderNick+"</div>"		//昵称
				+"</div>"
				+"<div class='RchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length-1){
				htmls+="<a href=\"#toto\" name=\"toto\"><span id='sp'>_</sapn></a>";		
			}
			htmls+="</li>";
		}
	}
	$("#messgesUl").html(htmls);
	if(data.length>0)$("#messgesUl a")[0].click();
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
	
	$("#message-btnss").attr("data-flage","pri");
	//开始新的不断获取
	getPriss2();		//可以跳转到最下面一行
	intervalV = setInterval(getPriss,3000);
	
});


//公聊



function getPubss2(){
	 
	var groupId =$("#message-btnss").attr("data-groupId");
	console.log("groupId is "+groupId);
	var myPic=$("#myInfo").attr("data-pic");
	var myAcc=$("#myInfo").attr("data-acc");
//开始调用聊天聊天记录
$.post("/getPub",{"groupId":groupId},function(data){
	console.log(data); 
	
	var htmls ="";
	for(var i=0;i<data.length;i++){
		 
		if(data[i].acc!=myAcc){
			htmls+="<li class='leftLi'>"
			+"<div class='LuserContain'>"
			+"<div class='userPic'>"+data[i].pic+"</div>"		//头像
			+"<div class='userNick'>"+data[i].nick+"</div>"		//昵称
			+"</div>"
			+"<div class='LchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length-1){
			htmls+="<a href='#toto' name='toto'><span id='sp'>_</sapn></a>";		 
			}
			htmls+="</li>";
		} else{
			htmls+="<li class='rightLi'>"
				+"<div class='RuserContain'>"
				+"<div class='userPic'>"+data[i].pic+"</div>"		//头像
				+"<div class='userNick'>"+data[i].nick+"</div>"		//昵称
				+"</div>"
				+"<div class='RchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length-1){
				htmls+="<a href=\"#toto\" name=\"toto\"><span id='sp'>_</sapn></a>";		
			}
			htmls+="</li>";
		}
	}
	$("#messgesUl").html(htmls);
	if(data.length>0){
		$("#messgesUl a")[0].click();
	}
	
	});
}

function getPubss(){
	 
	var groupId =$("#message-btnss").attr("data-groupId");
	console.log("groupId is "+groupId);
	var myPic=$("#myInfo").attr("data-pic");
	var myAcc=$("#myInfo").attr("data-acc");
//开始调用聊天聊天记录
$.post("/getPub",{"groupId":groupId},function(data){
	console.log(data); 
	
	var htmls ="";
	for(var i=0;i<data.length;i++){
	 
		if(data[i].acc!=myAcc){
			htmls+="<li class='leftLi'>"
			+"<div class='LuserContain'>"
			+"<div class='userPic'>"+data[i].pic+"</div>"		//头像
			+"<div class='userNick'>"+data[i].nick+"</div>"		//昵称
			+"</div>"
			+"<div class='LchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length-1){
			htmls+="<a href='#toto' name='toto'><span id='sp'>_</sapn></a>";		 
			}
			htmls+="</li>";
		} else{
			htmls+="<li class='rightLi'>"
				+"<div class='RuserContain'>"
				+"<div class='userPic'>"+data[i].pic+"</div>"		//头像
				+"<div class='userNick'>"+data[i].nick+"</div>"		//昵称
				+"</div>"
				+"<div class='RchatContent'>"+data[i].content+"<br>"+data[i].time+"</div>";
			if(i==data.length-1){
				htmls+="<a href=\"#toto\" name=\"toto\"><span id='sp'>_</sapn></a>";		
			}
			htmls+="</li>";
		}
	}
	$("#messgesUl").html(htmls);
	});
}
$(".chatListG").click(function(){
	var groupId =$(this).attr("data-group");	//获取groupId
	//停止上一次循环获取聊天内容
	clearInterval(intervalV);
	$("#message-btnss").attr("data-flage","pub");
	$("#message-btnss").attr("data-groupId",groupId);	//groupId给发送按钮
	
	getPubss2();	//第一次直接跳到最下面
	//开始新的不断获取
	intervalV = setInterval(getPubss,3000);
	
	
});