-- 중성화 여부를 O, X로 표시해서 ANIMAL_ID, NAME, 중성화 여부 조회
SELECT 
    ANIMAL_ID, 
    NAME, 
    CASE
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' 
        OR SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
    END AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID