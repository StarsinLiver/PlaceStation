<img width="100%" height="170px" alt="logo jpg" src="https://github.com/Kira7124/PlaceStation/assets/89882482/4c950f89-5352-430e-bc5f-54195a9dfbc5">

# 🏙 프로젝트 개요
---
장소 공유 및 예약 관리서비스 플랫폼<br><br>

|Name|김진수|이산하|정영재|조유빈|김병준|
|---|---|---|---|---|---|
|**position**|팀장/관리자|결제/예약/사업자|유저|고객센터|상품관리|


- 프로젝트 기간: 총 15일 (02/2 ~ 03/07)

<br>
<br>

 # 📚기술스택
---
<details>
<summary>## 🕵️‍♂️Front_End</summary>
<div markdown="1">

- bootstrap : 4.6.2
- HTML5
- CSS3
- JavaScript : 1.16.1
- JQuery : 3.6.4
- Chart.js
</div>
</details>🕵️‍♂️🔎🔍 

<br>
<br>
<details>
<summary>## 🕵️‍♂️Back_End</summary>
<div markdown="1">
 
- springboot : 4.18.0
- H2 Database → MySQL : 8.0.32
- jdk : 11.0.17
- lombok
- MyBatis
- JSP
- BCrypt HASH
- Apache Tomcat : 9.0
</div>
</details>🕵️‍♂️🔎🔍 

<br>
<br>
<details>
<summary>## 📡API</summary>
<div markdown="1">
 
- 카카오/구글/네이버 소셜 로그인 API (OAuth 2.0 프로토콜)
- 포트원 API
- 이메일 전송 API (구글 SMTP 프로토콜)
- 카카오 맵 API
- DAUM 우편번호 찾기 API
</div>
</details>




# ⚙ 의존성
---
	implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
	implementation group: 'org.glassfish.web', name: 'jakarta.servlet.jsp.jstl', version: '2.0.0'
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3'
	implementation 'com.itextpdf:itext7-core:7.2.1'
	implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'
	runtimeOnly 'com.mysql:mysql-connector-j'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	testImplementation 'org.springframework.security:spring-security-test'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-mail'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	implementation 'org.springframework.security:spring-security-taglibs:6.2.2'
	implementation 'io.jsonwebtoken:jjwt-api:0.11.2'
	implementation 'io.jsonwebtoken:jjwt-impl:0.11.2'
	implementation 'io.jsonwebtoken:jjwt-jackson:0.11.2'
	implementation 'org.springframework.boot:spring-boot-starter-mail'
	implementation 'org.springframework.boot:spring-boot-starter-oauth2-client:3.2.2'


# 1️⃣ 프로젝트 구조
```


📦src
 ┗ 📂main
   ┣ 📂java
   ┃ ┗ 📂com
   ┃   ┗ 📂project3
   ┃     ┗ 📂placestation
   ┃       ┣ 📂admin
   ┃       ┃ ┗ 📂controller
   ┃       ┃ ┗ 📂dto
   ┃       ┣ 📂biz
   ┃       ┃ ┗ 📂controller
   ┃       ┃ ┗ 📂handlr
   ┃       ┃ ┗ 📂model
   ┃       ┣ 📂config
   ┃       ┃ ┗ 📂error
   ┃       ┃ ┗ 📂jwt
   ┃       ┃ ┗ 📂oauth2
   ┃       ┣ 📂cs
   ┃       ┃ ┗ 📂controller
   ┃       ┃ ┗ 📂dto
   ┃       ┣ 📂fieldb
   ┃       ┃ ┗ 📂controller
   ┃       ┃ ┗ 📂model
   ┃       ┣ 📂member
   ┃       ┃ ┗ 📂controller
   ┃       ┃ ┗ 📂dto
   ┃       ┃ ┗ 📂sequenceInterface
   ┃       ┣ 📂handler
   ┃       ┃ ┗ 📂exception
   ┃       ┣ 📂party
   ┃       ┃ ┣ 📂controller
   ┃       ┃ ┗ 📂model
   ┃       ┣ 📂payment
   ┃       ┃ ┣ 📂controller
   ┃       ┃ ┗ 📂dto
   ┃       ┣ 📂product
   ┃       ┃ ┣ 📂controller
   ┃       ┃ ┗ 📂dto
   ┃       ┣ 📂repository
   ┃       ┃ ┣ 📂entity
   ┃       ┃ ┗ 📂interfaces
   ┃       ┣ 📂service
   ┃       ┗ 📂utils
   ┣ 📂resources
   ┃ ┣ 📂db
   ┃ ┣ 📂mapper
   ┃ ┗ 📂static
   ┃   ┣ 📂adimg
   ┃   ┣ 📂assets
   ┃   ┣ 📂banner
   ┃   ┣ 📂css
   ┃   ┣ 📂js
   ┃   ┣ 📂img
   ┃   ┣ 📂logo
   ┃   ┣ 📂favicons
   ┃   ┗ 📂policy
   ┗ 📂webapp
     ┗ 📂WEB-INF
       ┗ 📂view
	 ┣ 📂admin
	 ┣ 📂biz
         ┃ ┣ 📂account
         ┃ ┣ 📂common
         ┃ ┣ 📂product
         ┃ ┣ 📂reservation
	 ┣ 📂cs
	 ┣ 📂error
	 ┣ 📂layout
 	 ┣ 📂main
	 ┣ 📂member
	 ┣ 📂party
	 ┣ 📂patment
	 ┗ 📂product


  
  
```

