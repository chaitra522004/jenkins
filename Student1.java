class Student1 {
    private String name;
    private int birthDay, birthMonth, birthYear;

    public Student1(String name, String dob) {
        this.name = name;
        String[] dobParts = dob.split("-");
        this.birthDay = Integer.parseInt(dobParts[0]);
        this.birthMonth = Integer.parseInt(dobParts[1]);
        this.birthYear = Integer.parseInt(dobParts[2]);
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

    public void displayStudentInfo() {
        int age = calculateAge();
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age + " years");
    }
    public static void main(String[] args) {

        String name1 = "John Doe";
        String dob1 = "15-08-2000"; 
        Student1 student1 = new Student1(name1, dob1);
        student1.displayStudentInfo();

        String name2 = "Jane Smith";
        String dob2 = "20-03-2002"; 
        Student1 student2 = new Student1(name2, dob2);
        student2.displayStudentInfo();
    }
}