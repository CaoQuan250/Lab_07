package model;


import entity.Student;

import java.util.*;

public class StudentList {
    private ArrayList<Student> list;
    private int length;

    public StudentList(){
        list = new ArrayList<Student>();
        list.add(new Student(1,"Cao","Quân",50));
        list.add(new Student(2,"Trần","Đăng",55));
        list.add(new Student(3,"Nguyễn","Luật",60));
        list.add(new Student(4,"Bùi","Hà",65));
        list.add(new Student(5,"Lê","Quyết",70));
        list.add(new Student(6,"Đào","Như",75));
        list.add(new Student(7,"Mạc","Minh",80));
        list.add(new Student(8,"Phạm","Duy",85));
        list.add(new Student(9,"Đức","Tâm",90));
        list.add(new Student(10,"Ngô","Lợi",95));
        list.add(new Student(11,"Hoàng","Tuất",100));
        list.add(new Student(12,"Đặng","Anh",45));
        list.add(new Student(13,"Phan","Dương",40));
        list.add(new Student(14,"Hồ","Khánh",35));
        list.add(new Student(15,"Dương","Long",30));
        list.add(new Student(16,"Đỗ","Thìn",25));
        list.add(new Student(17,"Lý","Kiệt",20));
        list.add(new Student(18,"Trương","Ngân",15));
        list.add(new Student(19,"Đinh","Trọng",10));
        list.add(new Student(20,"Huỳnh","Hiển",5));

    }


    public ArrayList<Student> findByName (String name) {
        boolean found = false;
        ArrayList<Student> matches = new ArrayList<>();
        for (Student s: list) {
            String fullName = new String(s.getFirstName() + " " + s.getLastName()). toLowerCase();
            if (fullName.matches("(.*)" + name.toLowerCase() + "(.*)")) {
                matches.add(s);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Not found");
        }
        return matches;
    }
    public Student findById(int id) {
        for (Student s:list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void add(Student s){
        list.add(s);
    }

    public void remove(int id){
        boolean found = false;
        for (Student s: list) {
            if (s.getId() == id) {
                int choice;
                System.out.println("Are you sure deleting this student? (1.Yes 2.No");
                choice = new Scanner(System.in).nextInt();
                if (choice == 1)
                    list.remove(s);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Cannot find student with id "+id);
        }
    }
    public void sortByMark() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return new Double(o1.getMark()).compareTo(o2.getMark());
            }
        });
    }
    public void sortById(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
    }
    public void sortByName(){
        list.sort(((o1, o2) -> o1.getLastName().compareTo(o2.getLastName())));
    }
    public void showList() {

        for (Student s: list) {
            s.printInfo();
        }

    }
    public void showList(ArrayList<Student> slist){
        list.forEach(student -> System.out.println(student));
        for (Student s: slist) {
            s.printInfo();
        }
    }

}

