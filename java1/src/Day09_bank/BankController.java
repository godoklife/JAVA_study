package Day09_bank;

import java.util.Random;

public class BankController {
	// �� Ŭ������ ���� ���� �����ѷ�
	// M : �� 	[ ������ ]
	// V : �� 	[ ����� ] 
	// C : �𵨰� �� ���� ����
	
	// ��Ʈ�ѷ��� �� ���� : �信�� ��û�ϴ� ����[���] ����
		// 1. ���� ���� [C]
	public String ���»���(String password, String name, int bankno) {
			// Day09_6_����������α׷� �� String ���¹�ȣ = controll.���»���(password, name, bankno);
			// ���� ���޹��� password, name, bankno�� ������ �޼��� �����.
		// 1. �Է¹��� ���� �����´�. [ �μ� ]
			// ���¹�ȣ �ڵ� ����
		String ���¹�ȣ;
		while(true) {
			Random random = new Random();	// ������ �� �����ϴ� Ŭ����
			// 4�ڸ� ����(0~9999)
			int ���� = random.nextInt(10000);		// 1������ ��, 0~9999 ������ �� �������� �Ѱ� ��
			���¹�ȣ = String.format("%04d", ����);
										// �������� ����
											// %d : ����
											// %4d : 4���� ������ ���(���ڸ��� ����ó��)
											// %04d: 4���� ������ ���(���ڸ��� 0���� ó��)
			// ���¹�ȣ �ߺ�üũ
			boolean ���¹�ȣ�ߺ�üũ = false;
			for(Bank tmp2 : Day09_6_����������α׷�.accountList) {
				if(tmp2!=null && tmp2.getAnumber().equals(���¹�ȣ)) {
					���¹�ȣ�ߺ�üũ = true;
				}else {
					���¹�ȣ�ߺ�üũ = false;
				}
			}	
			if (���¹�ȣ�ߺ�üũ== false) {
				break;
			}
		}
		
		// 2. ��üȭ [ �ټ��� ������ �ϳ��� ��ü�� ����� = �ϳ��� ���Ϸ� �����Ѵ� ]
		Bank tmp=null;	// ���� ��ü ����
		if(bankno == 1) {	// ���� �����ȣ�� 1�̸�
			tmp = new KookminBank(���¹�ȣ, password, name);	// tmp�� �������� Ŭ������ ��ü�� ����.
		}else if(bankno == 2) {	// �����ȣ�� 2�̸�
			tmp = new ShinhanBank(���¹�ȣ, password, name);	// tmp�� ShinhanBank Ŭ������ ��ü�� ����
		}else if(bankno == 3) {	// �����ȣ�� 3�̸�
			tmp = new HanaBank(���¹�ȣ, password, name);		// tmp�� HanaBank Ŭ������ ��ü�� ����.
		}
		
		// 3. �迭�� ���� 
		int i=0;	// �ε��� ����� �ӽ� ����
		for(Bank tmp2 : Day09_6_����������α׷�.accountList) {
			if(tmp2 ==null) {
				Day09_6_����������α׷�.accountList[i]=tmp;
				return ���¹�ȣ;	// ���� ���� �����Ͽ����Ƿ� 
			}
		i++;	// �ε��� ī��Ʈ
		}	// �迭�� �����ϴ� for�� END
		
		return null;	// ���� ���� �����ϸ� null ��ȯ.
	}	// ���»����� �����ϸ� ���¹�ȣ , �����ϸ� null
		
	// 2. �Ա�
	public boolean �Ա�() {return false;}		// �ϴ� ��� ������ �ȵ����Ƿ� 
		// 3. ���
	public boolean ���() {return false;}
		// 4. ��ü
	public boolean ��ü() {return false;}
		// 5. �� ���¸��
	public Bank[] �����¸��(String name) {		// ������ �������� ���¸� ã�Ƽ� �迭�� ��� �����ϱ�.
			// ���ϰ� : Bank ������ �迭
		
		Bank[] ������ = new Bank[100];	// 1. �迭 ����
		for(Bank tmp : Day09_6_����������α׷�.accountList) {	// ��ī��Ʈ����Ʈ�� ������ �ӽ÷� �ű�
			int i=0;	// �ε��� ī��Ʈ
			if(tmp!= null && tmp.getName().equals(name)) {	// tmp�� ���� null�� �ƴϸ鼭 name�� ��ġ�ϸ�
				for(Bank tmp2 : ������) {
					if(tmp2 == null) {
						������[i] = tmp;
						break;
					}
					i++;
				}
			}
		}
		
		return null;
		}
		// 6. ����
	public boolean ����() {return false;}
	
	
	
	
	
}