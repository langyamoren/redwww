<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�û�ע��</title>
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
	restr="<font color='red'>��֤�벻��Ϊ��</font>";
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
		alert("����ȷ��д���ݣ�");
	    return false;
		}
}

 $(function(){
	 //��֤email
	 $("#reg_email").blur(function(){
			var userEmail=$(this).val();
			var re = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; 
			//if(!checkData.isEmail(userEmail))
		    if(!re.test(userEmail))
			{
				restr="<font color='red'>Eamil��ʽ��Ч!</font>"
				$("#reg_email").next("span").html(restr);
				return ;
			}
		    $.get("<%=path%>/mred/ajax/ajax_checkUserExsit?userEmail="+userEmail,
					  function(json){
								if(json.msg=="true")
								{
								 restr="<font color='red'>email�Ѵ��ڣ���������emailע��</font>";
								}
								else if(json.msg=="false")
								 {
								 restr="<font color='green'>��ϲ������ע��</font>"
								 f1=true;
								 }else{
								  restr="<font color='red'>������дemail!</font>";
								 }
								$("#reg_email").next("span").html(restr);
			});//end get
	 });//end ��֤email
	
	//��֤����
		$("#user_pwd_id").blur(function(){
			var pwd=$(this).val();
			if(pwd==""||pwd.length<6)
				{
				  restr="<font color='red'>���벻��Ϊ���ҳ��Ȳ���С��6</font>"
				}else{
					restr="<font color='green'>��ϲ</font>"	;
					f2=true;
				}
			$("#user_pwd_id").next("span").html(restr);
		});
		
		//��֤�ظ�����
		$("#user_repwd_id").blur(function(){
			var pwd=$(this).val();
			if(pwd==""||pwd.length<6)
				{
				  restr="<font color='red'>���벻��Ϊ���ҳ��Ȳ���С��6</font>"
				}
		    if($(this).val()!=$("#user_pwd_id").val())
		    	{
		    	  restr="<font color='red'>�������벻һ�£�</font>";
		    	}
			else{
					restr="<font color='green'>��ϲ</font>"	;
					f3=true;
				}
			$("#user_repwd_id").next("span").html(restr);
		});
		
		//��֤�û���
		$("#user_id").blur(function(){
			var user=$(this).val();
			if(user=="")
				{
				restr="<font color='red'>��������Ϊ��</font>";
				flag=false;
				}else{
			    restr="<font color='green'>��ϲ</font>";
			    f4=true;
				}
			$("#user_id").next("span").html(restr);
		});
		//��֤QQ
		$("#qq_id").blur(function(){
			var user=$(this).val();
			var re = /^[_0-9]*$/ ;
			if(user==""||!re.test(user)||user.length<6)
				{
				restr="<font color='red'>QQ����Ϊ��,ֻ��Ϊ����,�ҳ��Ȳ���С��6</font>";
			
				}else{
			    restr="<font color='green'>��ϲ</font>";
			    f5=true;
				}
			$("#qq_id").next("span").html(restr);
		});
		//��֤�ֻ�
		$("#cell_id").blur(function(){
			var user=$(this).val();
			var re = /^[_0-9]{11,12}$/ ;
			if(user==""||!re.test(user)||user.length<6)
				{
				restr="<font color='red'>�ֻ�����Ϊ��,ֻ��Ϊ����,�ҳ��Ȳ���С��11</font>";
				
				}else{
			    restr="<font color='green'>��ϲ</font>";
			    f6=true;
				}
			$("#cell_id").next("span").html(restr);
		});
		//������
		$("#recome_id").blur(function(){
			var user=$(this).val();
			   if(user=="")
				{
				restr="<font color='red'>�����벻��Ϊ��</font>";
				$("#recome_id").next("span").html(restr);
				return ;
				}else
				{
					 f7=true;
			   $.get("<%=path%>/mred/ajax/ajax_checkRecomeCode?recomeCode="+user,
					  function(json){
								if(json.msg=="true")
								{
								 restr="<font color='green'>��ϲ����֤����Ч</font>";
								 f8=true;
								}
								else if(json.msg=="false")
								 {
								 restr="<font color='red'>�Բ�����֤����Ч</font>";
								
								 }else{
								  restr="<font color='red'>�Բ�����֤����Ч</font>";
								 }
								$("#recome_id").next("span").html(restr);
					  });
				}
			
		});	
		
		//��֤��
		$("#rand_id").blur(function(){
			var user=$(this).val();
			if(user=="")
				{
				restr="<font color='red'>��֤�벻��Ϊ��</font>";
				}else{
			    restr="<font color='green'>��ϲ</font>";
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
   <h1>&nbsp;�û�ע��</h1>
   <p class="gene_line">
	   <label>�û���/Email:</label>
	   <input type="text" name="member.email" class="redInput"  id="reg_email"/>
	   <span><font color="#00CC00">���������õ�emailע��</font></span>
   </p>
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>����:</label>
	   <input type="password" name="member.password" class="redInput" id="user_pwd_id"/>
	   <span><font color="#00CC00">����6λ���ֺ���ĸ</font></span>
   </p>  
    <p class="gene_line">
	   <label>�ظ�����:</label>
	   <input type="password" name="repwd" class="redInput" id="user_repwd_id" />
	   <span><font color="#00CC00">������������ͬ</font></span>
   </p>  
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>����:</label>
	   <input type="text" name="member.name" class="redInput" id="user_id"/>
	   <span><font color="#00CC00">���������Ĵ���</font></span>
   </p>
   <p class="gene_line">
	   <label>QQ:</label>
	   <input type="text" name="member.qq" class="redInput" id="qq_id"/>
	   <span><font color="#00CC00">���������õ�qq</font></span>
   </p>
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>�ֻ�:</label>
	   <input type="text" name="member.cellphone" class="redInput" id="cell_id"/>
	   <span><font color="#00CC00">�����������ֻ�</font></span>
   </p>
   <p class="gene_line">
	   <label>������:</label>
	   <input type="text" name="recome" class="redInput" id="recome_id"/>
	   <span><font color="#00CC00">���û�������룬����ϵ����Ա</font></span>
   </p>
   <p class="gene_line" style="background-color:#F5F5F5;">
	   <label>��֤��:</label>
	   <input type="text" name="rand" class="redInput"  style="width:60px;" id="rand_id"/>
	  <img src="mred/ajax/randImg"  id="rand_img" border="0" style="cursor: pointer;" onclick="this.src='mred/ajax/randImg?ran='+Math.random();"/>
	   <span><font color="#00CC00">��������壬����ͼƬ����һ��</font></span>
   </p>
   <input type="submit" style="margin:10px 10px 10px 20px; width:80px; height:25px; line-height:25px; text-align:center; cursor:pointer;" class="redButton" value="����ע��"/>
  <p style="line-height:30px; border-bottom:1px #CCCCCC solid; margin-left:10px;"></p>
  <p>
  <h3 style=" line-height:35px; font-size:14px;"> ��������Ǳ�վ��Ա���������½</h3>
  <a href="red/login" class="redButton" style="text-decoration:none; width:60px; text-align:center; line-height:25px; height:25px; display:block;">��½</a>
  </p>
  </form>
</div>

</body>
</html>
