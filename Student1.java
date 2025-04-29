import java.util.ArrayList;
import java.util.List;

class Student_course {
    private String courseName;
    private int marksObtained;

    public Student_course(String courseName, int marksObtained) {
        this.courseName = courseName;
        this.marksObtained = marksObtained;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " | Marks Obtained: " + marksObtained);
    }
}

class Student1{
    private String name;
    private int birthDay, birthMonth, birthYear;
    private List<List<Student_course>> semesters;

    public Student1(String name, String dob) {
        this.name = name;
        this.semesters = new ArrayList<>();

        String[] dobParts = dob.split("-");
        if (dobParts.length == 3) {
            if (dobParts[0].length() == 4) {  
                this.birthYear = Integer.parseInt(dobParts[0]);
                this.birthMonth = Integer.parseInt(dobParts[1]);
                this.birthDay = Integer.parseInt(dobParts[2]);
            } else {  
                this.birthDay = Integer.parseInt(dobParts[0]);
                this.birthMonth = Integer.parseInt(dobParts[1]);
                this.birthYear = Integer.parseInt(dobParts[2]);
            }
        } else {
            System.out.println("Invalid date format. Please use either dd-MM-yyyy or yyyy-MM-dd.");
        }
    }

    public int calculateAge() {
        int currentYear = 2025;
        int currentMonth = 4; 
        int currentDay = 29;

        int age = currentYear - birthYear;
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        return age;
    }


    public void addCourseForSemester(int semesterNumber, String courseName, int marksObtained) {

        while (semesterNumber >= semesters.size()) {
            semesters.add(new ArrayList<>()); 
        }

        Student_course course = new Student_course(courseName, marksObtained);
        semesters.get(semesterNumber).add(course);
    }

    public void displayStudentInfo() {
        int age = calculateAge();
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age + " years");

        for (int semesterNumber = 0; semesterNumber < semesters.size(); semesterNumber++) {
            System.out.println("Semester " + (semesterNumber + 1) + ":");
            for (Student_course course : semesters.get(semesterNumber)) {
                course.displayCourseInfo();
            }
            System.out.println(); 
        }
    }
    public static void main(String[] args) {

        Student1 student1 = new Student1("John Doe", "15-08-2000");

        student1.addCourseForSemester(0, "Mathematics", 85);
        student1.addCourseForSemester(0, "Physics", 90);

        student1.addCourseForSemester(1, "Chemistry", 88);
        student1.addCourseForSemester(1, "Biology", 75);

        student1.displayStudentInfo();

        Student1 student2 = new Student1("Jane Smith", "2002-03-20");

        student2.addCourseForSemester(0, "History", 92);
        student2.addCourseForSemester(0, "Geography", 80);

        student2.addCourseForSemester(1, "English", 85);
        student2.addCourseForSemester(1, "Philosophy", 89);

        student2.displayStudentInfo();
    }
}
