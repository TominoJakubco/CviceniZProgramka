package org.delta.persons;

import com.google.gson.Gson;

public class PersonGsonSerializationService {
    public String serializeOwner(Owner owner)
    {
        Gson gson = new Gson();

        return gson.toJson(owner, Owner.class);
    }
}
