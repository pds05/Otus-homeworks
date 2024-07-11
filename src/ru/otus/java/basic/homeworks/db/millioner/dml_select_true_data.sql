select * from questions q, answers a 
where q.id = a.question_id and a.is_true = true;