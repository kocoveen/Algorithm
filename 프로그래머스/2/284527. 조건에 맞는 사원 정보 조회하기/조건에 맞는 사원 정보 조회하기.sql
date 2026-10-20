select a.SCORE, a.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL
from (
    select emp_no, sum(score) as score from HR_GRADE
    group by emp_no, year
    having year = "2022"
    order by score desc limit 1
) a
join HR_EMPLOYEES b
using (EMP_NO)
