package www.bank.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.domains.MemberBean;
import com.bank.services.MemberService;
import com.bank.web.daos.MemberDAO;
import com.bank.web.pool.Constants;



@SuppressWarnings("unused")
public class MemberDAOImpl implements MemberDAO {
	File file = new File(Constants.FILE_PATH+"customers0905.txt");
	public static final String FILE_PATH= String.format("C:%sUsers%suser%seclipse-jee%sjee.bank%sWebContent%sresources%stxt%s",
			//C:%sUsers%suser%seclipse-jee%sjee-grade%sWebContent%sresources%stxt
File.separator,
File.separator,
File.separator,
File.separator,
File.separator,
File.separator,
File.separator,
File.separator); 
	@Override
	public void insertCustomer(CustomerBean param) {
		System.out.println("insertCustomer");
	

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s,%s,%s,%s,%s",param.getId(),param.getPw(),param.getSsn(),param.getName(),param.getCredit()
			));
			writer.newLine();
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmplotee(EmployeeBean param) {
		try {
			
		}catch(Exception e){
			
		}		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean paramBean =new CustomerBean();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String list = br.readLine();
			br.close();
			String[] arr = list.split(",");
			param.setId(arr[0]);
			param.setPw(arr[1]);
			param.setSsn(arr[2]);
			param.setName(arr[3]);
			param.setCredit(arr[4]);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("디에이오"+param.toString());
		return param;
	}

}
