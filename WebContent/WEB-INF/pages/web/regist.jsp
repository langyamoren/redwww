<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
<style type="text/css">
  #regist{ width:600px; margin-left:10px; padding:30px 0px 0px 20px;}
  #regist h1{ font-size:16px; border-bottom:1px #CCCCCC solid; line-height:30px;}
  #regist .gene_line{ height:60px; line-height:60px; padding-left:10px;}
  #regist .gene_line label{ width:100px; display:block; float:left;}
  
  .bg11{ background-color:#F5F5F5;}
</style>
<script type="text/javascript">
var flag=false;
var f1=false;
var f2=false;
var f3=false;
var f4=false;
var f5=false;
var f6=false;
var f7=false;
var f8=false;
var f9=false;
var f10=false;
function  checkLogin()
{
	if($("#rand_id").val()=="")
	{
	restr="<font color='red'>验证码不能为空</font>";
	$("#rand_id_show").html(restr);
	}else
		{
		   f9=true;
		}
	if(f1&&f2&&f3&&f4&&f5&&f6&&f7&&f8&&f9)
		{
	     return true;
		}
	else
		{
		alert("请正确填写数据！");
	    return false;
		}
}

 $(function(){
	 //验证email
	 $("#reg_email").blur(function(){
			var userEmail=$(this).val();
			var re = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; 
			//if(!checkData.isEmail(userEmail))
		    if(!re.test(userEmail))
			{
				restr="<font color='red'>Eamil格式无效!</font>"
				$("#reg_email").next("span").html(restr);
				return ;
			}
		    $.get("<%=path%>/mred/ajax/ajax_checkUserExsit?userEmail="+userEmail,
					  function(json){
								if(json.msg=="true")
								{
								 restr="<font color='red'>email已存在，请用其它email注册</font>";
								}
								else if(json.msg=="false")
								 {
								 restr="<font color='green'>恭喜，可以注册</font>"
								 f1=true;
								 }else{
								  restr="<font color='red'>请先填写email!</font>";
								 }
								$("#reg_email").next("span").html(restr);
			});//end get
	 });//end 验证email
	
	//验证密码
		$("#user_pwd_id").blur(function(){
			var pwd=$(this).val();
			if(pwd==""||pwd.length<6)
				{
				  restr="<font color='red'>密码不能为空且长度不能小于6</font>"
				}else{
					restr="<font color='green'>恭喜</font>"	;
					f2=true;
				}
			$("#user_pwd_id").next("span").html(restr);
		});
		
		//验证重复密码
		$("#user_repwd_id").blur(function(){
			var pwd=$(this).val();
			if(pwd==""||pwd.length<6)
				{
				  restr="<font color='red'>密码不能为空且长度不能小于6</font>"
				}
		    if($(this).val()!=$("#user_pwd_id").val())
		    	{
		    	  restr="<font color='red'>两次密码不一致！</font>";
		    	}
			else{
					restr="<font color='green'>恭喜</font>"	;
					f3=true;
				}
			$("#user_repwd_id").next("span").html(restr);
		});
		
		//验证用户名
		$("#user_id").blur(function(){
			var user=$(this).val();
			if(user=="")
				{
				restr="<font color='red'>姓名不能为空</font>";
				flag=false;
				}else{
			    restr="<font color='green'>恭喜</font>";
			    f4=true;
				}
			$("#user_id").next("span").html(restr);
		});
		//验证QQ
		$("#qq_id").blur(function(){
			var user=$(this).val();
			var re = /^[_0-9]*$/ ;
			if(user==""||!re.test(user)||user.length<6)
				{
				restr="<font color='red'>QQ不能为空,只能为数字,且长度不能小于6</font>";
			
				}else{
			    restr="<font color='green'>恭喜</font>";
			    f5=true;
				}
			$("#qq_id").next("span").html(restr);
		});
		//验证手机
		$("#cell_id").blur(function(){
			var user=$(this).val();
			var re = /^[_0-9]{11,12}$/ ;
			if(user==""||!re.test(user)||user.length<6)
				{
				restr="<font color='red'>手机不能为空,只能为数字,且长度不能小于11</font>";
				
				}else{
			    restr="<font color='green'>恭喜</font>";
			    f6=true;
				}
			$("#cell_id").next("span").html(restr);
		});
		//邀请码
		$("#recome_id").blur(function(){
			var user=$(this).val();
			   if(user=="")
				{
				restr="<font color='red'>邀请码不能为空</font>";
				$("#recome_id").next("span").html(restr);
				return ;
				}else
				{
					 f7=true;
			   $.get("<%=path%>/mred/ajax/ajax_checkRecomeCode?recomeCode="+user,
					  function(json){
								if(json.msg=="true")
								{
								 restr="<font color='green'>恭喜，验证码有效</font>";
								 f8=true;
								}
								else if(json.msg=="false")
								 {
								 restr="<font color='red'>对不起，验证码无效</font>";
								
								 }else{
								  restr="<font color='red'>对不起，验证码无效</font>";
								 }
								$("#recome_id").next("span").html(restr);
					  });
				}
			
		});	
		
		//验证码
		$("#rand_id").blur(function(){
			var user=$(this).val();
			if(user=="")
				{
				restr="<font color='red'>验证码不能为空</font>";
				}else{
			    restr="<font color='green'>恭喜</font>";
			    f9=true;
				}
			$("#rand_id_show").html(restr);
		});	
 });
</script>
</head>

<body>
<div id="regist">
<form action="red/addMember" method="post" onsubmit="return checkLogin();">
   <h1>&nbsp;用户注册</h1>
   <p class="gene_line">
	   <label>用户名/Email:</label>
	   <input type="text" name="member.email" class="redInput"  id="reg_email"/>
	   <span><font color="#00CC00">请用您常用的email注册</font></span>
   </p>
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>密码:</label>
	   <input type="password" name="member.password" class="redInput" id="user_pwd_id"/>
	   <span><font color="#00CC00">至少6位数字和字母</font></span>
   </p>  
    <p class="gene_line">
	   <label>重复密码:</label>
	   <input type="password" name="repwd" class="redInput" id="user_repwd_id" />
	   <span><font color="#00CC00">和以上密码相同</font></span>
   </p>  
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>姓名:</label>
	   <input type="text" name="member.name" class="redInput" id="user_id"/>
	   <span><font color="#00CC00">请输入您的大名</font></span>
   </p>
   <p class="gene_line">
	   <label>QQ:</label>
	   <input type="text" name="member.qq" class="redInput" id="qq_id"/>
	   <span><font color="#00CC00">请用您常用的qq</font></span>
   </p>
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>手机:</label>
	   <input type="text" name="member.cellphone" class="redInput" id="cell_id"/>
	   <span><font color="#00CC00">请输入您的手机</font></span>
   </p>
   <p class="gene_line">
	   <label>邀请码:</label>
	   <input type="text" name="recome" class="redInput" id="recome_id"/>
	   <span><font color="#00CC00">如果没有邀请码，请联系管理员</font></span>
   </p>
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>验证码:</label>
	   <input type="text" name="rand" class="redInput"  style="width:60px;" id="rand_id"/>
	  <img src="mred/ajax/randImg"  id="rand_img" border="0" style="cursor: pointer;" onclick="this.src='mred/ajax/randImg?ran='+Math.random();"/>
	   <span><font color="#00CC00">如果看不清，请点击图片，换一张</font></span>
   </p>
   <input type="submit" style="margin:10px 10px 10px 20px; width:80px; height:25px; line-height:25px; text-align:center; cursor:pointer;" class="redButton" value="现在注册"/>
  <p style="line-height:30px; border-bottom:1px #CCCCCC solid; margin-left:10px;"></p>
  <p>
  <h3 style=" line-height:35px; font-size:14px;"> 如果您已是本站会员请在下面登陆</h3>
  <a href="red/login" class="redButton" style="text-decoration:none; width:60px; text-align:center; line-height:25px; height:25px; display:block;">登陆</a>
  </p>
  </form>
</div>

</body>
</html>
