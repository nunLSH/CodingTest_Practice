-- 각 동물의 아이디와 이름, 들어온 날짜1를 조회하는 SQL문
-- 아이디 순 조회
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') as 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID