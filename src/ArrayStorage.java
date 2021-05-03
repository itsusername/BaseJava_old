import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = size();

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size == 0) {
            storage[size] = r;
            size++;
        } else {
            for (int i = 0; i < size; ) {
                if (r.uuid.equals(storage[i].uuid)) {
                    System.out.println("Резюме с таким ID уже существует");
                } else {
                    storage[size] = r;
                    size++;
                }
                break;
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
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                size--;
                for (int j = i + 1; j < storage.length - 1; j++) {
                    storage[j - 1] = storage[j];
                    storage[j] = null;
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
