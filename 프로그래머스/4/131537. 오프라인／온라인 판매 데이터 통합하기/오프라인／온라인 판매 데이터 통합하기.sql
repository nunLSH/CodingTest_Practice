-- 2022년 3월
-- 오프라인/온라인 상품 판매 데이터의 판매 날짜, 상품ID, 유저ID, 판매량
-- OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL
-- 판매일 > 상품 ID > 유저 ID를 기준으로 오름차순(

SELECT 
    TO_CHAR(SALES_DATE, 'YYYY-MM-DD') SALES_DATE, 
    PRODUCT_ID, 
    USER_ID,
    SALES_AMOUNT
FROM (
    SELECT 
        SALES_DATE, 
        PRODUCT_ID, 
        USER_ID, 
        SALES_AMOUNT
    FROM ONLINE_SALE
    UNION ALL
    SELECT 
        SALES_DATE, 
        PRODUCT_ID, 
        NULL AS USER_ID, 
        SALES_AMOUNT
    FROM OFFLINE_SALE)
WHERE SALES_DATE >= DATE '2022-03-01'
    AND SALES_DATE < DATE '2022-04-01'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID