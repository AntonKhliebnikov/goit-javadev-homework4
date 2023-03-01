SELECT type, name, birthday FROM (
	 SELECT 'YOUNGEST' AS type, name, birthday FROM worker
     ORDER BY birthday DESC
     LIMIT 1) UNION SELECT type, name, BIRTHDAY FROM (
	 SELECT 'OLDEST' AS type, name, birthday FROM worker
     ORDER BY birthday ASC
     LIMIT 1);