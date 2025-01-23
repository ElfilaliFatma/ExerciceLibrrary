package org.example;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    Set<Student>students =new HashSet<>();


    public void addStudent(int id){
        Student st=new Student();
        st.setId(id);
        if(students.contains(id)){
            try {
                throw new StudentException("Student with id"+getId()+"already exists");

                students.add(st);

            }catch ()
        }
    }

}
