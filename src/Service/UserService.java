package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.DBhelper;
import Model.Reader;

/**
* @author renqiulin
* @version ����ʱ�䣺2019��6��7�� ����9:45:00
* @ClassName ������
* @Description ������
*/
public class UserService {
	/**
	 * ��Ӷ���
	 * @param name
	 * @param age
	 * @param tel
	 * @return
	 */
	public int insertUser(String name,int age,String tel) {
		String sql=String.format("insert into reader(name,age,tel) values('%s','%s','%s')",name,age,tel);
		int res = DBhelper.executeNonQuery(sql);
		if(res>0) {
			return res;
		}
		return 0;
	}
	/**
	 * �޸Ķ���
	 * @param name
	 * @param age
	 * @param tel
	 * @return
	 */
	public int updateUser(int id,String name,int age,String tel) {
		String sql="update reader set name='"+name+"',age='"+age+"',tel='"+tel+"'where readid="+id;
		//String sql1=String.format("update reader(name,age,tel)values('%s','%s','%s') where readid='%s'", name,age,tel,id);
		//System.out.println(sql1.toString());
		System.out.println(sql);
		int res = DBhelper.executeNonQuery(sql);
		//int res = DBhelper.executeNonQuery(sql1);
		if(res>0) {
			return res;
		}
		return 0;
	}
	public ArrayList<Reader> queryUser(int id) {
		ArrayList<Reader> model=new ArrayList<>();
		String sql="select *from reader where readid="+id;
		ResultSet resultSet= DBhelper.executeQuery(sql);
		try {
			if(resultSet.next()) {
				Reader r=new Reader();
				r.setReadID(resultSet.getInt("readid"));
				r.setName(resultSet.getString("name"));
				r.setAge(resultSet.getInt("age"));
				r.setTel(resultSet.getString("tel"));
				model.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public int deleteUser(int id) {
		String sql="delete from reader where readid=" + id;
		int res = DBhelper.executeNonQuery(sql);
		if(res>0) {
			return res;
		}
		return 0;
	}
	/**
	 * �������ж���
	 * @return
	 */
	public ArrayList<Reader> queryALL() {
		ArrayList<Reader> array=new ArrayList<>();
		String sql="select * from reader";
		ResultSet resultSet = DBhelper.executeQuery(sql);
		try {
			while(resultSet.next()) {
				Reader r=new Reader();
				r.setReadID(resultSet.getInt("readid"));
				r.setName(resultSet.getString("name"));
				r.setAge(resultSet.getInt("age"));
				r.setTel(resultSet.getString("tel"));
				array.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
}
