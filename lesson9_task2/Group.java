package lesson9_task2;

import java.util.*;

public class Group {
    private String groupName;
    private List<Student> students;



    public Group() {
        students = new ArrayList<>();
        this.groupName = null;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {

        for(int i = 0; i < students.size(); i++){
            if(student.equals(students.get(i))){
                System.out.println("Cтудент " + student.getName() +" уже есть, количество студентов осталось тоже!");
                return;
            }
        }

        if(!(student.getGroupName().equals(this.groupName))){
            System.out.println("Студент "+ student.getName() +" не может быть в этой группе!");
            return;
        }
        if(students.size() < 10) {
            students.add(student);
            return;
        }
       throw new GroupOverflowException("В группу нельзя добавить больше 10 студентов");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getLastName().equals(lastName)){
                return students.get(i);
            }
        }
        throw new StudentNotFoundException("Такого студента не найдено!");
    }

    public boolean removeStudentByID(int id) {
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public List<Student> sortStudentsByLastName(){
       students.sort(new StudentLastNameComparator());

       return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!Objects.equals(groupName, group.groupName)) return false;
        return Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
         String result = "Group " + groupName + System.lineSeparator();
         List<Student> sortedStudentsForLastName = sortStudentsByLastName();

         for(int i = 0; i < sortedStudentsForLastName.size(); i++){
             result +=  sortedStudentsForLastName.get(i).toString() + System.lineSeparator();
         }
        return result;
    }
}
