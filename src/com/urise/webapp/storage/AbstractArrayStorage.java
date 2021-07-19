package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("ERR: Резюме с таким ID: " + uuid + " не существует");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резюме с таким ID: " + uuid + " не существует");
        return null;
    }

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        if (getIndex(uuid) != -1) {
            System.out.println("Резюме с таким ID: " + uuid + " уже существует");
        } else if (size >= storage.length) {
            System.out.println("БД резюме переполнено");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме с таким ID: " + uuid + " не существует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);
}
