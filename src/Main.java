import java.nio.charset.Charset;

public class Main {

	public static int LENGTH_PAPER = 32;

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append(DrawLine());
		sb.append(DrawSingle("��������", "6824545462133"));
		sb.append(DrawLine());
		sb.append(DrawDouble(1, "����", "18550102457", "�Ϲ���������"));
		sb.append(DrawLine());
		sb.append(DrawDouble(0, "����", "18550102457", "�Ϲ�����������������"));
		sb.append(DrawLine());

		System.out.println(sb);
	}

	/**
	 * ����
	 * 
	 * @return
	 */

	public static String DrawLine() {
		String value = "";

		for (int i = 0; i < LENGTH_PAPER; i++) {
			value += "-";
		}
		value += "\n";
		return value;
	}

	/**
	 * ������
	 */

	public static String DrawSingle(String name, String value) {

		String result = "";

		result = "|" + "  " + name + ":" + value+"     ����Ʒ";

		for (int i = 0; i < LENGTH_PAPER - result.getBytes(Charset.forName("GB2312")).length; i++) {

			result += " ";

		}

		result += "|\n";
		return result;

	}

	/**
	 * ������
	 */

	public static String DrawDouble(int type, String name, String tel, String address) {

		StringBuffer sb = new StringBuffer();

		if (type == 0) {

			sb.append("|  �շ���Ϣ");
		} else {
			sb.append("|  �ķ���Ϣ");
		}
		for (int i = 0; i < LENGTH_PAPER - "|  �շ���Ϣ".getBytes(Charset.forName("GB2312")).length; i++) {
			sb.append(" ");
		}
		sb.append("|\n");

		String getname = "";
		String getTelephone = "";
		String getAddress = "";

		if (type == 0) {
			getname = "|  �շ��ˣ�" + name;

		} else {
			getname = "|  �ķ��ˣ�" + name;
		}
		getTelephone = "�绰��" + tel;
		getAddress = "|  ��ַ��" + address;

		sb.append(getname);
		for (int i = 0; i < LENGTH_PAPER / 2 - getname.getBytes(Charset.forName("GB2312")).length; i++) {

			sb.append(" ");
		}
		sb.append(getTelephone);

		for (int i = 0; i < LENGTH_PAPER - getname.getBytes(Charset.forName("GB2312")).length
				- getTelephone.getBytes(Charset.forName("GB2312")).length; i++) {

			sb.append(" ");
		}
		sb.append("|\n");

		sb.append(getAddress);

		for (int i = 0; i < LENGTH_PAPER - getAddress.getBytes(Charset.forName("GB2312")).length; i++) {

			sb.append(" ");
		}
		sb.append("|\n");
		

		return sb.toString();

	}

}
