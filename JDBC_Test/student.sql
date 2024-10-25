CREATE OR REPLACE PROCEDURE get_students_by_major(
  p_major_no IN VARCHAR2,                 -- 입력 파라미터: 전공 번호
  p_student_cursor OUT SYS_REFCURSOR      -- 출력 REF CURSOR
) IS
BEGIN
  -- REF CURSOR를 열고 쿼리 실행
  OPEN p_student_cursor FOR
    SELECT STD_NO, STD_NAME, STD_SCORE, STD_GENDER 
    FROM C##SCOTT.STUDENT
    WHERE MAJOR_NO = p_major_no;
END;
