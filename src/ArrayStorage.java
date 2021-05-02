import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[15];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (Resume resume : storage) {
            if (r.equals(resume)) {
                System.out.println("Резюме с таким ID уже существует");
            } else {
                storage[size()] = r;
                break;

            }
        }
    }

    Resume get(String uuid) {
        System.out.println("uuid " + uuid);
        for (Resume resume : storage) {
            if (resume != null) {
                if (uuid.contains(resume.uuid)) {
                    return resume;
                }
            }
        }
        System.out.println("Резюме с таким ID не существует");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (uuid.equals(storage[i].uuid)) {
                    storage[i] = null;
                    for (int x = i + 1; x < storage.length - 1; x++) {
                        storage[x - 1] = storage[x];
                        storage[x] = null;
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int sz = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                sz++;
            }
        }
        return sz;
    }
}
