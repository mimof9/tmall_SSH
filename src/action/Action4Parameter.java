package action;

public class Action4Parameter extends Action4Service{
	//������Ϣ
    protected String msg;
    //��������ʽ
    protected String sort;
    //�����ؼ���
    protected String keyword;
    //�����������ɵĶ�����id
    protected int oiid;
    //��������
    protected int num;
    //ͨ�����ﳵѡ�еĶ��������id
    protected int[] oiids;
    //����ҳ����ʾ���ܽ��
    protected float total;
    //�Ƿ�չʾ�����û�����
    protected boolean showonly;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getOiid() {
		return oiid;
	}

	public int getNum() {
		return num;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int[] getOiids() {
		return oiids;
	}

	public float getTotal() {
		return total;
	}

	public void setOiids(int[] oiids) {
		this.oiids = oiids;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public boolean isShowonly() {
		return showonly;
	}

	public void setShowonly(boolean showonly) {
		this.showonly = showonly;
	}
	
}
