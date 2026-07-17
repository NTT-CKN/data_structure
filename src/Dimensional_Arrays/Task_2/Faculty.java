package Dimensional_Arrays.Task_2;

import java.util.Arrays;

public class Faculty {
    private String name;
    private String address;
    private Course[] courses;
    public Faculty(String name, String address, Course[] courses) {
        this.name = name;
        this.address = address;
        this.courses = courses;
    }
    // 2
    public boolean contains(Student student) {
        for (Course c : courses) {
            if(c.checkStuentInCourse(student))
                return true;
        }
        return false;
    }
    // 3
    public int countStudentInCourseByYear(String idCourse,int year){
        int count = 0;
        for(Course c : courses){
            if(c.getId().equalsIgnoreCase(idCourse)){
                count = c.countStudentInCourse(year);
            }
        }
        return count;
    }
    // 4
    public int countStudentInFacultyByYear(int year) {
        int count = 0;
        Student[] students = new Student[100];
        int size = 0;
        for (Course c : courses) {
            for (Student s : c.getStudents()) {
                if (s.getYear() == year && !checkExist(students,size,s)) {
                    count++;
                    students[size] = s;
                    size++;
                }
            }
        }
        return count;
    }

    private boolean checkExist(Student[] students, int size, Student s) {
        for(int i = 0; i<size;i++){
            if(students[i].getId().equalsIgnoreCase(s.getId())){
                return true;
            }
        }
        return false;
    }
    public Course getHigestCourse() {
        Course higestCourse = null;
        int max = 0;
        for(int i=0;i<courses.length;i++){
            if(courses[i].getCount()>max){
                max = courses[i].getCount();
                higestCourse = courses[i];
            }
        }
        return higestCourse;
    }
    public Course[] getCoursesByLecturer(String lecturer) {
        int size = 0;
        Course[] result = new Course[courses.length];
        for(Course c : courses){
            if(c.getLecture().equalsIgnoreCase(lecturer)){
                result[size] = c;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }
    static void main() {
        Student st1 = new Student("001","Nguyễn Trọng Tín", 2005);
        Student st2 = new Student("002","Trần Nguyễn Gia Hân", 2005);
        Student st3 = new Student("003","Nguyễn Trường Vũ", 2005);
        Student st4 = new Student("004","Nguyễn Trọng Tiến", 2007);
        Student st5 = new Student("005","Nguyễn Ngọc Meow", 2006);
        Student st6 = new Student("006","Bún Bò Huế", 2007);
        Student st7 = new Student("007","Superman", 2009);
        Student st8 = new Student("008","batman", 2005);

        Student[] sts1 = {st1,st2,st3,st4,st5,st6,st7};
        Student[] sts2 = {st4,st5,st6,st7,st1,st2,st3,st8};
        Student[] sts3 = {st1,st2,st7,st8};
        Course course1 = new Course("01","Lập trình mạng","Thực hành",sts1,"Phạm Văn Tính");
        Course course2 = new Course("02", "Lập trình mobile", "Thực hành", sts3,"Võ Tấn Toàn");
        Course course3 = new Course("03","Mạng máy tính", "Lý thuyết", sts2,"Phạm Văn Tính");
        Course[] courses = {course1,course2,course3};
        Course[] courses1 = {course1,course2};
        Faculty fa1 = new Faculty("Công nghệ thông tin", "Đại Học Nông Lâm HCM", courses);
        Faculty fa2 = new Faculty("Công nghệ điện tử","Đại Học Nông Lâm HCM", courses1);
        System.out.println("Sinh viên có đăng khóa học không:");
        System.out.println(fa1.contains(st8));
        System.out.println("Đếm số lượng sinh viên đã đăng ký khóa học trên năm nhất đinh: ");
        System.out.println(fa1.countStudentInCourseByYear("01",2007));
        System.out.println("Đếm số lượng sinh viên trong khoa trên năm nhất đinh: ");
        System.out.println(fa1.countStudentInFacultyByYear(2005));
        System.out.println("Khóa học có số lượng sinh viên đăng ký nhiều nhất: ");
        System.out.println(fa1.getHigestCourse());
        System.out.println("Tất cả khóa học do một giảng viên cố định dạy: ");
        System.out.println(Arrays.toString(fa1.getCoursesByLecturer("Phạm Văn Tính")));
    }
}
