<!DOCTYPE html>
<%@page pageEncoding="utf-8" language="java" %>
<%
	String path = request.getContextPath();
	String appkey = "12bbd1084bf2a";
%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>OnlineSale 分享</title>
	<link rel="stylesheet" href="/build/css/dashboard/all-ad2363583b.css" />
	<link rel="shortcut icon" href="<%=path %>/image/favicon.ico" />
</head>
<body>
	<div class="-mob-share-ui-button -mob-share-open">分享</div>
	<div class="-mob-share-ui -mob-share-ui-theme -mob-share-ui-theme-slide-left" style="display: none">
		<ul class="-mob-share-list">
			<li class="-mob-share-weibo">
				<p>新浪微博</p>
			</li>
			<li class="-mob-share-tencentweibo">
				<p>腾讯微博</p>
			</li>
			<li class="-mob-share-qzone">
				<p>QQ空间</p>
			</li>
			<li class="-mob-share-qq">
				<p>QQ好友</p>
			</li>
			<li class="-mob-share-weixin">
				<p>微信</p>
			</li>
		</ul>
		<div class="-mob-share-close">取消</div>
	</div>
	<div class="-mob-share-ui-bg"></div>

	<script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=<%=appkey%>"></script>

	<script>
        mobShare.config( {
     
        debug: true, // 开启调试，将在浏览器的控制台输出调试信息
     
        appkey: '<%=appkey%>', // appkey
     
        params: {
            url: 'http://my.oschina.net/fengshuzi/blog/265110', // 分享链接
            title: 'springmvc +hibernate+ spring+ maven框架搭建', // 分享标题
            description: 'springmvc +hibernate+ spring+ maven框架搭建', // 分享内容
           // pic: '', // 分享图片，使用逗号,隔开
           // reason:'',//只应用与QZone
        },
     
        /**
         * 分享时触发的回调函数
         * 分享是否成功，目前第三方平台并没有相关接口，因此无法知道分享结果
         * 所以此函数只会提供分享时的相关信息
         * 
         * @param {String} plat 平台名称
         * @param {Object} params 实际分享的参数 { url: 链接, title: 标题, description: 内容, pic: 图片连接 }
         */
        callback:function( plat, params ) {
            alert(plat);
            console.writeln(params);
        }
        } );
 
    </script>
	<!--MOB SHARE END-->
</body>
</html>