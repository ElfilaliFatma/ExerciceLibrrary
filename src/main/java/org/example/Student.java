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


    public void addStudent(Student st){
        try{
            if(students.contains(st)){
                throw new StudentException("Student with id"+st.getId()+"already exists");
            }
            students.add(st);


            }catch (StudentException ste){
                System.out.println(ste.getMessage());
            }
        }
    }


