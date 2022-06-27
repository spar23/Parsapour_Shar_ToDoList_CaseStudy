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
@Table(name = "todo_item")
public class TodoItem {

        @Id
        @NonNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        @NonNull
        String description;

    public TodoItem(int id, String description,User user, Status status, Group group) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.group = group;
        this.user = user;

    }

    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(nullable = false)
        Status status;


    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(nullable = false)
    User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "group_id")
    Group group;

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
