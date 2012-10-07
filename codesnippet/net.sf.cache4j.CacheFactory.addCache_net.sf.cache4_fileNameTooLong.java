/**
     * ������� ���
     * @param cacheId ������������� ����
     * @throws NullPointerException ���� cacheId==null
     */
public void removeCache(Object cacheId) throws CacheException {
    if (cacheId == null) {
        throw new NullPointerException("cacheId is null");
    }
    synchronized (_cacheMap) {
        _cacheMap.remove(cacheId);
    }
}/**
     * ��������� ���. ��� ����� ���������� Cache ������ ������������� ��������� ManagedCache.
     * @param cache ���
     * @throws NullPointerException ���� cache==null ��� cache.getCacheConfig()==null
     * ��� cache.getCacheConfig().getCacheId()==null
     * @throws CacheException ���� ��� ��� ���������� ��� ���� ����������� ��� ��
     * ��������� ��������� ManagedCache
     */
public void addCache(Cache cache) throws CacheException {
    if (cache == null) {
        throw new NullPointerException("cache is null");
    }
    CacheConfig cacheConfig = cache.getCacheConfig();
    if (cacheConfig == null) {
        throw new NullPointerException("cache config is null");
    }
    if (cacheConfig.getCacheId() == null) {
        throw new NullPointerException("config.getCacheId() is null");
    }
    if (!(cache instanceof Cache)) {
        throw new CacheException("cache not instance of " + ManagedCache.class.getName());
    }
    synchronized (_cacheMap) {
        if (_cacheMap.containsKey(cacheConfig.getCacheId())) {
            throw new CacheException("Cache id:" + cacheConfig.getCacheId() + " exists");
        }
        _cacheMap.put(cacheConfig.getCacheId(), cache);
    }
}/**
     * ���������� ������ � ���������������� �����
     */
public Object[] getCacheIds() {
    synchronized (_cacheMap) {
        return _cacheMap.keySet().toArray();
    }
}/**
     * ���������� ���
     * @param cacheId ������������� ����
     * @throws NullPointerException ���� cacheId==null
     */
public Cache getCache(Object cacheId) throws CacheException {
    if (cacheId == null) {
        throw new NullPointerException("cacheId is null");
    }
    synchronized (_cacheMap) {
        return (Cache) _cacheMap.get(cacheId);
    }
}