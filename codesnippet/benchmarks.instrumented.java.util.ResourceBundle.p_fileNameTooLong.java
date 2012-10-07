/**
     * Find a bundle in the cache.
     * @param loader the class loader that is responsible for loading the bundle.
     * @param bundleName the complete name of the bundle including locale extension.
     *      ex. sun.text.resources.LocaleElements_fr_BE
     * @param defaultLocale the default locale at the time getBundle was called
     * @return the cached bundle.  null if the bundle is not in the cache.
     */
private static Object findBundleInCache(ClassLoader loader, String bundleName, Locale defaultLocale) {
    synchronized (cacheList) {
        cacheKey.setKeyValues(loader, bundleName, defaultLocale);
        Object result = cacheList.get(cacheKey);
        cacheKey.clear();
        return result;
    }
}/**
     * Put a new bundle in the cache and notify waiting threads that a new
     * bundle has been put in the cache.
     * @param defaultLocale the default locale at the time getBundle was called
     */
private static void putBundleInCache(ClassLoader loader, String bundleName, Locale defaultLocale, Object value) {
    synchronized (cacheList) {
        cacheKey.setKeyValues(loader, bundleName, defaultLocale);
        cacheList.put(cacheKey.clone(), value);
        underConstruction.remove(cacheKey);
        cacheKey.clear();
        cacheList.notifyAll();
    }
}/**
     * Remove any entries this thread may have in the construction list.
     * This is done as cleanup in the case where a bundle can't be
     * constructed.
     */
private static void cleanUpConstructionList() {
    synchronized (cacheList) {
        final Collection entries = underConstruction.values();
        final Thread thisThread = Thread.currentThread();
        while (entries.remove(thisThread)) {
        }
    }
}/**
     * Find a bundle in the cache or load it via the loader or a property file.
     * If the bundle isn't found, an entry is put in the constructionCache
     * and null is returned.  If null is returned, the caller must define the bundle
     * by calling putBundleInCache.  This routine also propagates NOT_FOUND values
     * from parent to child bundles when the parent is NOT_FOUND.
     * @param loader the loader to use when loading a bundle
     * @param bundleName the complete bundle name including locale extension
     * @param defaultLocale the default locale at the time getBundle was called
     * @param parent the parent of the resource bundle being loaded.  null if
     * the bundle is a root bundle
     * @return the bundle or null if the bundle could not be found in the cache
     * or loaded.
     */
private static Object findBundle(ClassLoader loader, String bundleName, Locale defaultLocale, String baseName, Object parent) {
    Object result;
    synchronized (cacheList) {
        Reference ref = referenceQueue.poll();
        while (ref != null) {
            cacheList.remove(((LoaderReference) ref).getCacheKey());
            ref = referenceQueue.poll();
        }
        cacheKey.setKeyValues(loader, bundleName, defaultLocale);
        result = cacheList.get(cacheKey);
        if (result != null) {
            cacheKey.clear();
            return result;
        }
        Thread builder = (Thread) underConstruction.get(cacheKey);
        boolean beingBuilt = (builder != null && builder != Thread.currentThread());
        if (beingBuilt) {
            while (beingBuilt) {
                cacheKey.clear();
                try {
                    cacheList.wait();
                } catch (InterruptedException e) {
                }
                cacheKey.setKeyValues(loader, bundleName, defaultLocale);
                beingBuilt = underConstruction.containsKey(cacheKey);
            }
            result = cacheList.get(cacheKey);
            if (result != null) {
                cacheKey.clear();
                return result;
            }
        }
        final Object key = cacheKey.clone();
        underConstruction.put(key, Thread.currentThread());
        cacheKey.clear();
    }
    result = loadBundle(loader, bundleName, defaultLocale);
    if (result != null) {
        boolean constructing;
        synchronized (cacheList) {
            cacheKey.setKeyValues(loader, bundleName, defaultLocale);
            constructing = underConstruction.get(cacheKey) == Thread.currentThread();
            cacheKey.clear();
        }
        if (constructing) {
            final ResourceBundle bundle = (ResourceBundle) result;
            if (parent != NOT_FOUND && bundle.parent == null) {
                bundle.setParent((ResourceBundle) parent);
            }
            bundle.setLocale(baseName, bundleName);
            putBundleInCache(loader, bundleName, defaultLocale, result);
        }
    }
    return result;
}/**
     * Find a bundle in the cache or load it via the loader or a property file.
     * If the bundle isn't found, an entry is put in the constructionCache
     * and null is returned.  If null is returned, the caller must define the bundle
     * by calling putBundleInCache.  This routine also propagates NOT_FOUND values
     * from parent to child bundles when the parent is NOT_FOUND.
     * @param loader the loader to use when loading a bundle
     * @param bundleName the complete bundle name including locale extension
     * @param defaultLocale the default locale at the time getBundle was called
     * @param parent the parent of the resource bundle being loaded.  null if
     * the bundle is a root bundle
     * @return the bundle or null if the bundle could not be found in the cache
     * or loaded.
     */
private static Object findBundle(ClassLoader loader, String bundleName, Locale defaultLocale, String baseName, Object parent) {
    Object result;
    synchronized (cacheList) {
        Reference ref = referenceQueue.poll();
        while (ref != null) {
            cacheList.remove(((LoaderReference) ref).getCacheKey());
            ref = referenceQueue.poll();
        }
        cacheKey.setKeyValues(loader, bundleName, defaultLocale);
        result = cacheList.get(cacheKey);
        if (result != null) {
            cacheKey.clear();
            return result;
        }
        Thread builder = (Thread) underConstruction.get(cacheKey);
        boolean beingBuilt = (builder != null && builder != Thread.currentThread());
        if (beingBuilt) {
            while (beingBuilt) {
                cacheKey.clear();
                try {
                    cacheList.wait();
                } catch (InterruptedException e) {
                }
                cacheKey.setKeyValues(loader, bundleName, defaultLocale);
                beingBuilt = underConstruction.containsKey(cacheKey);
            }
            result = cacheList.get(cacheKey);
            if (result != null) {
                cacheKey.clear();
                return result;
            }
        }
        final Object key = cacheKey.clone();
        underConstruction.put(key, Thread.currentThread());
        cacheKey.clear();
    }
    result = loadBundle(loader, bundleName, defaultLocale);
    if (result != null) {
        boolean constructing;
        synchronized (cacheList) {
            cacheKey.setKeyValues(loader, bundleName, defaultLocale);
            constructing = underConstruction.get(cacheKey) == Thread.currentThread();
            cacheKey.clear();
        }
        if (constructing) {
            final ResourceBundle bundle = (ResourceBundle) result;
            if (parent != NOT_FOUND && bundle.parent == null) {
                bundle.setParent((ResourceBundle) parent);
            }
            bundle.setLocale(baseName, bundleName);
            putBundleInCache(loader, bundleName, defaultLocale, result);
        }
    }
    return result;
}