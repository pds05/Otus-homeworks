insert into questions (text) values ('Какое насекомое вызвало короткое замыкание в ранней версии вычислительной машины, тем самым породив термин «компьютерный баг?');
insert into questions (text) values ('Под каким названием известна единица с последующими ста нулями?');
insert into questions (text) values ('Какой химический элемент составляет более половины массы тела человека?');
insert into questions (text) values ('Какого цвета крайнее правое кольцо в олимпийской символике?');
insert into questions (text) values ('Что изображено на заднем плане картины Леонардо да Винчи «Мона Лиза»?');

insert into answers (text, question_id, is_true) values 
 ('Мотылек', (select id from questions where text like 'Какое насекомое вызвало короткое замыкание в ранней версии вычислительной машины, тем самым породив термин «компьютерный баг?' limit 1) , true),
 ('Таракан', (select id from questions where text like 'Какое насекомое вызвало короткое замыкание в ранней версии вычислительной машины, тем самым породив термин «компьютерный баг?' limit 1) , false),
 ('Муха', (select id from questions where text like 'Какое насекомое вызвало короткое замыкание в ранней версии вычислительной машины, тем самым породив термин «компьютерный баг?' limit 1) , false),
 ('Японский хрущик', (select id from questions where text like 'Какое насекомое вызвало короткое замыкание в ранней версии вычислительной машины, тем самым породив термин «компьютерный баг?' limit 1) , false);
 
insert into answers (text, question_id, is_true) values 
 ('Гугол', (select id from questions where text like 'Под каким названием известна единица с последующими ста нулями?' limit 1) , true),
 ('Мегатрон', (select id from questions where text like 'Под каким названием известна единица с последующими ста нулями?' limit 1) , false),
 ('Гигабит', (select id from questions where text like 'Под каким названием известна единица с последующими ста нулями?' limit 1) , false),
 ('Наномоль', (select id from questions where text like 'Под каким названием известна единица с последующими ста нулями?' limit 1) , false);
 
insert into answers (text, question_id, is_true) values 
 ('Углерод', (select id from questions where text like 'Какой химический элемент составляет более половины массы тела человека?' limit 1) , false),
 ('Кальций', (select id from questions where text like 'Какой химический элемент составляет более половины массы тела человека?' limit 1) , false),
 ('Кислород', (select id from questions where text like 'Какой химический элемент составляет более половины массы тела человека?' limit 1) , true),
 ('Железо', (select id from questions where text like 'Какой химический элемент составляет более половины массы тела человека?' limit 1) , false);
 
insert into answers (text, question_id, is_true) values 
 ('Красное', (select id from questions where text like 'Какого цвета крайнее правое кольцо в олимпийской символике?' limit 1) , true),
 ('Синее', (select id from questions where text like 'Какого цвета крайнее правое кольцо в олимпийской символике?' limit 1) , false),
 ('Желтое', (select id from questions where text like 'Какого цвета крайнее правое кольцо в олимпийской символике?' limit 1) , false),
 ('Зеленое', (select id from questions where text like 'Какого цвета крайнее правое кольцо в олимпийской символике?' limit 1) , false);
 
insert into answers (text, question_id, is_true) values 
 ('Драпировка', (select id from questions where text like 'Что изображено на заднем плане картины Леонардо да Винчи «Мона Лиза»?' limit 1) , false),
 ('Пейзаж', (select id from questions where text like 'Что изображено на заднем плане картины Леонардо да Винчи «Мона Лиза»?' limit 1) , true),
 ('Город', (select id from questions where text like 'Что изображено на заднем плане картины Леонардо да Винчи «Мона Лиза»?' limit 1) , false),
 ('Стадо овец', (select id from questions where text like 'Что изображено на заднем плане картины Леонардо да Винчи «Мона Лиза»?' limit 1) , false);