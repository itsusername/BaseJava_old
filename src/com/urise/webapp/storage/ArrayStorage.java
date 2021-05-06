package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume r, String uuid) {
        boolean isResume = false;
        boolean isUpdate = true;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                isResume = true;
                for (int j = 0; j < size; j++) {
                    if (r.uuid.equals(storage[j].uuid)) {
                        System.out.println("ERR: Резюме с таким ID уже существует");
                        isUpdate = false;
                        break;
                    }
                }
                if (isUpdate) {
                    storage[i] = r;
                    break;
                }
            }
        }
        if (!isResume) {
            System.out.println("ERR: Резюме с таким ID не существует");
        }
    }

    void save(Resume r) {
        boolean duplicate = false;
        if (size == 10000) {
            System.out.println("БД резюме переполнено");
        } else {
            for (int i = 0; i < size; i++) {
                if (r.uuid.equals(storage[i].uuid)) {
                    System.out.println("Резюме с таким ID уже существует");
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.contains(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме с таким ID не существует");
        return null;
    }

    void delete(String uuid) {
        boolean isResume = false;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                isResume = true;
                size--;
            }
        }
        if (!isResume) {
            System.out.println("Резюме с таким ID не существует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
