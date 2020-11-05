package homework;
import java.util.ArrayList;
public class TestSort {
	private TestSort() {}
	public static void sort(ArrayList<Number> list) {
		int len = list.size();
		if (len == 0) {	//如果ArrayList为空则直接退出
			return;
		}else {	//冒泡排序
			for(int i = 1; i < len; i++) {
				for(int j = 0; j < len-i; j++) {
					if (list.get(j).doubleValue() > list.get(j+1).doubleValue()) {
						Number mid;
						mid = list.get(j);
						list.set(j,list.get(j+1));
						list.set(j+1,mid);
					}
				}
			}
		}
		
	}
	
	// 测试用例，创建一个ArrayList，填入不同类型数据，使用sort()方法排序
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(8);
		list.add(1.1);
		list.add(2.2);
		list.add(-5);
		System.out.print("排序前的列表: ");
		for (int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		TestSort.sort(list);
		System.out.println();
		System.out.print("排序后的列表: " );
		for (int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
	}
}
