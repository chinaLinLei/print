import java.nio.charset.Charset;

public class Main {

	public static int LENGTH_PAPER = 32;

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append(DrawLine());
		sb.append(DrawSingle("物流单号", "6824545462133"));
		sb.append(DrawLine());
		sb.append(DrawDouble(1, "张三", "18550102457", "上哈哈哈哈哈"));
		sb.append(DrawLine());
		sb.append(DrawDouble(0, "张三", "18550102457", "上哈哈哈哈哈哈哈哈哈"));
		sb.append(DrawLine());

		System.out.println(sb);
	}

	/**
	 * 划线
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
	 * 画单行
	 */

	public static String DrawSingle(String name, String value) {

		String result = "";

		result = "|" + "  " + name + ":" + value+"     易碎品";

		for (int i = 0; i < LENGTH_PAPER - result.getBytes(Charset.forName("GB2312")).length; i++) {

			result += " ";

		}

		result += "|\n";
		return result;

	}

	/**
	 * 画两行
	 */

	public static String DrawDouble(int type, String name, String tel, String address) {

		StringBuffer sb = new StringBuffer();

		if (type == 0) {

			sb.append("|  收方信息");
		} else {
			sb.append("|  寄方信息");
		}
		for (int i = 0; i < LENGTH_PAPER - "|  收方信息".getBytes(Charset.forName("GB2312")).length; i++) {
			sb.append(" ");
		}
		sb.append("|\n");

		String getname = "";
		String getTelephone = "";
		String getAddress = "";

		if (type == 0) {
			getname = "|  收方人：" + name;

		} else {
			getname = "|  寄方人：" + name;
		}
		getTelephone = "电话：" + tel;
		getAddress = "|  地址：" + address;

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
