SELECT CONCAT(t.first_name,' ', t.last_name) AS 'Teacher :',
  
    '' AS 'Schedule :',
	
CONCAT(s.day_of_the_week,' ',s.start_time,' ',s.finish_time , ':', c.name) AS ''
	

	FROM `high-school`.`course` c JOIN `high-school`.`teacher` t ON (c.assigned_teacher = t.id_teacher)
    
       JOIN  `high-school`.`assigned_schedule` asg ON (c.id_course = asg.id_schedule)
	
      JOIN `high-school`.`schedule` s ON (asg.id_schedule = s.id_schedule)
	
GROUP BY t.id_teacher \G;