begin;

create table task (
    id bigserial not null constraint task_pkey primary key,
	guid varchar(255) not null constraint uk_task_guid unique,
	version bigint,
	name varchar(255),
	created_at timestamp,
	description varchar(255),
	priority varchar(255),
	status varchar(255)
);

commit;
