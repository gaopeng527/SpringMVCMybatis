package gao.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * ��������ת����
 * @author DELL
 *
 */
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		// ʵ�ֽ����ڴ�ת��Ϊ�������͸�ʽΪyyyy-MM-dd HH:mm:ss
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// ת���ɹ�ֱ�ӷ���
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���������ʧ�ܷ���null
		return null;
	}

}
