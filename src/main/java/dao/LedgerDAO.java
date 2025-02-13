package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databse.DbConnection;
import model.Ledger;

public class LedgerDAO {
	
	public static List<Ledger> getAll() throws SQLException {
	    List<Ledger> l1 = new ArrayList<>();
//	    String query = "SELECT * from master.ledger";
	    String query = "SELECT \n" +
	               "    l.*,\n" +          
	               "    g.ledger_name AS Group_Name,\n" +
	               "    g.id AS Group_Id,\n" +
	               "    sg.ledger_name AS Sub_Group_Name,\n" +
	               "    sg.id AS Sub_Group_Id\n" +	
	               "FROM \n" +
	               "    master.ledger l\n" +
	               "LEFT JOIN \n" +
	               "    master.ledger sg ON l.parent_id = sg.id \n" +
	               "LEFT JOIN \n" +
	               "    master.ledger g ON sg.parent_id = g.id \n" +
	               "WHERE \n" +
	               "    l.is_ledger = TRUE \n" +
	               "ORDER BY \n" +
	               "    g.ledger_name ASC, \n" +
	               "    sg.ledger_name ASC, \n" +
	               "    l.ledger_name ASC;";
	    
	    try (Connection con = DbConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {
	         
	        while (rs.next()) {
	            Ledger ledger = new Ledger();
	            ledger.setId(rs.getLong("id"));
	            ledger.setLedgerName(rs.getString("ledger_name"));
	            ledger.setGroupName(rs.getString("Group_Name"));
	            ledger.setGroupId(rs.getLong("Group_Id"));
	            ledger.setSubGroupName(rs.getString("Sub_Group_Name"));
	            ledger.setSubGroupId(rs.getLong("Sub_Group_Id"));
	            ledger.setIsLedger(rs.getBoolean("is_ledger"));
	            ledger.setCreatedDate(rs.getTimestamp("created_date"));
	            ledger.setActive(rs.getBoolean("is_active"));
	            ledger.setDeleted(rs.getBoolean("is_deleted"));
	            ledger.setUpdatedDate(rs.getTimestamp("updated_date"));
	            ledger.setVersion(rs.getInt("version"));
	            ledger.setCode(rs.getString("code"));
	            ledger.setIsGroup(rs.getBoolean("is_group"));
	            ledger.setIsSubGroup(rs.getBoolean("is_sub_group"));   
	            ledger.setCreatedBy(rs.getInt("created_by"));
	            ledger.setUpdatedBy(rs.getInt("updated_by"));
	            ledger.setLedgerTypeId(rs.getShort("ledger_type_id"));
	            ledger.setParentId(rs.getInt("parent_id"));
	            ledger.setTbMenuId(rs.getInt("tb_menu_id"));
	            ledger.setSerialNumber(rs.getInt("serialnumber"));
	            ledger.setFormula(rs.getString("formula"));
	            ledger.setIsEditable(rs.getBoolean("is_editable"));
	            ledger.setDepreciationLedgerId(rs.getInt("depreciation_ledger_id"));
	            ledger.setAccumulatedDepreciationId(rs.getInt("accumulated_depreciation_id"));
	            ledger.setOptional(rs.getBoolean("is_optional"));
	            ledger.setApVersion(rs.getInt("ap_version"));
	            ledger.setFsaAreaId(rs.getShort("fsa_area_id"));
	            ledger.setLedgerHeader(rs.getString("ledger_header"));
	            l1.add(ledger);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();  
	    }

	    return l1;  
	}

	public static List<Ledger> getFilteredLedgers(String ledgerName, String groupName, String subGroupName) {
	    List<Ledger> ledgers = new ArrayList<>();
	    
	    StringBuilder query = new StringBuilder(
	        "SELECT l.*, " +
	        "g.ledger_name AS Group_Name, g.id AS Group_Id, " +
	        "sg.ledger_name AS Sub_Group_Name, sg.id AS Sub_Group_Id " +
	        "FROM master.ledger l " +
	        "LEFT JOIN master.ledger sg ON l.parent_id = sg.id " +
	        "LEFT JOIN master.ledger g ON sg.parent_id = g.id " +
	        "WHERE l.is_ledger = TRUE"
	    );

	    List<String> params = new ArrayList<>();

	    if (ledgerName != null && !ledgerName.trim().isEmpty()) {
	        query.append(" AND l.ledger_name ILIKE ?");
	        params.add("%" + ledgerName.trim() + "%");
	    }
	    if (groupName != null && !groupName.trim().isEmpty()) {
	        query.append(" AND g.ledger_name ILIKE ?");
	        params.add("%" + groupName.trim() + "%");
	    }
	    if (subGroupName != null && !subGroupName.trim().isEmpty()) {
	        query.append(" AND sg.ledger_name ILIKE ?");
	        params.add("%" + subGroupName.trim() + "%");
	    }

	    query.append(" ORDER BY g.ledger_name ASC, sg.ledger_name ASC, l.ledger_name ASC");

	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query.toString())) {

	        for (int i = 0; i < params.size(); i++) {
	            stmt.setString(i + 1, params.get(i));
	        }

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            Ledger ledger = new Ledger();
	            ledger.setId(rs.getLong("id"));
	            ledger.setLedgerName(rs.getString("ledger_name"));
	            ledger.setGroupName(rs.getString("Group_Name"));
	            ledger.setGroupId(rs.getLong("Group_Id"));
	            ledger.setSubGroupName(rs.getString("Sub_Group_Name"));
	            ledger.setSubGroupId(rs.getLong("Sub_Group_Id"));
	            ledger.setIsLedger(rs.getBoolean("is_ledger"));
	            ledger.setCreatedDate(rs.getTimestamp("created_date"));
	            ledger.setActive(rs.getBoolean("is_active"));
	            ledger.setDeleted(rs.getBoolean("is_deleted"));
	            ledger.setUpdatedDate(rs.getTimestamp("updated_date"));
	            ledger.setVersion(rs.getInt("version"));
	            ledger.setCode(rs.getString("code"));
	            ledger.setIsGroup(rs.getBoolean("is_group"));
	            ledger.setIsSubGroup(rs.getBoolean("is_sub_group"));   
	            ledger.setCreatedBy(rs.getInt("created_by"));
	            ledger.setUpdatedBy(rs.getInt("updated_by"));
	            ledger.setLedgerTypeId(rs.getShort("ledger_type_id"));
	            ledger.setParentId(rs.getInt("parent_id"));
	            ledger.setTbMenuId(rs.getInt("tb_menu_id"));
	            ledger.setSerialNumber(rs.getInt("serialnumber"));
	            ledger.setFormula(rs.getString("formula"));
	            ledger.setIsEditable(rs.getBoolean("is_editable"));
	            ledger.setDepreciationLedgerId(rs.getInt("depreciation_ledger_id"));
	            ledger.setAccumulatedDepreciationId(rs.getInt("accumulated_depreciation_id"));
	            ledger.setOptional(rs.getBoolean("is_optional"));
	            ledger.setApVersion(rs.getInt("ap_version"));
	            ledger.setFsaAreaId(rs.getShort("fsa_area_id"));
	            ledger.setLedgerHeader(rs.getString("ledger_header"));
	            
	            ledgers.add(ledger);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ledgers;
	}


}
