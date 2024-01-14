<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/globals.css" />
<link rel="stylesheet" href="css/home.css" />

</head>
<body>
	<div class="OFFOFF">
		<div class="div">
			<div class="board">
				<div class="group-3">
					<div class="overlap-3">
						<div class="AppA">
							<%-- Include jspB.jsp using attribute --%>
							<jsp:include page="${jspBPathA}" />
							<!--<jsp:include page="/WEB-INF/jsp/Login.jsp"></jsp:include>-->
						</div>
						<div class="text-wrapper-3">A</div>
					</div>
				</div>
				<div class="group-4">
					<div class="overlap-4">
						<div class="AppB">
							<jsp:include page="${jspBPathB}" />
							<!--上と同様にアプリのjspfileを指定 -->
						</div>
						<div class="text-wrapper-4">B</div>
					</div>
				</div>
				<div class="group-5">
					<div class="overlap-5">
						<div class="AppC">
							<jsp:include page="${jspBPathC}" />
							<!--上と同様にアプリのjspfileを指定 -->
						</div>
						<div class="text-wrapper-5">C</div>
					</div>
				</div>
				<div class="group-6">
					<div class="overlap-6">
						<div class="AppD">
							<jsp:include page="${jspBPathD}" />
							<!--上と同様にアプリのjspfileを指定 -->
						</div>
						<div class="text-wrapper-6">D</div>
					</div>
				</div>
				<div class="group-7">
					<div class="overlap-7">
						<div class="AppE">
							<jsp:include page="${jspBPathE}" />
							<!--上と同様にアプリのjspfileを指定 -->
						</div>
						<div class="text-wrapper-7">E</div>
					</div>
				</div>
			</div>
			<div class="menu-bar" id="menu-bar">
				<div class="title" id="title">
					<div class="rectangle-title-text"></div>
					<div class="title-text-wrapper">ホーム</div>
				</div>
				<div class="menu-button" id="menu-button">
					<div class="rectangle-4"></div>
					<div class="rectangle-5"></div>
					<div class="rectangle-6"></div>
				</div>
				<div class="setting-button" id="setting-button">
					<div class="overlap-group">
						<div class="rectangle"></div>
						<div class="rectangle-2"></div>
						<div class="rectangle-3"></div>
						<div class="ellipse"></div>
						<div class="ellipse-2"></div>
					</div>
				</div>
				<div class="L1 L-button">
					<div class="div-wrapper L-button-div">
						<div class="text-wrapper">1</div>
					</div>
				</div>
				<div class="L2 L-button">
					<div class="div-wrapper L-button-div">
						<div class="text-wrapper">2</div>
					</div>
				</div>
				<div class="L3 L-button">
					<div class="div-wrapper L-button-div">
						<div class="text-wrapper">3</div>
					</div>
				</div>
				<div class="Icon" id="Icon">
					<div class="Icon-overlap">
						<div class="Icon-text-wrapper">Icon</div>
					</div>
				</div>

				<script src="js/homejs.js"></script>
			</div>
		</div>
	</div>
</body>
</html>