package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.AbstractArrayStorage;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.SortedArrayStorage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final AbstractArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static final AbstractArrayStorage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");
        Resume r5 = new Resume();
        r5.setUuid("uuid5");
        Resume r6 = new Resume();
        r6.setUuid("uuid6");
        Resume r7 = new Resume();
        r7.setUuid("uuid7");
        Resume r8 = new Resume();
        r8.setUuid("uuid8");

        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r1);

        SORTED_ARRAY_STORAGE.save(r5);
        SORTED_ARRAY_STORAGE.save(r6);
        SORTED_ARRAY_STORAGE.save(r8);
        SORTED_ARRAY_STORAGE.save(r7);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Get r5: " + SORTED_ARRAY_STORAGE.get(r5.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.delete(r4.getUuid());
        printAll();

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();
        System.out.print("\nUpdate resume: uuid2 \n");
        ARRAY_STORAGE.update(r2);
        printAll();
        System.out.print("\nUpdate resume: uuid4 \n");

        ARRAY_STORAGE.update(r4);
        System.out.print("\n");
        SORTED_ARRAY_STORAGE.update(r4);
        System.out.print("\n");

        System.out.print("\nТестим сортед \n");
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
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
