/**
     * ������������� �������� �������
     * @param cleanInterval ��������(� �������������) � ������� ����� ��������� �������
     */
public void setCleanInterval(long cleanInterval) {
    _cleanInterval = cleanInterval;
    synchronized (this) {
        if (_sleep) {
            interrupt();
        }
    }
}