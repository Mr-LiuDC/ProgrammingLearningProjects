package cn.alittler.study.coverage.cobertura;

import java.util.Collection;
import java.util.LinkedList;

import junit.framework.TestCase;

public class CoberturaSimpleTest extends TestCase {

	final CoberturaSimple simple = new CoberturaSimple();

	public CoberturaSimpleTest(String nm) {
		super(nm);
	}

	public void testSquare() {
		assertEquals(1, simple.square(1));
		assertEquals(1, simple.square(-1));
	}

	public void testF() {
		assertEquals(1, simple.f(-1));
		assertEquals(12, simple.f(6));
	}

	public void testSum() {
		Collection<Integer> c = new LinkedList<Integer>();
		c.add(new Integer(3));
		c.add(new Integer(5));
		c.add(new Integer(8));
		assertEquals(16, simple.sum(c));
	}

}
