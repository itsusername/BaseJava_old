package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";
        Resume r4 = new Resume();
        r4.uuid = "uuid4";

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.delete(r4.uuid);
        printAll();

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();
        System.out.print("\nUpdate resume: uuid3 no uuid4 \n");
        ARRAY_STORAGE.update(r4, "uuid3");
        printAll();
        System.out.print("\nUpdate resume: uuid2 no uuid3 \n");

        ARRAY_STORAGE.update(r1, "uuid2");
        System.out.print("\n");

        printAll();
        ARRAY_STORAGE.delete(r1.uuid);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
