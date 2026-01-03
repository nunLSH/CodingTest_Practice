-- 서울에 위치한 식당들
-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회
-- 리뷰 평균점수는 소수점 세 번째 자리에서 반올림
-- 결과는 평균점수를 기준으로 내림차순 정렬 > 즐겨찾기수를 기준으로 내림차순 정렬
SELECT
    RI.REST_ID, 
    RI.REST_NAME, 
    RI.FOOD_TYPE, 
    RI.FAVORITES, 
    RI.ADDRESS, 
    ROUND(AVG(RR.REVIEW_SCORE), 2) SCORE
FROM REST_INFO RI
JOIN REST_REVIEW RR ON RI.REST_ID = RR.REST_ID
WHERE ADDRESS LIKE '서울%'
GROUP BY RI.REST_ID, 
    RI.REST_NAME, 
    RI.FOOD_TYPE, 
    RI.FAVORITES, 
    RI.ADDRESS
ORDER BY SCORE DESC, RI.FAVORITES DESC