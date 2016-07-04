package gao.ssm.po;

public class Orderdetail {
    private Integer id;

    private Integer ordersid;

    private Integer itemsid;

    private Integer itemsnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public Integer getItemsid() {
        return itemsid;
    }

    public void setItemsid(Integer itemsid) {
        this.itemsid = itemsid;
    }

    public Integer getItemsnum() {
        return itemsnum;
    }

    public void setItemsnum(Integer itemsnum) {
        this.itemsnum = itemsnum;
    }
}