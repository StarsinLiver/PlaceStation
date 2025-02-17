<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/cs.css">
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
</div>
</nav>
<div class="main">
	<section class="module-small">
		<div class="container">
			<div class="row">
				<!-- aside bar 시작 -->
				<%@ include file="/WEB-INF/view/cs/cs_aside.jsp"%>
				<!-- aside bar 끝 -->
				<!-- 메인 시작 -->
				<div class="col-sm-8 col-sm-offset-1 wow fadeIn">
					<div class="post">
						<div class="comment-form">
							<h4 class="comment-form-title font-alt">1:1 문의</h4>

						</div>
						<div class="post-header font-alt"></div>
						<div class="search">
							<form role="form" action="/cs/qna">
								<div class="search-box">
									<input class="form-control" type="text" placeholder="Search..."
										name="search" />
									<button class="search-btn" type="submit">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</form>
						</div>
						<div></div>
					</div>
					<div class="comments" style="text-align: right;">
						<h5>
							<a href="/cs/qna/qna-tag" class="btn btn-default btn-round"
								type="button">글 쓰기</a>
						</h5>
					</div>

					<div>
						<div class="panel panel-default">
							<c:forEach var="qnaList" items="${qnaList}">
								<div class="panel-heading">
									<h4 class="panel-title font-alt">
										<a class="collapsed" data-toggle="collapse"
											data-parent="#accordion" href="#support${qnaList.qbno}">
											<p style="text-align: left;">${qnaList.qtitle}</p> 등록일 :
											${qnaList.qregdate}
										</a>

									</h4>
								</div>
								<div class="panel-collapse collapse" id="support${qnaList.qbno}">
									<div class="panel-body">
										<p>${qnaList.qcontent}</p>


										<img src="${qnaList.filepath}" />
									</div>

									<c:choose>
										<c:when test="${qnaList.qstatus == '완료'}">
											<div class="panel-body">
												<hr />
												<h4>관리자</h4>
												<p>${qnaList.qreply}</p>
											</div>
										</c:when>
										<c:otherwise>
											<div class="panel-body">
												<hr />
												<h4>아직 답변 글이 없습니다.</h4>
											</div>
										</c:otherwise>
									</c:choose>
								</div>

							</c:forEach>
						</div>
					</div>
					<div class="pagination font-alt">
						<c:if test="${pageVO.prev}">
							<a href="/cs/qna?page=${pageVO.startPage - 1}"><i
								class="fa fa-angle-left"></i></a>
						</c:if>

						<c:forEach var="i" begin="${pageVO.startPage}"
							end="${pageVO.endPage}" step="1">
							<c:set var="isActive" value="${pageVO.cri.page == i}" />
							<li ${isActive ? 'active' : ''}"><a
								class="page-link" href="/cs/qna?page=${i}">${i}</a></li>
						</c:forEach>

						<c:if test="${pageVO.next}">
							<a href="/cs/qna?page=${pageVO.endPage + 1}"><i
								class="fa fa-angle-right"></i></a>
						</c:if>
					</div>
				</div>
				<!-- 메인 끝 -->
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
	</main>
	<!--  
    JavaScripts
    =============================================
    -->
	<script src="/assets/lib/jquery/dist/jquery.js"></script>
	<script src="/assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="/assets/lib/wow/dist/wow.js"></script>
	<script src="/assets/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js"></script>
	<script src="/assets/lib/isotope/dist/isotope.pkgd.js"></script>
	<script src="/assets/lib/imagesloaded/imagesloaded.pkgd.js"></script>
	<script src="/assets/lib/flexslider/jquery.flexslider.js"></script>
	<script src="/assets/lib/owl.carousel/dist/owl.carousel.min.js"></script>
	<script src="/assets/lib/smoothscroll.js"></script>
	<script src="/assets/lib/magnific-popup/dist/jquery.magnific-popup.js"></script>
	<script
		src="/assets/lib/simple-text-rotator/jquery.simple-text-rotator.min.js"></script>
	<script src="/assets/js/plugins.js"></script>
	<script src="/assets/js/main.js"></script>
	</body>
	</html>