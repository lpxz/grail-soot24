public void run0() {
    Interval interval = new Interval(0, width, height, 0, height, 1, id);
    br.DoBarrier(id);
    if (id == 0) JGFInstrumentor.startTimer("Section3:RayTracer:Run");
    render(interval);
    synchronized (scene) {
        for (int i = 0; i < JGFRayTracerBench.nthreads; i++) if (id == i) JGFRayTracerBench.checksum1 = JGFRayTracerBench.checksum1 + checksum;
    }
    br.DoBarrier(id);
    if (id == 0) JGFInstrumentor.stopTimer("Section3:RayTracer:Run");
}public void run() {
    Interval interval = new Interval(0, width, height, 0, height, 1, id);
    br.DoBarrier(id);
    if (id == 0) JGFInstrumentor.startTimer("Section3:RayTracer:Run");
    render(interval);
    synchronized (scene) {
        for (int i = 0; i < JGFRayTracerBench.nthreads; i++) if (id == i) JGFRayTracerBench.checksum1 = JGFRayTracerBench.checksum1 + checksum;
    }
    br.DoBarrier(id);
    if (id == 0) JGFInstrumentor.stopTimer("Section3:RayTracer:Run");
}