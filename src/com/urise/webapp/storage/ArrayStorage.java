package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getRIndex(r.getUuid());
        if (index != 0) {
            storage[index].setUuid(r.getUuid());
        } else {
            System.out.println("ERR: Резюме с таким ID: " + r.getUuid() + " не существует");
        }
    }

    public void save(Resume r) {
        if (getRIndex(r.getUuid()) != 0) {
            System.out.println("Резюме с таким ID: " + r.getUuid() + " уже существует");
        } else if (size >= storage.length) {
            System.out.println("БД резюме переполнено");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getRIndex(uuid);
        if (index != 0) {
            return storage[index];
        }
        System.out.println("Резюме с таким ID: " + uuid + " не существует");
        return null;
    }

    public void delete(String uuid) {
        int index = getRIndex(uuid);
        if (index != 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме с таким ID: " + uuid + " не существует");
        }
    }

    public int getRIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
