<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="workOrder.WorkOrderDTO" %>
    <!DOCTYPE html>
    <html lang="en">
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Management System</title>
        <script src="workOrder.js"></script>
        <style>
            @font-face {
                font-family: "SOYOMapleBoldTTF";
                src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/SOYOMapleBoldTTF.woff2") format("woff2");
                font-weight: 400;
                font-style: normal;
            }
    
            body {
                display: flex;
                flex-direction: column;
                align-items: center;
                font-family: "SOYOMapleBoldTTF";
                margin: 0 auto;
                /* font-family: Arial, sans-serif; */
                background: #fff;
                color: #333;
                background-color: #ccc;
            }
    
            /* 햄버거 메뉴 아이콘 */
            .hamburger-menu {
                display: none;
                cursor: pointer;
                flex-direction: column;
                justify-content: space-between;
                width: 25px;
                height: 20px;
            }
    
            .hamburger-menu span {
                display: block;
                height: 3px;
                width: 100%;
                background-color: #fff;
                transition: all 0.2s ease;
            }
    
            /* title */
            #workerTitle {
                display: flex;
                width: 1000px;
                justify-content: space-between;
                padding: 5px;
    
            }
    
            #workerLogo {
                width: 200px;
                height: 80px;
                display: flex;
                align-items: center;
            }
    
            #workerTitle h1 {
                width: 200px;
                color: #000;
            }
    
            #mainTitle1 {
                display: none;
            }
    
            #mainTitle1 a {
                text-decoration: none;
                color: #333;
            }
    
            #mainTitle2 {
                display: none;
            }
    
            #mainTitle2 a {
                text-decoration: none;
                color: #333;
            }
    
            #myPage {
                width: 200px;
                height: 80px;
                display: flex;
                align-items: center;
            }
    
            #myPageLogo {
                width: 80px;
                height: 80px;
                margin-right: 3%;
            }
    
            #workerName a {
                text-decoration: none;
                color: #333;
    
            }
    
            #workerName a:hover {
                text-decoration: none;
                color: #888;
                transition: color 0.2s ease;
            }
    
            #workerTitle .workerPic {
                width: 80px;
                height: 80px;
                border-radius: 50%;
            }
    
            #workerTitle .logo {
                width: 200px;
                height: 70px;
            }
    
            .workerGrade {
                display: none;
            }
    
            /* title end */
    
            .wrap {
                width: 1000px;
                /* height: 100vh; */
                display: flex;
                flex-direction: column;
                margin: auto;
            }
    
            /* header와 nav의 집합 */
            .header-nav-container {
                position: relative;
                width: 100%;
                /* wrap과 동일한 너비 */
            }
    
            /* header 코드 */
            header {
                width: 100%;
                background: #000;
                color: #fff;
                text-align: center;
                padding: 20px;
                box-sizing: border-box;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }
    
            header h1 {
                font-size: 30px;
                margin: 0;
            }
    
            header ul {
                padding: 0;
                display: flex;
                justify-content: space-around;
                list-style: none;
                align-items: center;
            }
    
            header ul li {
                display: inline-block;
                margin: 0 15px;
            }
    
            header ul li a {
                font-size: 18px;
                text-decoration: none;
                color: #fff;
                transition: color 0.3s ease;
            }
    
            header ul li a:hover {
                color: #aaa;
            }
    
            /* header 코드 끝 */
    
            nav {
                width: 100%;
                position: absolute;
                top: 100%;
                /* header 높이에 맞게 조정 */
                left: 0;
                right: 0;
                background: #eee;
                max-height: 0;
                overflow: hidden;
                box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
                transition: max-height 0.5s ease, visibility 0s 0.5s, opacity 0.5s linear;
                visibility: hidden;
                z-index: 100;
                /* opacity: 0; */
            }
    
            /* nav 숨김요소 */
            nav.active {
                max-height: 500px;
                /* 활성화될 때 최대 높이 설정 */
                visibility: visible;
                opacity: 1;
                transition: max-height 0.5s ease, visibility 0s, opacity 0.5s linear;
            }
    
            /* nav 안의 menu-bar요소 */
            .menu-bar {
                width: 100%;
                height: 220px;
                border-top: 0px;
                border-right: 1px solid #ccc;
                border-bottom: 1px solid #ccc;
                box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
                display: flex;
                justify-content: space-evenly;
            }
    
            .menu-bar-content {
                /* margin-left: 40px; */
                width: 20%;
                display: inline-block;
                box-sizing: border-box;
            }
    
            .menu-bar-content ul li {
                padding: 10px;
            }
    
            .menu-bar-content ul li a {
                text-decoration: none;
                color: #444;
            }
    
            .menu-bar-content ul li a:hover {
                color: #aaa;
                transition: color 0.2s ease;
            }
    
            #menu-bar-content-sub {
                list-style: circle;
                font-size: 14px;
                padding-left: 20px;
            }
    
            #menu-bar-content-sub li {
                padding: 5px;
            }
    
            /* menu-bar요소 끝 */
    
            /* aside, section */
            .aside-section-container {
                width: 100%;
                display: flex;
                /* height: 100%; */
            }
    
            /* 좌측 메뉴바 */
            aside {
                width: 20%;
                background: #5f5f5f;
            }
    
            .aside-section-container ul li {
                margin-top: 25%;
                list-style: none;
            }
    
            .aside-section-container ul li a:hover {
                color: black;
            }
    
            .aside-section-container ul li a {
                text-decoration: none;
                color: #fff;
            }
    
            /* 섹션 창을 조작하기바람 */
            section {
                display: flex;
                justify-content: center;
                /* min-height: 800px; */
                width: 80%;
                overflow: auto;
                background: #eee;
                z-index: 50;
                align-items: center;
            }
    
            .work-main {
                width: 100%;
                display: flex;
                flex-wrap: wrap;
            }
    
            .work-content {
                margin-bottom: 5%;
                width: 100%;
                background-color: #eee;
            }
    
            .work-title .workOrder {
                text-align: center;
                width: 100%;
            }
    
            .work-list-zip {
                width: 80%;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
                margin-left: 10%;
                margin-bottom: 5%;
                background-color: #fff;
            }
    
            .work-ann {
                margin-left: -63%;
            }
    
            .workList {
                width: 100%;
                margin-top: 2%;
                display: flex;
                justify-content: center;
            }
    
            .workList p {
                width: 100%;
            }
    
            .workOrder {
                width: 60%;
            }
    
            .workImg {
                width: 30%;
                display: inline-block;
                margin-right: -5%;
            }
    
            .workImg img {
                width: 150px;
                height: 150px;
                margin-bottom: 2%;
                border: 1px solid #555;
            }
    
            .delete-checkbox {
                display: block;
                margin-top: 2%;
                margin-left: -4%;
                margin-right: 2%;
            }
    
            .workOrder h3 {
                text-align: center;
                font-size: 30px;
            }
    
            .button-div {
                width: 100%;
                text-align: center;
                margin-bottom: 5%;
            }
    
            .user-button-div {
                width: 100%;
                text-align: center;
                margin-bottom: 5%;
                display: none;
            }
    
            .add-button {
                background-color: #3498DB;
                margin-top: 10px;
                width: 80px;
                height: 40px;
                border-radius: 5px;
                cursor: pointer;
                color: #fff;
                border: 0;
            }
    
            .add-button:hover {
                background-color: rgb(0, 47, 255);
                transition: 0.2s;
            }
    
            .list-delete-button {
                margin: 0 10px;
                background-color: red;
                margin-top: 10px;
                width: 80px;
                height: 40px;
                border-radius: 5px;
                cursor: pointer;
                color: #fff;
                border: 0;
            }
    
            .list-delete-button:hover {
                background-color: rgb(190, 52, 52);
                transition: 0.2s;
            }
    
            .admin-change-button {
                background-color: #3498DB;
                margin-top: 10px;
                width: 80px;
                height: 40px;
                border-radius: 5px;
                cursor: pointer;
                color: #fff;
                border: 0;
            }
    
            .admin-change-button:hover {
                background-color: rgb(0, 47, 255);
                transition: 0.2s;
            }
    
    
    
    
            /* 추가하기 팝업 */
            .add-popup {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.7);
            }
    
            .add-popup-content {
                background-color: white;
                margin: 15% auto;
                margin-top: 5%;
                padding: 20px;
                width: 50%;
                border-radius: 5px;
                position: relative;
                text-align: center;
            }
    
            .add-note {
                width: 95%;
                margin: 0 auto;
                text-align: left;
                display: inline-block;
                padding: 0;
            }
    
            .add-note p {
                padding: 0;
            }
    
            .img-note {
                width: 50%;
                display: inline-block;
            }
    
            .add-popup-content p {
                width: 50%;
                margin-bottom: 0;
            }
    
            .add-title {
                margin: 5px auto;
                width: 97%;
                border: 1px solid #aba7a7;
                padding: 8px;
                border-radius: 5px;
            }
    
            .add-detail {
                width: 97%;
                border: 1px solid #aba7a7;
                padding: 8px;
                border-radius: 10px;
                margin: 5px auto;
                height: 200px;
                resize: none;
            }
    
            .add-apply-div {
                width: 100%;
                margin-top: 3%;
            }
    
            /* .img-button {
                background: #333;
                color: #fff;
                border: 0;
                border-radius: 10px;
                width: 120px;
                height: 50px;
                cursor: pointer;
            }
    
            .img-button:hover {
                background-color: #555;
                transition: 0.2s;
            } */
    
            .apply-button {
                background-color: #3498DB;
                margin-top: 10px;
                width: 80px;
                height: 40px;
                border-radius: 5px;
                cursor: pointer;
                color: #fff;
                border: 0;
            }
    
            .apply-button:hover {
                background-color: rgb(0, 47, 255);
                transition: 0.2s;
            }
    
            .cancel-button {
                margin: 0 10px;
                background-color: red;
                margin-top: 10px;
                width: 80px;
                height: 40px;
                border-radius: 5px;
                cursor: pointer;
                color: #fff;
                border: 0;
            }
    
            .cancel-button:hover {
                background-color: rgb(190, 52, 52);
                transition: 0.2s;
            }
    
            .img-note {
                width: 100%;
            }
    
            .addImgBox {
                width: 50%;
                display: flex;
                flex-wrap: wrap;
                align-content: space-evenly;
                justify-content: space-evenly;
                height: 80px;
            }
    
    
            #add-img,
            #fileName {
                border: 1px solid #8e8e8e;
                width: 70%;
                font-size: 13px;
                line-height: 2;
                border-radius: 5px;
                padding: 0;
            }
    
            #file-button {
                width: 25%;
                background-color: #007bff;
                font-size: 14px;
                color: white;
                border-radius: 5px;
                border: none;
                transition: background-color 0.3s;
                line-height: 2;
            }
    
            .img-select-button:hover,
            #file-button:hover {
                background-color: #0056b3;
            }
    
            .img-select-button {
                font-family: "SOYOMapleBoldTTF";
                width: 25%;
                background-color: #007bff;
                color: white;
                border-radius: 5px;
                border: none;
                transition: background-color 0.3s;
            }
    
            .img-preview {
                width: 150px;
                height: 150px;
                border: 1px solid #ccc;
                display: flex;
                justify-content: center;
                align-items: center;
                overflow: hidden;
                margin-left: 10px;
            }
    
            .img-preview img {
                max-width: 100%;
                max-height: 100%;
            }
    
            .img-preview-box {
                margin: 0 auto;
                width: 90%;
                display: flex;
                justify-content: space-between;
            }
    
            /* aside, section 끝*/
    
            footer {
                width: 100%;
                background: #000;
                color: #fff;
                text-align: center;
                height: 7%;
                line-height: 70px;
            }
    
            section div h2 {
                font-size: 30px;
            }
    
    
    
            @media screen and (max-width: 430px) {
    
                /* 전체 페이지 */
                .wrap {
                    width: 100%;
                }
    
                .workOrder h3 {
                    font-size: 20px;
                }
    
                /* 헤더 */
                header {
                    width: 100%;
                    background: #000;
                    color: #fff;
                    text-align: center;
                    padding: 5px;
                    box-sizing: border-box;
                    border-radius: 0px;
                }
    
                /* 미디어 쿼리 헤더 영역 수정 코드 */
                header ul {
                    display: none;
                }
    
                .header-content {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    width: 100%;
                    position: relative;
                }
    
                #headerTitle {
                    display: block !important;
                    text-align: center;
                    color: #fff;
                    width: 100%;
                    font-size: 20px;
                }
    
                #headerTitle a {
                    text-decoration: none;
                    color: #fff;
                }
    
                .hamburger-menu {
                    position: absolute;
                    left: 0;
                    top: 0;
                    display: flex;
                }
    
                #workerTitle {
                    display: none;
                }
    
                nav {
                    width: 100%;
                    position: absolute;
                    top: 100%;
                    /* header 높이에 맞게 조정 */
                    left: 0;
                    right: 0;
                    background: #eee;
                    max-height: 881px;
                    overflow: hidden;
                    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
                    transition: max-height 0.5s ease, visibility 0s 0.5s, opacity 0.5s linear;
                    transform: translateX(0%);
                    visibility: hidden;
                    z-index: 100;
                    /* opacity: 0; */
                }
    
                nav.active {
                    /* height: 881px; */
                    max-height: none;
                    width: 200px;
                    visibility: visible;
                    opacity: 1;
                    transition: max-height 0.5s ease, visibility 0s 0.5s, opacity 0.5s linear;
                    transform: translateX(0%);
                }
    
                /* 왼쪽에서 오른쪽으로 나오는 애니메이션을 추가합니다. */
                nav {
                    transform: translateX(-100%);
                    transition: transform 0.5s ease;
                }
    
                nav.active {
                    transform: translateX(0%);
                    transition: transform 0.5s ease;
                }
    
                nav.closing {
                    transform: translateX(-100%);
                    transition: transform 0.5s ease;
                }
    
                nav .menu-bar {
                    width: 100%;
                    height: 100%;
                    border-top: 0px;
                    border-right: 1px solid #ccc;
                    border-bottom: 1px solid #ccc;
                    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
                    display: flex;
                    flex-direction: column;
                    justify-content: flex-start;
                    background-color: #dde;
                }
    
                .menu-bar-content {
                    width: 100%;
                    margin-left: 0px;
                }
    
                .menu-bar-content ul li {
                    padding: 10px;
                }
    
                aside {
                    display: none;
                }
    
                /* 섹션 목록 */
                section {
                    width: 100%;
    
                }
    
                section div h2 {
                    font-size: 20px;
                }
    
                .modal-content {
                    width: 80%;
                }
    
                .workerGrade {
                    display: inline;
                }
    
                .workOrder {
                    font-size: 12px;
                }
    
                .work-ann h4 {
                    font-size: 16px;
                }
    
                .work-ann {
                    margin-left: -40%;
                }
    
                .work-list-zip {
                    margin: auto;
                    width: 90%;
                }
    
                .workImg img {
                    width: 100px;
                    height: 100px;
                }
    
                .add-popup-content {
                    width: 75%;
                    top: 7%;
                }
    
                #add-img,
                #fileName {
                    width: 80%;
                }
    
                .addImgBox {
                    width: 80%;
                    height: 150px;
                    justify-content: flex-start;
                }
    
                .file-button {
                    width: 50%;
    
                }
    
                .img-preview {
                    /* display: none; */
                    width: 100px;
                    height: 100px;
                    margin: 0;
    
                }
    
                #file-button,
                .img-select-button {
                    font-size: 10px;
                    width: 60px;
                    height: 30px;
                    line-height: 30px;
                    overflow: visible;
                }
    
                .workerPic {
                    width: 80px;
                    height: 80px;
                    border-radius: 50%;
                }
            }
        </style>
    
    </head>
    
    <body>

        <div id="workerTitle">
            <div id="workerLogo">
                <a href="#">
                    <image
                        src="https://cdn.discordapp.com/attachments/1185161279804026893/1200675420325036082/Jlogo.png?ex=65c70b1f&is=65b4961f&hm=ae28f53e9280fe71cffc1fc2ca74aec892875f13143ef4e109da28023c5b414b&"
                        class="logo"></image>
                </a>
            </div>
            <h1 id="mainTitle1"><a href="main.html">작업자 페이지</a></h1>
            <h1 id="mainTitle2"><a href="main.html">관리자 페이지</a></h1>
            <div id="myPage">
                <div id="myPageLogo">
                    <image
                        src="https://image.spreadshirtmedia.net/image-server/v1/compositions/T996A1PA2179PT10X17Y18D172654919W7098H6789/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/pixel-art-fox-fox-podstawki.jpg"
                        class="workerPic">
                </div>
                <span id="workerName">
                    <span class="workerGrade">
                        관리자<br>
                    </span>
                    이도연 대리님
                </span>
            </div>
        </div>
    
        <div class="wrap">
            <div class="header-nav-container">
                <header>
                    <!-- 모바일 헤더 코드 -->
                    <div class="header-content">
                        <div class="hamburger-menu">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                        <h1 id="headerTitle" style="display: none;"><a href="main.html">J.company</a></h1>
                    </div>
                    <ul>
                        <li><a href="#" class="hover" title="작업지시서">작업</a></li>
                        <li><a href="#" class="hover" title="품질검사">설비</a></li>
                        <li><a href="#" class="hover" title="건의사항">재고관리</a></li>
                        <li id="adminTitle"><a href="#" class="hover" title="직원관리">직원관리</a></li>
                        <li><a href="#" class="hover" title="직원 게시판">게시판</a></li>
                    </ul>
                </header>
                <nav>
                    <div class="menu-bar">
                        <div class="menu-bar-content">
                            <ul>
                                <li><a href="work-order.html">작업 지침서</a></li>
                                <li><a href="work-safety.html">안전 지침서</a></li>
                                <li><a href="work-quality.html">품질검사</a></li>
                                <li><a href="work-report.html">작업보고</a></li>
                            </ul>
                        </div>
                        <div class="menu-bar-content">
                            <ul>
                                <li><a href="facilityMonitoring.html">설비 모니터링</a></li>
    
                                <li><a href="process.html">공정도</a></li>
    
                                <li><a href="facilitiespage.html">설비 설정</a></li>
                            </ul>
                        </div>
                        <div class="menu-bar-content">
                            <ul>
                                <li><a href="stock_status.html">재고 현황</a></li>
                                <li><a href="Stock_Request.html">재고 신청</a></li>
                                <li><a href="Finished_product_management.html">완제품 관리</a></li>
                                <li><a href="Report_of_defective_inventory.html">재고 불량 신고</a></li>
                            </ul>
                        </div>
                        <div class="menu-bar-content" id="adminNav">
                            <ul>
                                <li><a href="Employee_managemen.html">직원목록</a></li>
                                <li><a href="work-record.html">근무기록</a></li>
                                <li><a href="vacation.html">휴가신청</a></li>
                            </ul>
                        </div>
                        <div class="menu-bar-content">
                            <ul>
                                <li><a href="boardTable.html">자유게시판</a></li>
                                <li><a href="suggestTable.html">건의사항</a></li>
                                <li><a href="QA.html">Q&A</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="aside-section-container">
                <aside>
                    <ul>
                        <li><a href="work-order.html">작업지침서</a></li>
                        <li><a href="work-safety.html">안전지침서</a></li>
                        <li><a href="work-quality.html">품질검사</a></li>
                        <li><a href="work-report.html">작업보고</a></li>
                    </ul>
                </aside>
                <section>
                    <article>
                    	<form method="post" action="WorkOrderServlet">
	                        <div class="work-main">
	                            <div id="work-content" class="work-content">
	    
	                                <div class="work-title">
	                                    <div class="workOrder">
	                                        <h3>작업지침서</h3>
	                                    </div>
	                                </div>
	                                <div class="work-list-zip">
	    
	                                    <div class="workList">
	                                        <div class="work-ann">
	                                            <h4>
	                                                조립 공정은 다음과 같습니다
	                                            </h4>
	                                        </div>
	                                    </div>
	                                                                
	
	                                    <%
											List<WorkOrderDTO> list = (List<WorkOrderDTO>)request.getAttribute("list");
										%>
	                                    <%	
	                                      	for(int i = 0; i < list.size(); i++) {
		                                      	String title = list.get(i).getTitle();
		                                      	String detail = list.get(i).getDetail();
		                                      	
		                                      	if(detail != null) {                                		               	 	
	                                    %>
		                                        <div class="workList">
		                                        	<div class="delete-checkbox">
		                                            	<input type="checkbox" class="delete-check">
		                                        	</div>
		                                        	<div class="workOrder">
		                                            	<p>
					                                        <%= title %>
					                                    </p>
					                                    <p>     
					                                        <%= detail.replace("\\n", "<br>") %>  
					                                    </p>			                                            
			                                        </div> 
			                                        <div class="workImg">
			                                            <img
			                                                src="https://image.spreadshirtmedia.net/image-server/v1/compositions/T996A1PA2179PT10X17Y18D172654919W7098H6789/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/pixel-art-fox-fox-podstawki.jpg">
			                                        </div>
			                                    </div>
	                                    <%
		                                      	}
	                                        }
	                                    %>
	    
	    
	                                </div>
	    
	                            </div>
	                            <div class="button-div">
	                                <button type="button" id="list-add-button" class="add-button">추가하기</button>
	                                <input type="submit" id="list-delete" class="list-delete-button" value="삭제하기">
	                                <button type="button" id="user" class="add-button">유저</button>
	                            </div>
                    		</form>
                            <div class="user-button-div">
                                <button type="button" id="admin-change-button" class="admin-change-button">관리자</button>
                            </div>
    
                        </div>
    
    					<form method="post" action="WorkOrderServlet">
	                       <div id="order-add-popup" class="add-popup">
	                           <div class="add-popup-content">
	                               <h2>조립 공정 체크사항 추가하기</h2>
	                               <div class="add-note">
	                                   <p>추가할 제목</p>
	                                   <input type="text" id="add-title" class="add-title" name="title" placeholder="제목입력">
	                                   <p>추가할 목록</p>
	                                   <textarea id="add-detail" class="add-detail" name="detail" rows="5" cols="50"
	                                       placeholder="내용 입력란"></textarea>
	                               </div>
	   
	                               <div class="img-note">
	                                   <span class="img-note-title">
	                                       이미지 링크 첨부하기
	                                   </span>
	                                   <div class="img-preview-box">
	                                       <div class="addImgBox">
	                                           <input type="text" id="add-img">
	                                           <input type="file" id="add-img-button" class="img-button" type="file"
	                                               style="display: none;" name="add-img-button">
	                                           <label for="add-img-button" id="file-button">파일선택</label>
	                                           <span id="fileName">선택된 파일 없음</span>
	                                           <button type="button" id="img-select-button"
	                                               class="img-select-button">사진선택</button>
	                                       </div>
	                                       <div class="img-preview">이미지 없음</div>
	                                   </div>
	                               </div>
	   
	                               <div class="add-apply-div">
	                                   <input type="submit" id="add-apply-button" class="apply-button" value="적용하기">
	                                   <button type="button" id="cancel-apply-button" class="cancel-button">취소하기</button>
	                               </div>
	                           </div>
	                       </div>
                        </form>
    
                    </article>
                </section>
            </div>
            <footer>ⓒ2024 J.company System</footer>
        </div>
    
    </body>
    
    </html>