# 2️⃣ 프로젝트 개요
세상의 모든 장소를 클라이언트 니즈에 맞게 공유하고 싶은 저희의 염원 / 목적을 반영


# 3️⃣ 기능 구분 


# 4️⃣ ERD & 테이블 명세서
![image](https://github.com/Kira7124/PlaceStation/assets/113073333/8ecb1e75-76db-4dbf-9a4c-dd85b999b6af)


%%%%%%%%%%%%%%%%%%%%%%%%%%% 여기서 부터 추가 진수씨 한테 받은 코드


<h2 tabindex="-1" dir="auto"><a id="user-content--my-stack" class="anchor" aria-hidden="true" tabindex="-1" href="#-my-stack"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"></path></svg></a>💻 My Stack</h2>
<div class= "container">
<img alt="JavaScript" src="https://camo.githubusercontent.com/0d61458680d0251da6e466fb5e30a5650d15d0239c68482920d00de83961daa4/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a617661536372696970742d4637444631452e7376673f267374796c653d666f722d7468652d6261646765266c6f676f3d4a617661536372697074266c6f676f436f6c6f723d626c61636b" data-canonical-src="https://img.shields.io/badge/JavaScriipt-F7DF1E.svg?&amp;style=for-the-badge&amp;logo=JavaScript&amp;logoColor=black" style="max-width: 100%;">

<img src="https://img.shields.io/badge/h2-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/spring-7FFF00?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/springboot-006400?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/springsecurity-008B8B?style=for-the-badge&logo=springsecurity&logoColor=white"><br>
<img src="https://img.shields.io/badge/github-a9a9a9?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/javascript-4b0082?style=for-the-badge&logo=eclipseide&logoColor=white">
<img src="https://img.shields.io/badge/dbeaver-fffacd?style=for-the-badge&logo=dbeaver&logoColor=black">
<img src="https://img.shields.io/badge/bootstrap-ba55d3?style=for-the-badge&logo=bootstrap&logoColor=black">
<img src="https://img.shields.io/badge/html5-ffa07a?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css3-afeeee?style=for-the-badge&logo=html5&logoColor=white"><br>
<img src="https://img.shields.io/badge/gradle-ffa07a?style=for-the-badge&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/jquery-4169e1?style=for-the-badge&logo=jquery&logoColor=white">




</div>


<a href="https://github.com/anuraghazra/github-readme-stats">
    <img src="https://github-readme-stats.vercel.app/api/top-langs/?username=Kira7124&layout=donut&show_icons=true&theme=material-palenight&hide_border=true&bg_color=20232a&icon_color=58A6FF&text_color=fff&title_color=58A6FF&count_private=true&exclude_repo=Face-Transfer-Application" width=38% />
</a>    
<a href="https://github.com/anuraghazra/github-readme-stats">
  <img src="https://github-readme-stats.vercel.app/api?username=Kira7124&show_icons=true&theme=material-palenight&hide_border=true&bg_color=20232a&icon_color=58A6FF&text_color=fff&title_color=58A6FF&count_private=true" width=56% />
</a>
<a href="https://github.com/ashutosh00710/github-readme-activity-graph">
    <img src="https://github-readme-activity-graph.vercel.app/graph?username=Kira7124&theme=react-dark&bg_color=20232a&hide_border=true&line=58A6FF&color=58A6FF" width=94%/>
</a>



6️⃣ 주요 기능

<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/a3b9ebb9-0b17-4b66-a857-4b0094a8f9d5">
</p>
<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/8008563a-b47b-43e8-b81a-a658cb97dc39">
</p>
<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/3aa74f74-f3ef-4c48-aa7c-443bf9175a33">
</p>
<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/af9a5b55-d87a-4b42-a118-c4ba6d48eae1">
</p>
<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/d9a91885-eab8-4e57-b6ab-e954f5846e67">
</p>

<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/2b65ad6b-519e-4633-bfaf-056b58887cb4">
</p>
<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/0576fb6a-4eab-404d-86bb-237f84008ebb">
</p>
<p>
<img src="https://github.com/Kira7124/PlaceStation/assets/89882482/d0cba144-287b-4495-bf3d-c495fada4123">
</p>



























