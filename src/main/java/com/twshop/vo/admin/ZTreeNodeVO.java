package com.twshop.vo.admin;

/**
 * 
 * jquery ztree 插件的节点
 * 
 * @author fengshuonan
 * @date 2017年2月17日 下午8:25:14
 */
public class ZTreeNodeVO {

	private Long id; // 节点id

	private Long pId;// 父节点id

	private String name;// 节点名称

	private Boolean open;// 是否打开节点

	private Boolean checked;// 是否被选中

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getIsOpen() {
		return open;
	}

	public void setIsOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
