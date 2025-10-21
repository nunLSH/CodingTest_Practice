-- 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
-- 컬럼명은 '진료과 코드', '5월예약건수'로 지정
-- 진료과별 예약한 환자 수를 기준으로 오름차순 정렬
-- 진료과별 예약한 환자 수를 기준으로 오름차순 정렬
SELECT 
    MCDP_CD as "진료과코드", 
    COUNT(MCDP_CD) as "5월예약건수"
FROM APPOINTMENT
WHERE MONTH(APNT_YMD) = 5
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD), MCDP_CD