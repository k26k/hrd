package test8_2;

public class DaoExample {
	
	static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}

}
