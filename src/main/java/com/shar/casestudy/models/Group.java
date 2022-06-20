package com.shar.casestudy.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    @Column(nullable = false)
    private String hexColor;
    @NonNull
    @Column(nullable = false)
    private String groupName;

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
