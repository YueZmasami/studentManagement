package entity;

/**
 * @author: yue
 * @description:
 */


public class Assessment {



        private int assessmentID;
        private int userID;
        private int courseID;
        private int quizMarks;
        private int assignmentMarks;
        private int finalExamMarks;

        public Assessment() {
        }

        public Assessment(int assessmentID, int userID, int courseID, int quizMarks, int assignmentMarks, int finalExamMarks) {
            this.assessmentID = assessmentID;
            this.userID = userID;
            this.courseID = courseID;
            this.quizMarks = quizMarks;
            this.assignmentMarks = assignmentMarks;
            this.finalExamMarks = finalExamMarks;
        }

        public int getAssessmentID() {
            return assessmentID;
        }

        public void setAssessmentID(int assessmentID) {
            this.assessmentID = assessmentID;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public int getCourseID() {
            return courseID;
        }

        public void setCourseID(int courseID) {
            this.courseID = courseID;
        }

        public int getQuizMarks() {
            return quizMarks;
        }

        public void setQuizMarks(int quizMarks) {
            this.quizMarks = quizMarks;
        }

        public int getAssignmentMarks() {
            return assignmentMarks;
        }

        public void setAssignmentMarks(int assignmentMarks) {
            this.assignmentMarks = assignmentMarks;
        }

        public int getFinalExamMarks() {
            return finalExamMarks;
        }

        public void setFinalExamMarks(int finalExamMarks) {
            this.finalExamMarks = finalExamMarks;
        }

        @Override
        public String toString() {
            return "Assessment{" +
                    "assessmentID=" + assessmentID +
                    ", userID=" + userID +
                    ", courseID=" + courseID +
                    ", quizMarks=" + quizMarks +
                    ", assignmentMarks=" + assignmentMarks +
                    ", finalExamMarks=" + finalExamMarks +
                    '}';
        }
    }





