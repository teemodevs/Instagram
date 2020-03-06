insert into board (author, content, createdDate, modifiedDate) values ('test1@gmail.com', '테스트1의 본문1', now(), now());
insert into board (author, content, createdDate, modifiedDate) values ('test1@gmail.com', '테스트1의 본문2', now(), now());
insert into board (author, content, createdDate, modifiedDate) values ('test2@gmail.com', '테스트2의 본문1', now(), now());
insert into board (author, content, createdDate, modifiedDate) values ('test2@gmail.com', '테스트2의 본문2', now(), now());
insert into board (author, content, createdDate, modifiedDate) values ('test3@gmail.com', '테스트3의 본문1', now(), now());
insert into board (author, content, createdDate, modifiedDate) values ('test1@gmail.com', '테스트1의 본문3', now(), now());
insert into board (author, content, createdDate, modifiedDate) values ('test2@gmail.com', '테스트2의 본문3', now(), now());
/* resources 디렉토리 아래에 있는 schema.sql 파일이나 data.sql파일, 하이버네이트는 import.sql은 자동 실행시켜준다.
 * schema = ddl, data = dml
 * 여기서는 my-data.sql이기 때문에 .yml에서 이 파일의 sql을 실행시키도록 해야 한다.
 * 뿐만아니라, 원래 이 기능은 개발 단계에서 h2 database 같은 임베디드 DB에서만 실행된다.
 * 따라서 모든 DB에서 사용할 것 같으면 yml에서 이 기능을 활성화 시켜야 한다.
 */