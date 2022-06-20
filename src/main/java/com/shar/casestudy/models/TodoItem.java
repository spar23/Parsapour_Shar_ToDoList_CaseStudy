package com.shar.casestudy.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
//@Table(name = "Items")
public class TodoItem {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
    @NonNull
   @Column(nullable = false)
        private String description;
    @NonNull
    @Column(nullable = false)
        private String status;

//    @NonNull
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinColumn(nullable = false)
//    private Group group;


    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(nullable = false)
    User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem item = (TodoItem) o;
        return id == item.id && status.equals(item.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status);
    }

}
