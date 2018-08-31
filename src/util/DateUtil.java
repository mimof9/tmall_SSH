package util;

/*
 * ��������ת��������
 * 
 * ��Ϊ��ʵ�������������͵����ԣ�ʹ�õĶ���java.util.Date�ࡣ
 * ��Ϊ����MySQL�е����ڸ�ʽ�ﱣ��ʱ����Ϣ������ʹ��datetime���͵��ֶΡ�
 * ��jdbcҪ��ȡdatetime�����ֶε���Ϣ����Ҫ����java.sql.Timestamp����ȡ������ֻ�ᱣ��������Ϣ������ʧʱ����Ϣ��
 */
public class DateUtil {
	
	public static java.sql.Timestamp d2t(java.util.Date d){
		if(d == null)
			return null;
		return new java.sql.Timestamp(d.getTime());
	}
	
	public static java.util.Date t2d(java.sql.Timestamp t){
		if(t == null)
			return null;
		return new java.util.Date(t.getTime());
	}
}
