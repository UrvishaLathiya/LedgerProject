import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import dao.LedgerDAO;
import databse.DbConnection;
import model.Ledger;

public class test {

	public static void main(String[] args) throws SQLException {
		Ledger l1 = new Ledger();
		System.out.println(l1);
		
		Connection con = DbConnection.getConnection();
		if(con != null) {
			System.out.println("done");
		}
		else {
			System.out.println("not");
		}
		
		
		LedgerDAO dao = new LedgerDAO();
		List<Ledger> l2 = dao.getAll();
		for (Ledger ledger : l2) {
		    System.out.println("ID: " + ledger.getId());
		    System.out.println("Created Date: " + ledger.getCreatedDate());
		    System.out.println("Is Active: " + ledger.isActive());
		    System.out.println("Is Deleted: " + ledger.isDeleted());
		    System.out.println("Updated Date: " + ledger.getUpdatedDate());
		    System.out.println("Version: " + ledger.getVersion());
		    System.out.println("Code: " + ledger.getCode());
		    System.out.println("Is Group: " + ledger.getIsGroup());
		    System.out.println("Is Ledger: " + ledger.getIsLedger());
		    System.out.println("Is Sub Group: " + ledger.getIsSubGroup());
		    System.out.println("Ledger Name: " + ledger.getLedgerName());
		    System.out.println("Created By: " + ledger.getCreatedBy());
		    System.out.println("Updated By: " + ledger.getUpdatedBy());
		    System.out.println("Ledger Type ID: " + ledger.getLedgerTypeId());
		    System.out.println("Parent ID: " + ledger.getParentId());
		    System.out.println("Menu ID: " + ledger.getTbMenuId());
		    System.out.println("Serial Number: " + ledger.getSerialNumber());
		    System.out.println("Formula: " + ledger.getFormula());
		    System.out.println("Is Editable: " + ledger.getIsEditable());
		    System.out.println("Depreciation Ledger ID: " + ledger.getDepreciationLedgerId());
		    System.out.println("Accumulated Depreciation ID: " + ledger.getAccumulatedDepreciationId());
		    System.out.println("Is Optional: " + ledger.isOptional());
		    System.out.println("AP Version: " + ledger.getApVersion());
		    System.out.println("FSA Area ID: " + ledger.getFsaAreaId());
		    System.out.println("Ledger Header: " + ledger.getLedgerHeader());
		    System.out.println("-----------------------------------------");
		}
		

	}

}
