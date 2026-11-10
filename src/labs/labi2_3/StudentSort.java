package labs.labi2_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        // два прохода стабильной сортировкой: сначала по возрасту, потом по имени
        mergeSort(students, Comparator.comparingInt(Student::getAge));
        mergeSort(students, Comparator.comparing(Student::getName));
    }

    private void mergeSort(List<Student> list, Comparator<Student> cmp) {
        slice(list, 0, list.size() - 1, cmp);
    }

    private void slice(List<Student> list, int start, int end, Comparator<Student> cmp) {
        if (start >= end) return;
        int middle = start + (end - start) / 2;
        slice(list, start, middle, cmp);
        slice(list, middle + 1, end, cmp);
        merge(list, start, middle, end, cmp);
    }

    private void merge(List<Student> list, int start, int middle, int end, Comparator<Student> cmp) {
        List<Student> tmp = new ArrayList<>(end - start + 1);
        int i = start, j = middle + 1;
        while (i <= middle && j <= end) {
            if (cmp.compare(list.get(i), list.get(j)) <= 0) tmp.add(list.get(i++));
            else tmp.add(list.get(j++));
        }
        while (i <= middle) tmp.add(list.get(i++));
        while (j <= end) tmp.add(list.get(j++));
        for (int k = 0; k < tmp.size(); k++) {
            list.set(start + k, tmp.get(k));
        }
    }
}
