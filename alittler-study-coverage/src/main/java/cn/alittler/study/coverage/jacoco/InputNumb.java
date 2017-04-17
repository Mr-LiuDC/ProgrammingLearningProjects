package cn.alittler.study.coverage.jacoco;

public class InputNumb {

	public void input_num(int num) {
		if (num < 0) {
			for (int i = 0; i < num; i++) {
				System.out.println(num);
			}
			System.out.println("你输入的是负数！" + num);
		} else if (num > 0 && num < 10) {
			for (int i = 0; i < num; i++) {
				System.out.print(num);
			}
			System.out.println("你输入的数在0到10之间！" + num);
		} else if (num > 10 && num < 20) {
			for (int i = 0; i < num; i++) {
				System.out.print(num);
			}
			System.out.println("你输入的数在10到20之间！" + num);
		} else if (num > 20) {
			for (int i = 0; i < num; i++) {
				System.out.print(num);
			}
			System.out.println("你输入的数大于20" + num);
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(num);
			}
			System.out.println("输入的数在边界。");
		}
	}

}
