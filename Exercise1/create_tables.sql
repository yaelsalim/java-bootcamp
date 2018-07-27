CREATE SCHEMA `high-school` ;


CREATE TABLE `high-school`.`student` (
  `registratrion_number` INT NOT NULL,
 
 `first_name` VARCHAR(45) NOT NULL,

  `last_name` VARCHAR(45) NOT NULL,
 
 `date_of_birth` DATE NULL,
  
PRIMARY KEY (`registratrion_number`),
  
UNIQUE INDEX `registratrion_number_UNIQUE` (`registratrion_number` ASC) VISIBLE)

COMMENT = 'This table holds information about the students';


CREATE TABLE `high-school`.`teacher` (
  `id_teacher` INT NOT NULL,
 
 `first_name` VARCHAR(45) NOT NULL,

 `last_name` VARCHAR(45) NOT NULL,
 
 `date_of_birth` DATE NULL,
  
PRIMARY KEY (`id_teacher`),
  
UNIQUE INDEX `id_teacher_UNIQUE` (`id_teacher` ASC) VISIBLE)

COMMENT = 'This table holds information about the teachers';


CREATE TABLE `high-school`.`schedule` (
  `id_schedule` INT NOT NULL,
 
 `day_of_the_week` VARCHAR(45) NOT NULL,
 
 `start_time` TIME NOT NULL,

  `finish_time` TIME NOT NULL,
  
PRIMARY KEY (`id_schedule`),
 
 UNIQUE INDEX `id_schedule_UNIQUE` (`id_schedule` ASC) VISIBLE)

COMMENT = 'This table contains the schedule time for the courses.';


CREATE TABLE `high-school`.`course` (
  `id_course` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,

  `hours_per_week` INT NOT NULL,
 
 `assigned_teacher` INT NOT NULL,
  
 PRIMARY KEY (`id_course`),
  
UNIQUE INDEX `id_course_UNIQUE` (`id_course` ASC) VISIBLE,
 
 INDEX `FK_course_teacher_idx` (`assigned_teacher` ASC) VISIBLE,
   
CONSTRAINT `FK_course_teacher`
    FOREIGN KEY (`assigned_teacher`)
   
                                REFERENCES `high-school`.`teacher` (`id_teacher`)
   
                                 ON DELETE RESTRICT
    ON UPDATE RESTRICT)

COMMENT = 'This table holds information about the courses';


CREATE TABLE `high-school`.`assigned_schedule` (
  `id_course` INT NOT NULL,
 
 `id_schedule` INT NOT NULL,
 
 PRIMARY KEY (`id_course`, `id_schedule`),
 
 INDEX `FK_assigned_schedule_idx` (`id_schedule` ASC) VISIBLE,
  
CONSTRAINT `FK_assigned_course`
    FOREIGN KEY (`id_course`)
   
 REFERENCES `high-school`.`course` (`id_course`)
  
  ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 
 CONSTRAINT `FK_assigned_schedule`
    FOREIGN KEY (`id_schedule`)
 
   REFERENCES `high-school`.`schedule` (`id_schedule`)
   
 ON DELETE NO ACTION
    ON UPDATE NO ACTION)

COMMENT = 'This table contains information about the courses and their assigned schedule time.';


CREATE TABLE `high-school`.`assist_course` (
  `id_student` INT NOT NULL,
  
`id_course` INT NOT NULL,
 
 `partial_exam_1` DOUBLE  NULL,
  
`partial_exam_2` DOUBLE  NULL,
 
 `partial_exam_3` DOUBLE NULL,
 
 `final_exam` DOUBLE  NULL,
 
 PRIMARY KEY (`id_student`, `id_course`),

  INDEX `FK_assist_course_idx` (`id_course` ASC) VISIBLE,

  CONSTRAINT `FK_assist_student`
    FOREIGN KEY (`id_student`)
  
  REFERENCES `high-school`.`student` (`registratrion_number`)
  
  ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  
CONSTRAINT `FK_assist_course`
    FOREIGN KEY (`id_course`)
 
  REFERENCES `high-school`.`course` (`id_course`)
 
   ON DELETE NO ACTION
    ON UPDATE NO ACTION)

COMMENT = 'This table contains information about the students that assist the courses';

