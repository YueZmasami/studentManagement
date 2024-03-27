package entity;

/**
 * @author: yue
 * @description:
 */


public class Course {

        private int courseId;
        private String courseName;
        private String semester;

        // Constructors
        public Course() {
        }

        public Course(String courseName, String semester) {
            this.courseName = courseName;
            this.semester = semester;
        }

    public Course(int courseId, String courseName, String semester) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.semester = semester;
    }

    // Getters and setters
        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }


    }


