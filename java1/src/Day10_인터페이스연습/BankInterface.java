package Day10_�������̽�����;

public interface BankInterface {
	// 1. ����ʵ�
	
	// 2. �߻� �޼��� : ���� O, ���� X
	public boolean ���»���();	// �޾ƾ� �ϴ� ������ ����. ó����� ����
	public void �Ա�();		// �Ա��� ����, �ݾ� ���޹޾ƾ� ��. ó����� �����ؾ���
	public void ���();	
	public void ��ü();
	public void ���¸����ȸ();
	public void �����ܰ���ȸ();
	
	// 3. ����Ʈ �޼��� : ���� O, ���� O, ��ü���� ȣ�� X		[ jre 8 �̻� ]
	
	// 4. ���� �޼��� : ���� O, ���� O, ��ü���� ȣ�� O		[ jre 8 �̻� ]
}
