package org.delta.persons;

public class PersonJsonSerializationService {
    public String serializerOwner(Owner owner)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        builder.append("\n");
        builder.append("    \"NAME\":");
        builder.append("\"" + owner.getName() + "\"");

        builder.append("\n");
        builder.append("    \"LASTNAME\":");
        builder.append("\"" + owner.getSurname() + "\"");

        builder.append("\n");
        builder.append("    \"PERSON ID\":");
        builder.append("\"" + owner.getPersonId() + "\"");

        builder.append("\n");
        builder.append("}");
        builder.append("\n");


        return builder.toString();
    }
}
