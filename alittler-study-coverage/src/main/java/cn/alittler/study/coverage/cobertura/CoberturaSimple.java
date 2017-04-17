package cn.alittler.study.coverage.cobertura;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoberturaSimple {

	private static final Logger logger = LoggerFactory.getLogger(CoberturaSimple.class);

	public int square(int x) {
		if (logger.isDebugEnabled()) {
			logger.debug("x: " + x);
		}

		int result = x * x;

		if (logger.isDebugEnabled()) {
			logger.debug("result: " + result);
		}

		return result;
	}

	public int f(int x) {
		if (logger.isDebugEnabled()) {
			logger.debug("x: " + x);
		}

		if (x < 0) {
			if (logger.isDebugEnabled()) {
				logger.debug("negative x");
			}

			return square(x);
		} else if ((x >= 0) && (x <= 5)) {
			if (logger.isDebugEnabled()) {
				logger.debug("0<=x<=5");
			}

			return x + 3;
		} else {
			return 2 * x;
		}
	}

	public int sum(Collection<?> c) {
		int result = 0;

		for (Iterator<?> i = c.iterator(); i.hasNext();) {
			int value = ((Number) i.next()).intValue();

			if (logger.isDebugEnabled()) {
				logger.debug("value: " + value);
			}

			result += value;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: " + result);
		}

		return result;
	}

}
