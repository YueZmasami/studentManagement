# studentManagement
this is an application which simulates Canvas
it has the following functions : 
✨Admin
Admins will have a dashboard where they have the option to:
a. Create new users (students or teachers) and set all relevant information e.g, username,
password, name, phone etc.
b. Create new courses and set all relevant information e.g, course ID, course name, semester
etc

💗Student
1- Students will have the option to log in to the system using their username and password.
2- On successful login, students will see the courses the are enrolled in. If the student is not enrolled in any course, there should be an option where the student can see a list of all available courses
and register for a particular course.
3- After successful enrollment, when the students click on a course, they should be able to see their
assessment marks, in each activity marked by the instructor in that course.

💍 Teacher
1- Teachers will have the option to log in to the system using their username and password.
2- On successful login, teachers will see the list of assigned courses. If no course is assigned, there should be an option where they can see a list of all available courses and register to teach a
particular course.
3- When the teacher selects a course, the system displays a list of students enrolled in that course. 4- When the teacher selects a student, the system allows to enter marks for assessments for the
selected student and in the selected course
• There should be three assessments: 1 quiz, 1 assignment, and 1 final exam.
😄The database can have 4 tables.
User Table
It contains information about the users e.g., unique user ID, password, first name, last name, phone, role (student or teacher) etc.
Course Table
It contains information about the courses e.g., unique course ID, course name, semester etc.
User Course Table
It contains information about which users are associated with which courses. e.g., unique ID, user ID, course ID
Assessment Table
It contains marks for quiz, assignment and final exam for each student in each course
