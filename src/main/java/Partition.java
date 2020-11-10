class Partition {
    public static int result = 0;

    static void checkPrintSplit(int[] m, int[] arr, int l) {
        if (check(m, arr, l)) {
            result++;
        }
    }

    static int next(int[] arr, int l) {
        int i = l - 1;
        int sum = 0;
        do {
            sum += arr[i--];
        } while (i > 0 && arr[i - 1] <= arr[i]);
        arr[i]++;
        l = i + sum;
        for (int j = i + 1; j < l; j++) {
            arr[j] = 1;
        }
        return l;
    }

    static void run(int n, int[] m) {
        int l = n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        checkPrintSplit(m, arr, n);
        do {
            l = next(arr, l);
            checkPrintSplit(m, arr, l);
        } while (l > 1);
    }

    private static boolean check(int[] m, int[] arr, int l) {
        boolean good = true;
        for (int i = 0; i < l; i++) {
            if (!contain(m, arr[i])) {
                good = false;
            }
        }
        return good;
    }

    private static boolean contain(int[] m, int current) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] == current) {
                return false;
            }
        }
        return true;
    }
}
