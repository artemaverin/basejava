
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size++] = r;
    }

    Resume get(String uuid) {
        return getIndex(uuid) > -1 ? storage[getIndex(uuid)] : null;
    }

    void delete(String uuid) {
        if (getIndex(uuid) < 0) {
            return;
        }
        storage[getIndex(uuid)] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i].uuid != null || uuid != null)
                    && storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        System.arraycopy(storage, 0, allResume, 0, allResume.length);
        return allResume;
    }

    int size() {
        return size;
    }
}
