import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFile {
	static File newFile = new File("D:\\林磊\\项目\\code" + File.separator + "nihao.txt");
	static FileOutputStream fos_receipt;
	private static FileInputStream fin_receipt = null;
	

	public static void main(String[] args) throws IOException {

		if (!newFile.exists()) {

			newFile.createNewFile();

		}

		if (fos_receipt == null) {
			fos_receipt = new FileOutputStream(newFile);
		}

		byte[] bytes = "你好的卍看见好多".getBytes();
		int len = bytes.length;

		fos_receipt.write(bytes, 0, len);
		fos_receipt.close();

		if (fin_receipt == null) {

			fin_receipt = new FileInputStream(newFile);

		}

		int length = fin_receipt.available();

		byte[] buffer = new byte[length];
		
		while ((fin_receipt.read(buffer, 0, length))!=-1) {
			
				String result=new String(buffer);
				System.out.println(result);
			
		}

	

		fin_receipt.close();
	}

}
