CREATE TABLE IF NOT EXISTS worker (
	id IDENTITY PRIMARY KEY,
	name VARCHAR NOT NULL
    CONSTRAINT ck_name_worker_length
    CHECK(char_length(name) >= 2 AND char_length(name) <= 1000),
	birthday DATE
	CHECK(birthday > '1900-01-01'),
	level VARCHAR(10) NOT NULL,
	salary INT CHECK
		(salary >= 100 and salary <= 100000)
);

ALTER TABLE worker ADD CONSTRAINT level_enum_values CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior'));

CREATE TABLE IF NOT EXISTS client (
	id IDENTITY PRIMARY KEY,
	name VARCHAR NOT NULL
    CONSTRAINT ck_name_client_length
    CHECK(char_length(name) >= 2 AND char_length(name) <= 1000)
);

CREATE TABLE IF NOT EXISTS project (
	id IDENTITY PRIMARY KEY,
	client_id BIGINT,
	start_date DATE,
	finish_date DATE
);

CREATE TABLE IF NOT EXISTS project_worker (
	project_id BIGINT,
	worker_id BIGINT,
	PRIMARY KEY (project_id, worker_id),
	FOREIGN KEY (project_id) REFERENCES project(id),
	FOREIGN KEY (worker_id) REFERENCES worker(id)
);