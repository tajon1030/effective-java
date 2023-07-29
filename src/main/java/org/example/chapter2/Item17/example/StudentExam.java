package org.example.chapter2.Item17.example;

public class StudentExam {
    public static void main(String[] args) {
        Student student = new Student("나", true, 30);

        if(classService.isBestStudent(student)){
            classService.increaseGrade(student);
        }

        Student student2 = new NewStudent("나2", true, 30);
        System.out.println(student2.getName());
        NewStudent newStudent = (NewStudent) student2;
        newStudent.setNewName("바뀐나");
        System.out.println(student2.getName());


        Friend friend = new Friend("친구1");

        String name = "값이";

        Student student3 = new Student("나3", friend);
        friend.name = "친구2";


    }
}
