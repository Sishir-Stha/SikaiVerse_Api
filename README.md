# Sikai Verse API

A backend service for LMS of the Course Management System. This project is currently underdevelopment

#### Status : Developing

#### Project Stage : Early Stages of foundation

# TechStack :
         - Java 21 
        
         - Spring Boot
        
         - Maven

# Current Features :
    
    1. Project setup complete
    2. Project structure complete
    3. JWT is ready and implemented in Login 
    4. Authentication part is ready i.e login and SignUp


# Activity Log :

### 2025/12/07 
    
- Project Started or initialized and pushed to the Git and created a seperate branch for development
    
### 2025/12/08

- Project Structure is done ( Controller > Service > Repository ) 
- Common, Constants, Mapper, Entity , DTO, ErrorMessage are done
- Starting from Login request and response DTO
- Lambok and jpa and jakarta dependencies added

### 2025/12/10

- Connection with Database is established and User Table is Created 
- Login and Signup is done with database and endpoints are ready 
- Authentication part is finished   
- All the Config and security has been created (JWT & Web config and Security config )


### 2025/12/12

- Added Get and Insert endpoint for the Courses 
- Get endpoint is for the explore page and insert is for admin page 
- Need to add edit endpoint now 
- Also changed the response format for every endpoint including auth and course

### 2025/12/15

- Changed the project structure a little bit
- Added the getDashboard endpoint which gives all the data for student dashboard

### 2026/12/17

- added enpoint for course tabs page for the students
- added the endpoint for the dashboard for instructors 
- make project structure for the course page

### 2025/12/20

- added the endpoint for instructor course page
- added the endpoint for the admin dashboard and course page 
- revised the project structure a little bit ( Utility package will contain the common endpoints )

### 2025/12/21

- change the project structure again removed utility and added shared for shared endpoints
- completed discussion endpoint
- added user endpoint in the admin controller package
- added enpoint for discussion and reply like (Night code last commit of day)

### 2025/12/23

- added the endpoint for the edit course page 
    - faced error or difficulty and have to clear some concept of map and Linked Hash Map since the data format was bit complicated
- make the function to insert different things like user,course, modules in database

### 2025/12/25

- make change according to the database the procedure names are changed

### 2025/12/28

- changed few names and added new endpoint in privileged to add the course

### 2026/12/30
- changed few things like @Id in the entity class of admin and student dashboard for the error repetation
- added userid in the auth response for student and instructor endpoint required in frontend 

### 2026/01/02
- added the catgeory in the landing browse or course list entity and dto
- making minor changes for debuging 

### 2026/01/03
- adding the profile section for the profile page of student, admin and instructor

### 2026/01/04
- adding the update profile section in the shared/all and admin/user 

### 2026/01/07
- added the admin course list data for the course list in the discussion tab of the instructor which displays only assigned course

### 2026/01/10
- added the admin course list data for the course list in the discussion tab of the admin which displays all the course 

### 2026/01/14
- added the get discussion post and replies for any course id in shared/all

### 2026/01/16
- added the endpoint for the course details page for the student 
- added new feilds i.e no of lesson in the admin and instructor discussion list and few other changes

### 2026/01/23
- added the endpoint for side panel for the lesson details page for the student 
- added the function in the database for it 

### 2026/01/26
- added the endpoint for the lesson details page for the student
- added and altered the tables for this endpoint in database

### 2026/01/29
-- added the Lesson endpoint for enrollment verification and added the function to the database

### 2026/01/31
-- added the set Inprogress and Set Completed for the lesson to change the status of the lesson once student completed it 

### 2026/02/02
-- added endpoint to edit the course info details only allowed to the instructors and admin

### 2026/02/04
-- added new feild in the user for the UI to show new feild like phone number and address 

### 2026/02/0
-- added new endpoint to insert user for admin only

### 2026/02/0
-- added new endpoint to delete the user for admin only 




