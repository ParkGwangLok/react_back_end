DROP TABLE public.tb_user;

CREATE TABLE public.tb_user (
	user_id varchar NOT NULL,
	user_pw varchar NOT NULL,
	user_nm varchar NOT NULL,
	user_email varchar NULL,
	del_yn varchar NOT NULL DEFAULT 'N',
    reg_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP, -- 생성 시간
    upd_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP  -- 수정 시간
);

INSERT INTO public.tb_user
(user_id, user_pw, user_nm, user_email)
VALUES('klpark79', '6022', '박광록', 'klpark79@naver.com');

-----------------------------------------------------------------------------------------------------------------
DROP TABLE tb_menu;

CREATE TABLE tb_menu (
    menu_id VARCHAR PRIMARY KEY,       -- 메뉴 ID (자동 증가)
    menu_name VARCHAR NOT NULL, -- 메뉴 이름
    parent_menu_id VARCHAR,              -- 상위 메뉴 ID
    url VARCHAR,                -- 메뉴 URL 또는 경로
    order_index INT NOT NULL,        -- 메뉴 표시 순서
	del_yn varchar NOT NULL DEFAULT 'N',
    reg_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP, -- 생성 시간
    upd_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP  -- 수정 시간
);

-- parent_menu_id가 존재할 경우 menu_id를 참조하도록 외래 키 설정
--ALTER TABLE tb_menu
--ADD CONSTRAINT fk_parent_menu
--FOREIGN KEY (parent_menu_id)
--REFERENCES tb_menu (menu_id)
--ON DELETE CASCADE;

--INSERT INTO tb_menu (menu_name, parent_menu_id, url, order_index) VALUES
--('Home', NULL, '/home', 1)
--,('About Us', NULL, '/about', 2)
--,('Services', NULL, '/services', 3)
--,('Web Development', 3, '/services/web', 1)
--,('SEO', 3, '/services/seo', 2)
--,('Contact', NULL, '/contact', 4)
--;
--
--INSERT INTO tb_menu (menu_name, parent_menu_id, url, order_index) VALUES
--('test2', 3, '/services/test', 3)
--;


INSERT INTO tb_menu (menu_id, menu_name, parent_menu_id, url, order_index)
VALUES 
('HOME', 'Home', NULL, '/home', 1),
('ABOUT_US', 'About Us', NULL, '/about', 2),
('SERVICE', 'Services', NULL, '/services', 3),
('WEB_DEV', 'Web Development', 'SERVICE', '/services/web', 1),
('SEO', 'SEO', 'SERVICE', '/services/seo', 2),
('CONTACT', 'Contact', NULL, '/contact', 4);

INSERT INTO tb_menu (menu_id, menu_name, parent_menu_id, url, order_index) VALUES
('TEST','test', 'SERVICE', '/services/test', 3)
;

update
tb_menu
set 
parent_menu_id = 'SERVICE'
where 1=1
and menu_id = 'test2'
;

delete from tb_menu where menu_id in ('test2', 'TEST')
;

-----------------------------------------------------------------------------------------------------------------
DROP TABLE tb_role;

CREATE TABLE tb_role (
    role_id VARCHAR PRIMARY KEY,           -- 역할 ID (자동 증가)
    role_name VARCHAR , -- 역할 이름 (고유, 예: Admin, User)
    description TEXT,                     -- 역할 설명
	del_yn varchar NOT NULL DEFAULT 'N',
    reg_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP, -- 생성 시간
    upd_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP  -- 수정 시간
);

INSERT INTO public.tb_role (role_id, role_name, description) values ('ADMIN', 'Admin', 'Admin 권한');
INSERT INTO public.tb_role (role_id, role_name, description) values ('USER', 'User', 'User 권한');
-----------------------------------------------------------------------------------------------------------------
DROP TABLE tb_role_user;

CREATE TABLE tb_role_user (
    role_id VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
	del_yn VARCHAR NOT NULL DEFAULT 'N',
    reg_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP,
    upd_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (role_id, user_id)
);

