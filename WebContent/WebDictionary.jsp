<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page  import="java.util.*"%>
<%@ page  import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="jsFile/jquery-3.3.1.min.js"></script>
<style>
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:150px;
    float:left;
    padding:5px;	      
}
#section {
    float:left;
    padding:10px;	 	 
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;
   }	 	
   
.product{ 
	background:white;
	width:200px; 
	height300px;  
	float:left;
	padding:5px;
	text-align:center;
} 

img{ 
	width:150px; 
	height:150px; 
	border:2px solid green; 
}  
</style>
<title>词典</title>
</head>
<body>

<script type="text/javascript"> 

	// 使用Ajax异步通讯
	function  learn(){  
   		$.ajax({  
    	type:"GET",  
    	url:"DictionaryLearn",  
   		data:{English:$("#inputEng").val(), Chinese:$("#inputChi").val()},  
    	statusCode: {404: function() {  
        alert('page not found'); }  
     	 },      
    	success:function(data,textStatus){ 
    		$("#inputEng").val("");
    		$("#inputChi").val("");
    	}  
    	});  
  	}  
	
	function  search(){  
   		$.ajax({  
    	type:"GET",  
    	url:"DictionarySearch",  
   		data:{English:$("#inputEng").val()},  
    	statusCode: {404: function() {  
        	alert('page not found'); }  
     	 },      
    	success:function(data,textStatus){  
    		$("#inputChi").val(data);
    	}  
    	});  
  	}
	
	window.onload = function(){
		
		$("#btn1").click(function(){
			learn();
		});
		$("#btn2").click(function(){
			search();
		});
	};
</script>

	<div id="header">
	<h1>英汉词典</h1>
	</div>

	<div id="nav">
		<br>
		<h3 id = "goDictionary" title="英和汉">英译汉</h3><br>
	</div>

	<div id="dictionary" class="section">
		<form id="f1">
			English Word:<br>
			<input type="text" name="English" id=inputEng>
			<br>
			Chinese Word:<br>
			<input type="text" name="Chinese" id=inputChi>
			<br>
		</form>
		<input type="button" name="m1" value="学习" id="btn1">
		<input type="button" name="m2" value="查找" id="btn2">
	</div>
	
	<div id="footer">
		欢迎使用WJL词典
	</div>

</body>
</html>