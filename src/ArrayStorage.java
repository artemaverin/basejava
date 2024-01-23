
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
        Resume result = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                result = storage[i];
            }
        }
        return result;
    }

    void delete(String uuid) {
        int deletedIndex = -1;
        for (int i = 0; i < size; i++) {
            if ((storage[i].uuid != null || uuid != null)
                    && storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                deletedIndex = i;
                break;
            }
        }
        if (deletedIndex >= 0 && size + 1 - deletedIndex >= 0) {
            System.arraycopy(storage, deletedIndex + 1, storage, deletedIndex, size + 1 - deletedIndex);
            size--;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[size];
        System.arraycopy(storage, 0, array, 0, array.length);
        return array;
    }

    int size() {
        return size;
    }
}
