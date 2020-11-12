package homework;
/*
 * Author: Yutong_Guo
 * Coding = UTF-8
 * Running environment: Ubuntu 20.04	Java 1.8.0		eclipse 4.16.0
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

class CalculateHash {
	public static Vector<FileInputStream> v = new Vector<FileInputStream>();	//创建一个存放输入流的vector
	
	public static byte[] SHA1Checksum(InputStream is) throws Exception{	//SHA1算法
		byte[] buffer = new byte[1024];	//缓存器
		MessageDigest complete = MessageDigest.getInstance("SHA-1");
		int numRead = 0;	//当前读到的字节数
		do {
			numRead = is.read(buffer);
			if (numRead > 0) {
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != -1);
	is.close();
	return complete.digest();
	}
	
	
	public static SequenceInputStream combineStreams(SequenceInputStream a, FileInputStream b) {
		SequenceInputStream newStream = new SequenceInputStream(a,b);
		return newStream;
	}
	
	public static void getFilesStream(String path) {
		File file = new File(path);
		if (file.isDirectory()) {	//判断输入是否是合法目录
			File[] files = file.listFiles();	//读取输入目录下的文件和子文件夹
			Arrays.sort(files);	//对文件列表进行排序
			for(int i = 0; files != null && i < files.length; i++) {
				if (files[i].isFile()) {
					try {
						FileInputStream is = new FileInputStream(files[i]);	//创建输入流
						v.add(is);	//装入vector
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (files[i].isDirectory()) {
					getFilesStream(path + File.separator + files[i].getName());	//若该项为目录，则向下递归查找
				}
			}
		}
	}
}


public class Homework_1106{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入文件夹地址: ");
		String path = input.nextLine();
		
		try {
			CalculateHash.getFilesStream(path);	//获取路径path下的文件的输入流
			Enumeration<FileInputStream> en = CalculateHash.v.elements();	//创建一个枚举对象
			SequenceInputStream full = new SequenceInputStream(en);	//将枚举对象转换为SequenceInputStream类型
			byte[] finalbytes = CalculateHash.SHA1Checksum(full);	//对SequenceInputStream进行SHA1算法
			String result = "";
			for(int j = 0; j < finalbytes.length; j++) {
				result += Integer.toString(finalbytes[j]&0xFF,16);
			}
			System.out.println("路径"+path+"的哈希值为"+result);	//输出hash值
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 测试1 路径'/home/yutong_guo/Downloads',内有两个子目录及多个文件
		// 测试结果: a4a0bf4824ebc3cf23ad8a304fd39159b11b31a3
		// 测试2 相同路径
		// 测试结果: a4a0bf4824ebc3cf23ad8a304fd39159b11b31a3
		// 测试3 删除文件夹内一个文件
		// 测试结果: ae66df7614caa4aae4a5ec368cf58ca984e9d0
		// 测试4 向文件夹内新增一个文件
		// 测试结果: 52d04a632edf364f3bf775f771c24acdbafe9a
		// 测试5 某一文件重命名
		// 测试结果: 41f85b188eb1ed843aa0155219e3029a5c01357
		// 测试6 向一个文本内增加一行
		// 测试结果: 87b77952729ba98c4d8925e4ebaa1e28397e67e
		// 初步认为，本程序实现了作业要求
	}

}
