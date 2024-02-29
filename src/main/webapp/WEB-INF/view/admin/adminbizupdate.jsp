<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     


	<form action="/admin/admin-bizupdate" method="post" enctype="multipart/form-data">
		<div class="card mb-3" style="max-width: 700px;">
		  <div class="row g-0">
		    <div class="col-md-4">
		      <img src="/adimg/users.png" style="width: 100px; height: 130px; margin-left: 30px; margin-top: 60px;" class="img-fluid rounded-start" alt="...">
		    </div>
		    <div class="col-md-8">
		      <div class="card-body">
		        <h3 class="card-title">사업자정보수정</h3>
		        <div class="row" style ="margin-top: 30px;">
		        	 <div class="col-md-3">
				        <label for="name" class="form-label">번호</label>
				     </div>
				    <div class="col-md-5">
				        <div class="input-box">
				            <input type="text" class="form-control" name ="bizno" id="user_no_input" >
				        </div>
				    </div>
				  </div>
		 		  <div class="row" style ="margin-top: 30px;">
				    <div class="col-md-3">
				        <label for="name" class="form-label">아이디</label>
				    </div>
				    <div class="col-md-5">
				        <div class="input-box">
				            <input type="text" class="form-control" name = "bizid" id="bizid" placeholder="아이디입력">
				        </div>
				    </div>
				  </div>
				  <div class="row" style ="margin-top: 10px;">
				    <div class="col-md-3">
				        <label for="name" class="form-label">브랜드명</label>
				    </div>
				    <div class="col-md-5">
				        <div class="input-box">
				            <input type="text" class="form-control" name = "bizbrandname" id="bizbrandname" placeholder="이름">
				        </div>
				    </div>
				</div>
				<div class="row" style ="margin-top: 10px;">
				    <div class="col-md-3">
				        <label for="email" class="form-label">이메일</label>
				    </div>
				    <div class="col-md-7">
				        <div class="input-box">
				            <input type="email" class="form-control" name = "bizemail" id="bizemail" placeholder="이메일">
				        </div>
				    </div>
				</div>
				<div class="row" style ="margin-top: 10px;">
				    <div class="col-md-3">
				        <label for="phone" class="form-label">휴대번호</label>
				    </div>
				    <div class="col-md-7">
				        <div class="input-box">
				            <input type="tel" class="form-control" name = "bizhp" id="bizhp" placeholder="전화번호">
				        </div>
				    </div>
				</div>
				<div class="row" style ="margin-top: 10px;">
				    <div class="col-md-3">
				        <label for="phone" class="form-label">전화번호</label>
				    </div>
				    <div class="col-md-7">
				        <div class="input-box">
				            <input type="tel" class="form-control" name = "biztel" id="biztel" placeholder="전화번호">
				        </div>
				    </div>
				 </div>
				
			   <div class="row" style ="margin-top: 10px;">
				    <div class="col-md-3">
				        <label for="name" class="form-label">등록증</label>
				    </div>
				    <div class="col-md-5">
				        <div class="input-box">
						<input type='file' id='btnAtt' multiple='multiple' name="files">				        
				    </div>
				</div>
		      </div> 	
				
				
				
				
		 		
		      </div>
		    </div>
		  </div>
		  
		  <div class="row">
            <div class="col-md-12">
                <button type="submit" class="btn btn-success" id="updateButton" style="margin-left:450px; margin-bottom: 10px; margin-top:10px;">수정하기</button>
            </div>
          </div>
		  
		  
		   
		</div>
		
	</form>	


