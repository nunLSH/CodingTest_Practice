-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
-- 리뷰 개수를 비교해서 가장 많은 수를 가진 회원 이름 필요

SELECT
    MP.MEMBER_NAME, 
    R.REVIEW_TEXT, 
    TO_CHAR(R.REVIEW_DATE, 'YYYY-MM-DD') REVIEW_DATE
FROM MEMBER_PROFILE MP
JOIN REST_REVIEW R
    ON MP.MEMBER_ID = R.MEMBER_ID
WHERE MP.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM (
        SELECT 
            MEMBER_ID, 
            ROW_NUMBER() OVER (
                ORDER BY COUNT(*) DESC
            ) AS RN
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        )
    WHERE RN = 1
)
ORDER BY R.REVIEW_DATE ASC, R.REVIEW_TEXT ASC 