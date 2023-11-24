<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jjageul main</title>
<style>

.bg-video {position: absolute; top: 0; left: 0; height: 100%; width: 100%;}
.bg-video_content {height: 100%; width: 100%; object-fit: cover;}

.bg-text {position: absolute; top: 50%; width: 100%;}
.bg-text h1 {margin-top: -370px; text-align: center; font-size: 200px; font-weight: 700; color: #ffffff;}
.bg-text h2 {margin-top: 370px; text-align: center; font-size: 20px; font-weight: 700; color: #ffffff;}

</style>

</head>
<body>
	
	


	
	<div class="bg-video">
		<video class="bg-video_content" autoplay muted loop>
			<source src="img/main_background.mp4" type="video/mp4" />
		</video>
		
		<div class="bg-text">
			<h1>JJAGEUL</h1>
		</div>
		
		<!-- 검색창 넣기 -->
		<div class="sch_wrap">
			<form action="https://www.google.com/search" method="GET">
	        	<input name="q" type="text">
			</form>
		</div>
		
			
		<div class="bg-text">
			<h2>
				한국직업전문학교<br> 항공 자바(JAVA)풀스택 개발자 양성과정
			</h2>
		</div>
	</div>



</body>
</html>