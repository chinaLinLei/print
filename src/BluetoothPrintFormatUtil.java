
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * ������ӡ,�Ű��ӡ��ʽ
 * 
 * @author linjinfa@126.com
 * @date 2013-6-17 ����3:37:10
 */
public class BluetoothPrintFormatUtil {

	/**
	 * ��ӡֽһ�������ֽ�
	 */
	private static final int LINE_BYTE_SIZE = 32;


	private static StringBuffer sb = new StringBuffer();

	/**
	 * �Ű���б���
	 * 
	 * @param title
	 * @return
	 */
	public static String printTitle(String title) {
		sb.delete(0, sb.length());
		for (int i = 0; i < (LINE_BYTE_SIZE - getBytesLength(title)) / 2; i++) {
			sb.append(" ");
		}
		sb.append(title);
		return sb.toString();
	}

	/**
	 * �Ű��������(��':'����)
	 * 
	 * ������������� ������5A���� סԺ�ţ�11111
	 * 
	 * @param msg
	 * @return
	 */
	public static String printMiddleMsg(LinkedHashMap<String, String> middleMsgMap) {
		sb.delete(0, sb.length());
		String separated = ":";
		int leftLength = (LINE_BYTE_SIZE - getBytesLength(separated)) / 2;
		for (Entry<String, String> middleEntry : middleMsgMap.entrySet()) {
			for (int i = 0; i < (leftLength - getBytesLength(middleEntry.getKey())); i++) {
				sb.append(" ");
			}
			sb.append(middleEntry.getKey() + "��" + middleEntry.getValue());
		}
		return sb.toString();
	}

	/**
	 * �Ű����ҶԳ�����(��':'����)
	 * 
	 * ������������� סԺ�ţ�111111 ������5A���� ���ң���ٿ� ���أ�130kg
	 * 
	 * 
	 * @param leftMsgMap
	 *            ��߲���Ҫ��ӡ���� ������ݴ�С�ɴ����ұ����ݴ�С ��֮�ұ߹���ʱ���������
	 * @param rightMsgMap
	 *            �ұ߲���Ҫ��ӡ����
	 * @return
	 */
	public static String printSymmetryMSG(LinkedHashMap<String, String> leftMsgMap,
			LinkedHashMap<String, String> rightMsgMap) {
		sb.delete(0, sb.length());
		int leftPrefixLength = getMaxLength(leftMsgMap.keySet().toArray());
		int rightValueLength = getMaxLength(rightMsgMap.values().toArray());
		Object rightMsgKeys[] = rightMsgMap.keySet().toArray();
		int position = 0;
		for (Entry<String, String> leftEntry : leftMsgMap.entrySet()) {
			String leftMsgPrefix = leftEntry.getKey();
			String leftMsgValue = leftEntry.getValue();
			for (int leftI = 0; leftI < (leftPrefixLength - getBytesLength(leftMsgPrefix)); leftI++) {
				sb.append(" ");
			}
			String leftMsg = leftMsgPrefix + "��" + leftMsgValue;
			sb.append(leftMsg);

			if (position > rightMsgKeys.length - 1)
				continue;
			int leftLength = leftPrefixLength + getBytesLength("��" + leftMsgValue);
			String rightMsgPrefix = rightMsgKeys[position] + "��";
			int rightLength = getBytesLength(rightMsgPrefix) + rightValueLength;
			String rightMsgValue = rightMsgMap.get(rightMsgKeys[position]);

			for (int middle = 0; middle < (LINE_BYTE_SIZE - leftLength - rightLength); middle++) {
				sb.append(" ");
			}
			sb.append(rightMsgPrefix + rightMsgValue);
			position++;
		}
		return sb.toString();
	}

	
	/**
	 * ��ȡ��󳤶�
	 * 
	 * @param msgs
	 * @return
	 */
	private static int getMaxLength(Object[] msgs) {
		int max = 0;
		int tmp;
		for (Object oo : msgs) {
			tmp = getBytesLength(oo.toString());
			if (tmp > max) {
				max = tmp;
			}
		}
		return max;
	}

	/**
	 * ��ȡ���ݳ���
	 * 
	 * @param msg
	 * @return
	 */
	private static int getBytesLength(String msg) {
		return msg.getBytes(Charset.forName("GB2312")).length;
	}
	/**
	 * ����
	 * 
	 * @return
	 */

	public static String DrawLine() {
		String value = "\n";

		for (int i = 0; i < LINE_BYTE_SIZE; i++) {
			value += "-";
		}
		value += "\n";
		return value;
	}

	/**
	 * ����
	 * 
	 * @return
	 */

	public static String DrawTween() {
		String value = "\n";

		for (int i = 0; i < LINE_BYTE_SIZE; i++) {
			value += "*";
		}
		value += "\n";
		return value;
	}

}
