INSERT INTO worker
	(name, birthday, level, salary)
VALUES
	('Anton', '1986-02-02', 'Senior', 4000),
	('Kris', '1996-01-21', 'Middle', 2500),
	('Polina', '1984-05-18', 'Senior', 5500),
	('Anfisa', '1984-04-30', 'Senior', 3000),
	('Tanya', '1989-05-17', 'Junior', 1100),
	('Sasha', '1999-01-05', 'Junior', 1100),
	('Max', '1993-06-30', 'Middle', 2000),
	('Alyona', '1992-05-19', 'Middle', 1900),
	('Ivan', '2000-06-15', 'Trainee', 850),
	('Masha', '1989-10-10', 'Trainee', 850);

INSERT INTO client
	(name)
VALUES
	('Peter Jackson'),
	('Michelle Williams'),
	('Ernest Hemingway'),
	('Paul Atreides'),
	('Tim Cook');

INSERT INTO project
	(client_id, start_date, finish_date)
VALUES
	(3, '2022-11-11', '2022-12-22'),
	(3, '2022-01-01', '2022-05-31'),
	(3, '2021-07-25', '2022-06-11'),
	(5, '2020-10-17', '2021-05-05'),
	(2, '2022-02-02', '2022-12-12'),
	(2, '2018-05-09', '2025-05-25'),
	(1, '2022-07-03', '2026-09-09'),
	(4, '2023-02-08', '2024-04-09'),
	(4, '2023-02-02', '2024-02-02'),
	(3, '2019-06-04', '2023-06-05');

INSERT INTO project_worker
	(project_id, worker_id)
VALUES
	(1, 6),
	(2, 9),
	(3, 8),
	(4, 10),
	(5, 2),
	(6, 4),
	(7, 1),
	(8, 5),
	(9, 7),
	(10, 3);