public static void setNote(int index, boolean op) {
    synchronized (Manager.notes_lock) {
        if (op) {
            num_of_notes_set++;
        } else {
            num_of_notes_set--;
        }
    }
}public static boolean isOtherNoteSet() {
    synchronized (Manager.notes_lock) {
        if (num_of_notes_set == 1) {
            return true;
        } else return false;
    }
}