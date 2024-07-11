CREATE TABLE public.questions (
	id int4 GENERATED ALWAYS AS IDENTITY NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT questions_pk PRIMARY KEY (id)
);

CREATE TABLE public.answers (
	id int4 GENERATED ALWAYS AS IDENTITY NOT NULL,
	"text" varchar NOT NULL,
	question_id int4 NOT NULL,
	is_true bool NULL,
	CONSTRAINT answers_pk PRIMARY KEY (id)
);