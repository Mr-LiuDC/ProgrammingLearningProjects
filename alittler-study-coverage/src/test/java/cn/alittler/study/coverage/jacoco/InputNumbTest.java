package cn.alittler.study.coverage.jacoco;

import junit.framework.TestCase;

public class InputNumbTest extends TestCase {

	InputNumb inputNumb = new InputNumb();

	public void test() {
		System.out.println("Hello, 刘德财");
		inputNumb.input_num(-4);
		inputNumb.input_num(5);
		inputNumb.input_num(15);
		inputNumb.input_num(25);
		inputNumb.input_num(35);
	}

}