INSERT INTO tb_role_user (role_id, user_id) values ('ADMIN', 'klpark79');
-----------------------------------------------------------------------------------------------------------------
DROP TABLE tb_role_menu;

CREATE TABLE tb_role_menu (
    role_id VARCHAR NOT NULL,
    menu_id VARCHAR NOT NULL,
	del_yn VARCHAR NOT NULL DEFAULT 'N',
    reg_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP,
    upd_date TIMESTAMP NOT null DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (role_id, menu_id)
);

--INSERT INTO tb_role_menu (role_id, menu_id) values
--('ADMIN', 1)
--,('ADMIN', 2)
--,('ADMIN', 3)
--,('ADMIN', 4)
--,('ADMIN', 5)
--,('ADMIN', 6)
--,('USER', 1)
--,('USER', 2)
--,('USER', 3)
--,('USER', 5)
--,('USER', 6)
--;

INSERT INTO tb_role_menu (role_id, menu_id) values
('ADMIN', 'HOME')
,('ADMIN', 'ABOUT_US')
,('ADMIN', 'SERVICE')
,('ADMIN', 'WEB_DEV')
,('ADMIN', 'SEO')
,('ADMIN', 'CONTACT')
,('ADMIN', 'TEST')
,('USER', 'HOME')
,('USER', 'ABOUT_US')
,('USER', 'SERVICE')
,('USER', 'WEB_DEV')
,('USER', 'CONTACT')
;
-----------------------------------------------------------------------------------------------------------------
CREATE TABLE RECURSIVE_BOOK(
    BOOK_ID INTEGER NOT NULL,
    PARENT_ID INTEGER,
    BOOK_NAME CHARACTER VARYING(20) NOT NULL,
    BOOK_QTY INTEGER,
	CONSTRAINT BOOK_KEY PRIMARY KEY (BOOK_ID));

INSERT INTO RECURSIVE_BOOK VALUES (101, null, '도서', 1);
INSERT INTO RECURSIVE_BOOK VALUES (102, 101, '과학책', 1);
INSERT INTO RECURSIVE_BOOK VALUES (103, 101, '역사책', 1);
INSERT INTO RECURSIVE_BOOK VALUES (104, 101, '잡지', 1);
INSERT INTO RECURSIVE_BOOK VALUES (105, 102, '달나라_여행', 1);
INSERT INTO RECURSIVE_BOOK VALUES (106, 102, '내셔널지오그래픽_동물사전', 1);
INSERT INTO RECURSIVE_BOOK VALUES (107, 102, '블랙홀은_존재하는가', 1);
INSERT INTO RECURSIVE_BOOK VALUES (108, 106, '독화살개구리의_생존', 1);
INSERT INTO RECURSIVE_BOOK VALUES (109, 106, '오리너구리의_비밀', 1);
INSERT INTO RECURSIVE_BOOK VALUES (110, 104, '90년대_오렌지족_패션', 1);
INSERT INTO RECURSIVE_BOOK VALUES (111, 103, '6.25전쟁의_진실', 1);

WITH RECURSIVE search_book(
	BOOK_ID, 
 	PARENT_ID, 
 	BOOK_NAME, 
 	BOOK_QTY,
   	LEVEL, 
   	PATH, 
   	cycle
) AS (
	select
		book.BOOK_ID,
		book.PARENT_ID,
		book.BOOK_NAME,
		book.BOOK_QTY,
		0,
		array[book.BOOK_ID],
		false
	from
		RECURSIVE_BOOK book
	where
		book.PARENT_ID is null
	union all
	select
		book.BOOK_ID,
		book.PARENT_ID,
		book.BOOK_NAME,
		book.BOOK_QTY,
		level + 1,
		path || book.BOOK_ID,
		book.BOOK_ID = any(path)
	from
		RECURSIVE_BOOK book,
		search_book sb
	where
		book.PARENT_ID = sb.BOOK_ID
	and not cycle
)
SELECT BOOK_ID, PARENT_ID, lpad('', LEVEL) || BOOK_NAME, BOOK_QTY, LEVEL, PATH
	FROM search_book ORDER BY path;
-----------------------------------------------------------------------------------------------------------------          