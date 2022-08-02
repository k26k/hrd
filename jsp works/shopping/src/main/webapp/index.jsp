<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="./resources/base/head.jsp" %>
<body>
    <div class = "main">
        <div class = "main_wrap">
            <%@ include file="./resources/base/header.jsp" %>
            <div class="contents">
                <%@ include file="./resources/base/navigation.jsp" %>
                <%@ include file="./resources/base/main_slider.jsp" %>
                <%@ include file="./resources/base/banner/kakao_banner.jsp" %>
                <div class="app_sale">
                    <div class = "caption clear">
                        <h3><b>앱 한정 타임세일<span class="caption_sub">매일 새로운 타임특가</span></b></h3>
                    </div>
                </div>
                <!-- ============== 참고용 ============ -->
                <div>
                    <div>
	                    <div class = "caption clear">
	                        <h3><b>6월 제철 농산물<span class="caption_sub">지금 꼭 먹어야 하는 제철 식재료</span></b></h3>
	                    </div>
                	</div>
                	<%@ include file="./resources/base/products/pd1.jsp" %>
                	<div>
	                    <div class = "caption clear">
	                        <h3><b>NEW<div class = "new"></div>신상품</b></h3>
	                    </div>
                	</div>
                    <%@ include file="./resources/base/products/pd2.jsp" %>
                </div>
                
            </div>
        </div>
    </div>
<!--
    
    
    메인페이지
    
    상세
    결제페이지
    Q&A
    
    로그인
    회원가입
    
    마이페이지
    장바구니
    
    결제내역
    배송조회
    
    
-->
</body>
</html>