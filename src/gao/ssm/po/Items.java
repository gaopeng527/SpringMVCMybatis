package gao.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import gao.ssm.controller.validation.ValidateGroup1;
import gao.ssm.controller.validation.ValidateGroup2;

public class Items {
    private Integer id;

    // У��������1-30���ַ�֮��
    // messageΪ��ʾУ���������ʾ����Ϣ
    // groups������У�������ĸ����飬groups�ɶ���������
    @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidateGroup1.class})
    private String name;

    private Float price;

    private String pic;

    // �ǿ�У��
    @NotNull(message="{items.createtime.isNull}",groups={ValidateGroup2.class})
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}