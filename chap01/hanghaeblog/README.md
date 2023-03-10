# 항해블로그 백엔드서버 만들기(로그인X)
 - - -
## 🍑 서비스 완성 요구사항
* **전체 게시글 목록 조회**
  * 제목, 작성자명, 작성내용, 작성날짜 조회
  * 작성 날짜 기준 내림차순 정리


* **게시글 작성 API**
  * 제목, 작성자명, 작성내용, 작성날짜 저장
  * 저장된 게시글 Client로 반환


* **선택한 게시글 조회 API**
  * 선택한 게시글의 제목, 작성자명, 작성날짜, 작성내용 조회


* **선택한 게시글 수정 API**
  * 수정을 요청할 때, 수정할 데이터 + 비밀번호 -> 서버에서 비밀번호 일치여부 확인
  * 제목, 작성자명, 작성내용 수정 -> 수정된 게시글 Client에 반환


* **선택한 게시글 삭제 API**
  * 삭제 요청 -> 비밀번호 -> 서버에서 비밀번호 일치 여부 확인
  * 선택한 게시글 삭제 -> Client로 성공했다는 표시 반환
- - -
## 🧸 API 명세서
| 기능        |Method|URL       | Request                                                                                                           | Response                                                                                                                                                                                                                                                                                                                                                                                          |
|-----------|---|----------|-------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 게시글작성     |`POST`|/api/posts| {<br>"title" : "title",<br>"username" : "username",<br>"content" : "content",<br>"password" : "password"<br>}     | {<br>"title" : "말랑이",<br>"username" : "mallang",<br>"content" : "말랑이는 아무것도 몰랑",<br>"id" : 1,<br>"createdAt : "2023-02-21T11:07:30.280917",<br>"modifiedAt" : "2023-02-21T11:07:30.280917"<br>}                                                                                                                                                                                                    |
| 전체게시글목록조회 |`GET`|/api/posts| -                                                                                                                 | {<br>"title" : "말랑말랑",<br>"username" : "mallangmallang",<br>"content" : "말랑몰랑",<br>"id": 2,<br>"createdAt" : "2023-02-21T22:25:40.491027",<br>"modifiedAt" : "2023-02-21T22:25:40.491027"<br>}<br>{<br>"title" : "말랑이",<br>"username" : "mallang",<br>"content" : "말랑이는 아무것도 몰랑",<br>"id" : 1,<br>"createdAt" : "2023-02-21T22:22:56.124135",<br>"modifiedAt" : "2023-02-21T22:22:56.124135"<br>} |
| 선택한게시글조회  |`GET`|/api/post/{id}| -                                                                                                                 | {<br>"title" : "말랑말랑",<br>"username" : "mallangmallang",<br>"content" : "말랑몰랑",<br>"id" : 1,<br>"createdAt" : "2023-02-22T01:23:50.445368",<br>"modifiedAt" : "2023-02-22T01:23:50.445368"<br>}                                                                                                                                                                                                   |
| 선택한게시글수정  |`PUT`|/api/post/{id}| {<br>"title" : "title2",<br>"username" : "username2",<br>"content" : "content2",<br>"password" : "password2"<br>} | {<br>"title" : "말랑",<br>"username" : "mallang",<br>"content" : "말랑말랑"<br>,"id" : 1,<br>"createdAt" : "2023-02-22T03:23:45.779433",<br>"modifiedAt" : "2023-02-22T03:25:09.256132"<br>}                                                                                                                                                                                                            |
| 선택한게시글삭제  |`DELETE`|/api/post/{id}| {<br>"password" : "password"<br>}                                                                                 | {<br>"msg" : "삭제완료!"<br>}                                                                                                                                                                                                                                                                                                                                                                         |
- - -