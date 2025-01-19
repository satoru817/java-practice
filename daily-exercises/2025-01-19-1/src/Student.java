public class Student {
    private String name;
    private int age;
    private int grade;

    public Student(String name, int age, int grade) {
        // 入力値の検証を追加
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age value");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }

        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // 既存のgetterは正しいので省略

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age value");
        }
        this.age = age;
    }

    public void setGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        this.grade = grade;
    }

    public boolean isPass() {
        return grade >= 60;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, grade=%d}", name, age, grade);
    }
}