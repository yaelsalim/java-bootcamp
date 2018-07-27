SELECT  c.name AS 'Course: ',

	CONCAT(t.first_name,' ', t.last_name) AS 'Teacher :',
	
        CONCAT(s.first_name,' ',s.last_name ) AS 'Student :'
	

	FROM `high-school`.`course` c JOIN `high-school`.`teacher` t ON (c.assigned_teacher = t.id_teacher)
   
        JOIN  `high-school`.`assist_course` atc ON (c.id_course = atc.id_course)

	JOIN `high-school`.`student` s ON (atc.id_student = s.registratrion_number)

	GROUP BY c.name \G;