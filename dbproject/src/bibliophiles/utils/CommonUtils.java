package bibliophiles.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

public class CommonUtils {
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String date2String(Date date) {
		return String.format("%tF %<tR", date);
	}
	
	public static Date string2Date(String str) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return sdf.parse(str);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String filter(String message) {
        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '&':
                result.append("&amp;");
                break;
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
	}
	

	public static String toBr(String s) {
		return s.replace("\r\n", "<br/>");
	}

}