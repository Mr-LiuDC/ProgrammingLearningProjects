package cn.alittler.study.offer;

//题目描述
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class FindInArray {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 }, { 8, 10, 14, 17 } };
		System.out.println(Find(8, arr));// true
		System.out.println(Find(22, arr));// false

	}

	public static boolean Find(int target, int[][] array) {
		boolean flag = false; // 定义一个布尔值，默认为false，在查找过程中，如果找到了目标数，就把flag只改为true返回，找不到就返回false
		int rows = array.length;// 获取二维数组的行数
		int columns = array[0].length;// 获取二维数组的列数，这里为了简便，很无耻地任务这就是一个二维矩阵，每一行的列数相同，直接获取第一行的列数就是所有行的列数(因为博主知道了测试用例哈哈哈)
		if (array != null && rows > 0 && columns > 0) {
			// 因为每一行都从左到右递增，每一列都从上到下递增，即做上角的数最大，右下角的数最小。这里从右上角开始查找，先比较行，如果比该行该数大，则下移一行，比较列；如果该数比该行该列数小，则左移一列，继续比较，知道行超出或者列超出还没有找到的话，就返回false，这样理论上时间复杂度最小
			int row = 0;
			int column = columns - 1;
			while (row < rows && column >= 0) {
				int tempValue = array[row][column];
				if (target > tempValue) {
					++row;
				} else if (target < tempValue) {
					--column;
				} else {
					flag = true;
					break; // 如果找到了，就break掉，提高查找效率
				}
			}
		}
		return flag;
	}

}
