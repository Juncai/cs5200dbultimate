package bibliophiles.utils.test;

import java.util.Date;

import org.junit.Test;

import bibliophiles.utils.DateConverter;
/**
 * 
 * @author tanchengzhuang
 *
 */
public class DateConverterTest {
	@Test
	public void DateConverterTest1(){
		DateConverter dateConverter = new DateConverter();
//		Date date = new java.util.Date();
		String value = "2012-03-12";
		Object convert = dateConverter.convert(java.util.Date.class, value);
		System.out.println(convert.getClass());
		
	}
}
