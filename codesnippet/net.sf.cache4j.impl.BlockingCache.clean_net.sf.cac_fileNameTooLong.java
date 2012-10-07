/**
     * �������� ������ � ���. ���� ����� ������� put() ��� ������ ����� get()
     * � �� ������ null �� � put() ����� �������� ����� �� objId ��� � � ����� get()
     * ����� ��������� CacheException.
     * @param objId ������������� �������
     * @param obj ������
     * @throws CacheException ���� �������� ��������, �������� ���������� ������� �������
     * @throws NullPointerException ���� objId==null
     */
public void put(Object objId, Object obj) throws CacheException {
    if (objId == null) {
        throw new NullPointerException("objId is null");
    }
    CacheObject tlCO = (CacheObject) _tl.get();
    CacheObject co = null;
    int objSize = 0;
    try {
        objSize = _config.getMaxMemorySize() > 0 ? Utils.size(obj) : 0;
    } catch (IOException e) {
        throw new CacheException(e.getMessage());
    }
    checkOverflow(objSize);
    if (tlCO == null) {
        co = getCacheObject(objId);
    } else {
        if (tlCO.getObjectId().equals(objId)) {
            co = tlCO;
            _tl.set(null);
        } else {
            tlCO.unlock();
            throw new CacheException("Cache:" + _config.getCacheId() + " wait for call put() with objId=" + tlCO.getObjectId());
        }
    }
    co.lock();
    _cacheInfo.incPut();
    try {
        tmapRemove(co);
        resetCacheObject(co);
        co.setObject(obj);
        co.setObjectSize(objSize);
        synchronized (this) {
            _memorySize = _memorySize + objSize;
        }
        tmapPut(co);
    } finally {
        co.unlock();
    }
}/**
     * ������� ������ �� _tmap
     */
private void tmapRemove(CacheObject co) {
    synchronized (this) {
        _tmap.remove(co);
    }
}/**
     * ���� ��� ����������, �� ���������� �������� ��� �� �������, ��
     * ��������� ���� ������ � ����������� � ���������� LFU, LRU, FIFO, ...
     */
private void checkOverflow(int objSize) {
    synchronized (this) {
        while ((_config.getMaxSize() > 0 && _map.size() + 1 > _config.getMaxSize()) || (_config.getMaxMemorySize() > 0 && _memorySize + objSize > _config.getMaxMemorySize())) {
            Object firstKey = _tmap.size() == 0 ? null : _tmap.firstKey();
            CacheObject fco = firstKey == null ? null : (CacheObject) _tmap.remove(firstKey);
            if (fco != null) {
                CacheObject co = (CacheObject) _map.get(fco.getObjectId());
                if (co != null && co == fco) {
                    _map.remove(fco.getObjectId());
                    resetCacheObject(fco);
                }
            }
        }
    }
}/**
     * ��������� ������� ����. ��������� ������� � ������� ����������� �����
     * ����� ��� �������� ������ �������� ��� ���� ������ ����� null.
     * @throws CacheException ���� ����� ������� clean() ��� ������ ����� get()
     * � �� ������ null �� ��� ������ clean() ����� ���������� CacheException.
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
}/**
     *  ���� ������ ��� � ���� ��:
     *   - ������������� ������ ����
     *   - ������� ������ �� ������, �������� ������ �������, ���������� ����������
     * @param co ���������� ������
     */
private void resetCacheObject(CacheObject co) {
    synchronized (this) {
        _memorySize = _memorySize - co.getObjectSize();
    }
    co.reset();
}/**
     * ������� ������ �� ����.
     * @param objId ������������� �������
     * @throws CacheException ���� ����� ������� remove() ��� ������ ����� get()
     * � �� ������ null �� ��� ������ remove() ��������� CacheException.
     * @throws NullPointerException ���� objId==null
     */
public void remove(Object objId) throws CacheException {
    if (objId == null) {
        throw new NullPointerException("objId is null");
    }
    CacheObject tlCO = (CacheObject) _tl.get();
    if (tlCO != null) {
        throw new CacheException("Cache:" + _config.getCacheId() + " wait for call put() with objId=" + tlCO.getObjectId());
    }
    CacheObject co = null;
    synchronized (this) {
        co = (CacheObject) _map.get(objId);
    }
    if (co == null) {
        return;
    }
    co.lock();
    _cacheInfo.incRemove();
    try {
        synchronized (this) {
            tmapRemove(co);
            CacheObject co2 = (CacheObject) _map.get(co.getObjectId());
            if (co2 != null && co2 == co) {
                _map.remove(co.getObjectId());
                resetCacheObject(co);
            }
        }
    } finally {
        co.unlock();
    }
}/**
     * ������� ������ �� ����.
     * @param objId ������������� �������
     * @throws CacheException ���� ����� ������� remove() ��� ������ ����� get()
     * � �� ������ null �� ��� ������ remove() ��������� CacheException.
     * @throws NullPointerException ���� objId==null
     */
public void remove(Object objId) throws CacheException {
    if (objId == null) {
        throw new NullPointerException("objId is null");
    }
    CacheObject tlCO = (CacheObject) _tl.get();
    if (tlCO != null) {
        throw new CacheException("Cache:" + _config.getCacheId() + " wait for call put() with objId=" + tlCO.getObjectId());
    }
    CacheObject co = null;
    synchronized (this) {
        co = (CacheObject) _map.get(objId);
    }
    if (co == null) {
        return;
    }
    co.lock();
    _cacheInfo.incRemove();
    try {
        synchronized (this) {
            tmapRemove(co);
            CacheObject co2 = (CacheObject) _map.get(co.getObjectId());
            if (co2 != null && co2 == co) {
                _map.remove(co.getObjectId());
                resetCacheObject(co);
            }
        }
    } finally {
        co.unlock();
    }
}/**
     * ������� ��� ������� �� ����
     * @throws CacheException ���� ����� ������� clear() ��� ������ ����� get()
     * � �� ������ null �� ��� ������ clear() ����� ���������� CacheException.
     */
public void clear() throws CacheException {
    Object[] objArr = null;
    synchronized (this) {
        objArr = _map.values().toArray();
    }
    for (int i = 0, indx = objArr == null ? 0 : objArr.length; i < indx; i++) {
        remove(((CacheObject) objArr[i]).getObjectId());
    }
}/**
     * ���������� ������ CacheObject ��� �������������� objId.
     * ���� ������� CacheObject ��� �� �� ��������.
     * @param objId ������������� �������
     */
private CacheObject getCacheObject(Object objId) {
    synchronized (this) {
        CacheObject co = (CacheObject) _map.get(objId);
        if (co == null) {
            co = _config.newCacheObject(objId);
            _map.put(objId, co);
        }
        return co;
    }
}/**
     * �������� ���������� ������ � _tmap
     * @param co ���������� ������
     */
private void tmapPut(CacheObject co) {
    synchronized (this) {
        Object mapO = _map.get(co.getObjectId());
        if (mapO != null && mapO == co) {
            _tmap.put(co, co);
        }
    }
}