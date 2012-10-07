/**
     * ������� ������ �� ����.
     * @param objId ������������� �������
     * @throws CacheException ���� �������� ��������
     * @throws NullPointerException ���� objId==null
     */
public synchronized void remove(Object objId) throws CacheException {
    if (objId == null) {
        throw new NullPointerException("objId is null");
    }
    CacheObject co = (CacheObject) _map.remove(objId);
    _cacheInfo.incRemove();
    if (co != null) {
        _tmap.remove(co);
        resetCacheObject(co);
    }
}/**
     * ��������� ������� ����. ��������� ������� � ������� ����������� �����
     * ����� ��� �������� ������ �������� ��� ���� ������ ����� null.
     * @throws CacheException ���� �������� ��������
     */
public void clean() throws CacheException {
    if (_config.getTimeToLive() == 0 && _config.getIdleTime() == 0) {
        return;
    }
    Object[] objArr = null;
    synchronized (this) {
        objArr = _map.values().toArray();
    }
    for (int i = 0, indx = objArr == null ? 0 : objArr.length; i < indx; i++) {
        CacheObject co = (CacheObject) objArr[i];
        if (!valid(co)) {
            remove(co.getObjectId());
        }
    }
}