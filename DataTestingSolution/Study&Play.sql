-- Creating table

CREATE TABLE StudyPlay (
   studentName VARCHAR2(30) CONSTRAINT stuname_not_null NOT NULL,
   studentRollNo VARCHAR2(10) CONSTRAINT sturollNo_not_null NOT NULL,
   classStudying VARCHAR2(10)CONSTRAINT sclass_not_null NOT NULL,
   age NUMBER,
   fatherName VARCHAR2(30));
   
--Inserting values into table
INSERT ALL
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('RAJAT MISHRA','IETLINF02','XI',17,'PANKAJ MISHRA')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('SUDHEER SHARMA','IETLINF03','IX',15,'SUNDER SHARMA')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('NANCY KAUR','IETLINF04','XII',18,'AK SINGH')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('NANSUMITA SHARMACY','IETLINF05','IV',14,'AJAY SHARMA')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('NANDINI GUPTA','IETLINF06','VII',18,'RAM GUPTA')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('RAM KUMAR','IETLINF07','X',16,'RAMAN KUMMAR')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('SRIMATHI RAJENDRAN','IETLINF02','XII',18,'RAJENDRAN')
INTO StudyPlay(studentName,studentRollNo,classStudying,age,fatherName) VALUES ('NANCY KAUR','IETLINF05','XII',18,'PK SINGH')
SELECT * FROM dual;

--Viewing table contents
SELECT * FROM StudyPlay;

--Updating age 
update studyplay 
set age=22 
where studentName='SRIMATHI RAJENDRAN';

--Total number of students in each class
SELECT classStudying, COUNT (*) as TotalSDatatudent
FROM studyplay 
GROUP BY classStudying; 

--Average age of student in each class
SELECT classStudying, AVG (age) as AverageAge
FROM studyplay 
GROUP BY classStudying; 

--Number of students having same roll number
SELECT studentrollno, count(*) as sameRollNoCount
FROM studyplay 
GROUP BY studentrollno;

--Duplicate name of student from the table
SELECT *
FROM studyplay
WHERE studentName IN (
    SELECT studentName FROM studyplay GROUP BY studentName HAVING COUNT(*) > 1
) 

