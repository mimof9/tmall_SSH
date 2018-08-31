package util;

/*
 * Page�Ǻ�̨��ҳ�Ĺ�����
 */
public class Page {
	int start;
	int count;
	int total;
	String param;

	public Page(){		//struts���� set get������ һ��Ҫ�޲ι��캯��
		start = 0;
		count = 5;
	}
	public Page(int start, int count) {
		super();
		this.start = start;
		this.count = count;
	}

	// ��ҳ��
	public int getTotalPage(){
//		if(total % count == 0)
//			return total / count;
//		else
//			return total / count + 1;
		
		int totalPage;
        // ����������50�����ܹ���5�����ģ���ô����10ҳ
        if (0 == total % count)
            totalPage = total /count;
        // ����������51�����ܹ���5�����ģ���ô����11ҳ
        else
            totalPage = total / count + 1;
        
        if(0==totalPage)		//��total = 0ʱ ��1 ֮ǰд��û�п��ǵ�0�����
            totalPage = 1;
        return totalPage;
	}
	
	// ���һҳ��start
	public int getLast(){
//		if(total % count == 0)
//			return total - count;
//		else
//			return total - (total%count);
		
		int last;
        // ����������50�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����45
        if (0 == total % count)
            last = total - count;
        // ����������51�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����50
        else
            last = total - total % count;
        
        last = last<0?0:last;
        return last;
	}
	
	// �Ƿ���ǰһҳ
	public boolean isHasPrevious(){
		return start!=0;
	}
	
	// �Ƿ��к�һҳ
	public boolean isHasNext(){
		return start!=getLast();
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}
