package action;

public class Action4Parameter extends Action4Service{
	//错误消息
    protected String msg;
    //分类排序方式
    protected String sort;
    //搜索关键字
    protected String keyword;
    //立即购买生成的订单项id
    protected int oiid;
    //购物数量
    protected int num;
    //通过购物车选中的多个订单项id
    protected int[] oiids;
    //结算页面显示的总金额
    protected float total;
    //是否展示其他用户评价
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
