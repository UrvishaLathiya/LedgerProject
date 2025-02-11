package model;

import java.sql.Timestamp;

public class Ledger {

    private Long id;
    private String groupName;
    private String subGroupName;
    private Timestamp createdDate;
    private boolean isActive;
    private boolean isDeleted;
    private Timestamp updatedDate;
    private Integer version;
    private String code;
    private Boolean isGroup;
    private Boolean isLedger;
    private Boolean isSubGroup;
    private String ledgerName;
    private Integer createdBy;
    private Integer updatedBy;
    private Short ledgerTypeId;
    private Integer parentId;
    private Integer tbMenuId;
    private Integer serialNumber;
    private String formula;
    private Boolean isEditable;
    private Integer depreciationLedgerId;
    private Integer accumulatedDepreciationId;
    private boolean isOptional;
    private Integer apVersion;
    private Short fsaAreaId;
    private String ledgerHeader;
    
	public Ledger() {
		
	}

	public Ledger(Long id, String groupName, String subGroupName, Timestamp createdDate, boolean isActive,
			boolean isDeleted, Timestamp updatedDate, Integer version, String code, Boolean isGroup, Boolean isLedger,
			Boolean isSubGroup, String ledgerName, Integer createdBy, Integer updatedBy, Short ledgerTypeId,
			Integer parentId, Integer tbMenuId, Integer serialNumber, String formula, Boolean isEditable,
			Integer depreciationLedgerId, Integer accumulatedDepreciationId, boolean isOptional, Integer apVersion,
			Short fsaAreaId, String ledgerHeader) {
		this.id = id;
		this.groupName = groupName;
		this.subGroupName = subGroupName;
		this.createdDate = createdDate;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.updatedDate = updatedDate;
		this.version = version;
		this.code = code;
		this.isGroup = isGroup;
		this.isLedger = isLedger;
		this.isSubGroup = isSubGroup;
		this.ledgerName = ledgerName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.ledgerTypeId = ledgerTypeId;
		this.parentId = parentId;
		this.tbMenuId = tbMenuId;
		this.serialNumber = serialNumber;
		this.formula = formula;
		this.isEditable = isEditable;
		this.depreciationLedgerId = depreciationLedgerId;
		this.accumulatedDepreciationId = accumulatedDepreciationId;
		this.isOptional = isOptional;
		this.apVersion = apVersion;
		this.fsaAreaId = fsaAreaId;
		this.ledgerHeader = ledgerHeader;
	}
	

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getSubGroupName() {
        return subGroupName;
    }
    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getIsGroup() {
		return isGroup;
	}
	public void setIsGroup(Boolean isGroup) {
		this.isGroup = isGroup;
	}
	public Boolean getIsLedger() {
		return isLedger;
	}
	public void setIsLedger(Boolean isLedger) {
		this.isLedger = isLedger;
	}
	public Boolean getIsSubGroup() {
		return isSubGroup;
	}
	public void setIsSubGroup(Boolean isSubGroup) {
		this.isSubGroup = isSubGroup;
	}
	public String getLedgerName() {
		return ledgerName;
	}
	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Short getLedgerTypeId() {
		return ledgerTypeId;
	}
	public void setLedgerTypeId(Short ledgerTypeId) {
		this.ledgerTypeId = ledgerTypeId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getTbMenuId() {
		return tbMenuId;
	}
	public void setTbMenuId(Integer tbMenuId) {
		this.tbMenuId = tbMenuId;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public Boolean getIsEditable() {
		return isEditable;
	}
	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}
	public Integer getDepreciationLedgerId() {
		return depreciationLedgerId;
	}
	public void setDepreciationLedgerId(Integer depreciationLedgerId) {
		this.depreciationLedgerId = depreciationLedgerId;
	}
	public Integer getAccumulatedDepreciationId() {
		return accumulatedDepreciationId;
	}
	public void setAccumulatedDepreciationId(Integer accumulatedDepreciationId) {
		this.accumulatedDepreciationId = accumulatedDepreciationId;
	}
	public boolean isOptional() {
		return isOptional;
	}
	public void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}
	public Integer getApVersion() {
		return apVersion;
	}
	public void setApVersion(Integer apVersion) {
		this.apVersion = apVersion;
	}
	public Short getFsaAreaId() {
		return fsaAreaId;
	}
	public void setFsaAreaId(Short fsaAreaId) {
		this.fsaAreaId = fsaAreaId;
	}
	public String getLedgerHeader() {
		return ledgerHeader;
	}
	public void setLedgerHeader(String ledgerHeader) {
		this.ledgerHeader = ledgerHeader;
	}
    
    
}
