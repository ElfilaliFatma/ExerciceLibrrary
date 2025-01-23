package org.example;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
 @EqualsAndHashCode
public class Books implements Comparable<Books>  {
    private String title;
    private String author;
    private int ISBN;
Libray lb =new Libray();

    public int compareTo(Books other) {

        return this.title.compareTo(other.title);
    }


    }

