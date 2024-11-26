package org.delta.persons;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class Owner {
    private String name;
    private String surname;
    private String personId;

    public Owner(String name, String surname, String personId) {
        this.name = name;
        this.surname = surname;
        this.personId = personId;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonId() {
        return personId;
    }
}
