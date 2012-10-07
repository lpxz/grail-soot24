private static synchronized void swpArray(int i) {
    int temp;
    temp = array[i + 1];
    array[i + 1] = array[i];
    array[i] = temp;
}