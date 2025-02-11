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
	
	public List<Ledger> getAll() throws SQLException {
	    List<Ledger> l1 = new ArrayList<>();
//	    String query = "SELECT * from master.ledger";
	    String query = "SELECT \n" +
	               "    l.id,\n" +
	               "    l.ledger_name AS Ledger_Name,\n" +
	               "    g.ledger_name AS Group_Name,\n" +
	               "    sg.ledger_name AS Sub_Group_Name,\n" +
	               "    l.* \n" + 
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
	            ledger.setGroupName(rs.getString("Group_Name"));
	            ledger.setSubGroupName(rs.getString("Sub_Group_Name"));
	            ledger.setCreatedDate(rs.getTimestamp("created_date"));
	            ledger.setActive(rs.getBoolean("is_active"));
	            ledger.setDeleted(rs.getBoolean("is_deleted"));
	            ledger.setUpdatedDate(rs.getTimestamp("updated_date"));
	            ledger.setVersion(rs.getInt("version"));
	            ledger.setCode(rs.getString("code"));
	            ledger.setIsGroup(rs.getBoolean("is_group"));
	            ledger.setIsLedger(rs.getBoolean("is_ledger"));
	            ledger.setIsSubGroup(rs.getBoolean("is_sub_group"));
	            ledger.setLedgerName(rs.getString("ledger_name"));
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

}
