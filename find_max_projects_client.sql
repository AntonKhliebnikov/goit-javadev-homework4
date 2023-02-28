SELECT client_id, COUNT(id) FROM project GROUP BY client_id HAVING COUNT(id) IN(
  SELECT COUNT(id) FROM project
  GROUP BY client_id
  ORDER BY COUNT(id) DESC
  LIMIT 1
);
