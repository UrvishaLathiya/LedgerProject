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
    
    public static List<Ledger> getAll(String ledgerName, String groupName, String subGroupName, Integer apVersion, int pageNumber, int pageSize) throws SQLException {
        List<Ledger> ledgers = new ArrayList<>();
        
        StringBuilder query = new StringBuilder("SELECT ");
        query.append("    l.*, ");
        query.append("    g.ledger_name AS Group_Name, g.id AS Group_Id, ");
        query.append("    sg.ledger_name AS Sub_Group_Name, sg.id AS Sub_Group_Id ");
        query.append("FROM master.ledger l ");
        query.append("LEFT JOIN master.ledger sg ON l.parent_id = sg.id ");
        query.append("LEFT JOIN master.ledger g ON sg.parent_id = g.id ");
        query.append("WHERE l.is_ledger = TRUE ");

        List<Object> parameters = new ArrayList<>();
        
        if (ledgerName != null && !ledgerName.isEmpty()) {
            query.append(" AND l.ledger_name ILIKE ?");
            parameters.add("%" + ledgerName + "%");
        }
        if (groupName != null && !groupName.isEmpty()) {
            query.append(" AND g.ledger_name ILIKE ?");
            parameters.add("%" + groupName + "%");
        }
        if (subGroupName != null && !subGroupName.isEmpty()) {
            query.append(" AND sg.ledger_name ILIKE ?");
            parameters.add("%" + subGroupName + "%");
        }
        if (apVersion != null) {
            query.append(" AND l.ap_version = ?");
            parameters.add(apVersion);
        }
        
        query.append(" ORDER BY g.ledger_name ASC LIMIT ? OFFSET ?");
        parameters.add(pageSize);
        parameters.add((pageNumber - 1) * pageSize);

        System.out.println("Final Query: " + query);
        System.out.println("Bound Parameters: " + parameters);

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query.toString())) {
             
            for (int i = 0; i < parameters.size(); i++) {
                ps.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
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
            }
        }
        return ledgers;  
    }

    public static int getTotalCount(String ledgerName, String groupName, String subGroupName, Integer apVersion) throws SQLException {
        int count = 0;
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM master.ledger l ");
        query.append("LEFT JOIN master.ledger sg ON l.parent_id = sg.id ");
        query.append("LEFT JOIN master.ledger g ON sg.parent_id = g.id ");
        query.append("WHERE l.is_ledger = TRUE ");

        List<Object> parameters = new ArrayList<>();
        
        if (ledgerName != null && !ledgerName.isEmpty()) {
            query.append(" AND l.ledger_name ILIKE ?");
            parameters.add("%" + ledgerName + "%");
        }
        if (groupName != null && !groupName.isEmpty()) {
            query.append(" AND g.ledger_name ILIKE ?");
            parameters.add("%" + groupName + "%");
        }
        if (subGroupName != null && !subGroupName.isEmpty()) {
            query.append(" AND sg.ledger_name ILIKE ?");
            parameters.add("%" + subGroupName + "%");
        }
        if (apVersion != null) {
            query.append(" AND l.ap_version = ?");
            parameters.add(apVersion);
        }

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query.toString())) {
             
            for (int i = 0; i < parameters.size(); i++) {
                ps.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        }
        return count;
    }
}
