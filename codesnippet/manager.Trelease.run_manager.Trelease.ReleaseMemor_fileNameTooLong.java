public void run() {
    int mem_num;
    while (true) {
        while (Manager.flag == true) {
            yield();
        }
        synchronized (Manager.rel_counter_lock) {
            mem_num = Manager.request_counter;
        }
        if (mem_num > 0) {
            ReleaseMemoryBlock();
            while (mem_num == Manager.request_counter && Manager.flag == true) {
                yield();
            }
        } else {
            System.out.println("Thread num: " + t_num + " finished");
            return;
        }
    }
}private void ReleaseMemoryBlock() {
    Manager.setNote(t_num, true);
    yield();
    Manager.flag = true;
    if (Manager.isOtherNoteSet()) {
        synchronized (Manager.rel_counter_lock) {
            Manager.released_counter++;
        }
    }
    Manager.setNote(t_num, false);
}