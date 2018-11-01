 
var html = "";
 
 
//点击按钮下拉

$(".icon").on('click', function() {
	//获取列表
	 
	$.post("/getList",function(data){
		console.log(data);
		console.log(data.length);
		console.log(data[1].acc);
		html +="<li class='chatListG' id='OneGroup' data-group='123456789'>" + "<i class='iconfont'>&#xe752;</i>" + "<p>" + "聊天室" + "</p>" + "</li>";
		for (var i = 0; i < data.length; i++) {
		    html += "<li class='chatList' data-acc='"+data[i].acc+"' " +
		    		" data-pic='"+data[i].pic+"' " +
		    		" data-nick='"+data[i].nick+"'" +
		    		"> " + "<i class='iconfont'>&#xe752;</i>" + "<p>" + data[i].nick + "</p>" + "</li>";
		}
		html +=" <script src='chat/js/list.js'  ></script>";
		$(".chatbar-contacts-uls").html(html);
		html="";
	});
	

    if ($(".chatbar").is(":visible")) {
        $(".chatbar").slideUp();
        $(".icon-box").removeClass('shadow');
    }else{
        $(".chatbar").slideDown();
        $(".icon-box").addClass('shadow');
    }
});



