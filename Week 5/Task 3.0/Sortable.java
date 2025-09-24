abstract  class Sortable {
    public static void shell_sort(Employee[] staff) {
        int n = staff.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Employee temp = staff[i];
                int j;
                for (j = i; j >= gap && staff[j - gap].getSalary() > temp.getSalary(); j -= gap) {
                    staff[j] = staff[j - gap];
                }
                staff[j] = temp;
            }
        }
    }
}