package Dimensional_Arrays.Task_2;

import java.util.Arrays;

public class Course {
    private String id;
    private String title;
    private String type;
    private Student[] students;
    private String lecture;
    public Course(String id, String title, String type, Student[] students, String lecture) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = students;
        this.lecture = lecture;
    }
    public boolean checkStuentInCourse(Student student) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(student.getId())) {
                return true;
            }
        }
        return false;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", students=" + Arrays.toString(students) +
                ", lecture='" + lecture + '\'' +
                '}';
    }

    public int countStudentInCourse(int year) {
        int count = 0;
        for (Student s : students) {
            if (s.getYear() == year) {
                count++;
            }
        }
        return count;
    }


    public int getCount() {
        int count = 0;
        for (Student s : students) {
            count++;
        }
        return count;
    }
}
