package com.example.homework27.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 4, max = 10, message = "Title length should be 4-10 letters")
    //@Column(columnDefinition = "varchar(10)")
    private String title;

    @NotEmpty(message = "Body should not be empty")
    @Size(min = 10, max = 200, message = "Body length should be 10-200 letters")
    //@Column(columnDefinition = "varchar(200)")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private MyUser user;
}
