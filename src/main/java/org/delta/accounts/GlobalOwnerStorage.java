package org.delta.accounts;

import jakarta.inject.Singleton;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class GlobalOwnerStorage {
    public List<Owner> owners = new LinkedList<>();
}
