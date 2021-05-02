import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    List<Resume> list = new ArrayList<>(Arrays.asList(storage));

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Резюме с таким ID уже существует");
            } else {
                storage[size() + 1] = r;
            }
        }
    }

    Resume get(String uuid) {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (!storage[i].uuid.equals(uuid)) {
                return System.out.println("Index резюме: " + i + "ID резюме: " + storage[i]);
            }
        }
        return System.out.println("Резюме с таким ID " + storage[i] + "не существует");
    }

    void delete(String uuid) {
        list.remove(uuid);
        storage = list.toArray(new Resume[list.size()]);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int i;
        int sz = 0;
        for (i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                sz++;
            }
        }
        return sz;
    }
}
