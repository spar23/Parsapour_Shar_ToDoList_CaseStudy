package com.shar.casestudy.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="group_todo")
public class Group {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String hexColor;
    @NonNull
    String groupName;

    @OneToMany(mappedBy = "group", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<TodoItem> todoItems = new LinkedHashSet<>();

    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(nullable = false)
    User user;

    public Group(String groupName, String hexColor, User user) {
        this.groupName = groupName;
        this.hexColor = hexColor;
        this.user = user;
    }

    //Helper method
    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }

    public void deleteItem(TodoItem item){
        todoItems.remove(item);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id && groupName.equals(group.groupName) && hexColor.equals(group.hexColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, hexColor);
    }



}
