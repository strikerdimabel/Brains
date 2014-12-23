package dao;

import model.teaser.TeaserSolvingInfo;
import model.user.Role;
import model.user.User;

import org.junit.Assert;
import org.junit.Test;

public class DaoImplTest extends Assert {
	
	private static final DaoImpl dao = new DaoImpl();

	@Test
	public void testSaveEntity() {
		 User user = new User();
		 user.setLogin("admin");
		 user.setPassword("admin");
		 user.setRole(Role.ADMIN);
		 dao.saveEntity(user);
//		int[][] matrix = new int[][] { { 8, 0, 0, 4, 0, 6, 0, 0, 7 },
//				{ 0, 0, 0, 0, 0, 0, 4, 0, 0 }, { 0, 1, 0, 0, 0, 0, 6, 5, 0 },
//				{ 5, 0, 9, 0, 3, 0, 7, 8, 0 }, { 0, 0, 0, 0, 7, 0, 0, 0, 0 },
//				{ 0, 4, 8, 0, 2, 0, 1, 0, 3 }, { 0, 5, 2, 0, 0, 0, 0, 9, 0 },
//				{ 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 3, 0, 0, 9, 0, 2, 0, 0, 5 } };
//		TeaserCondition cnd = new SudokuTeaserCondition(matrix);
//		DaoImpl dao = new DaoImpl();
//		TeaserInfo info = new TeaserInfo();
//		info.setName("Sud1");
//		info.setType(TeaserType.SUDOKU);
//		Solver solver = SolverFactory.newSolver(cnd, TeaserType.SUDOKU);
//		Teaser solution = solver.solve();
//		if (solution == null) {
//			return;
//		}
//		dao.saveEntity(info);
//		solution.setTeaserId(1);
//		dao.saveEntity(solution);
//		cnd.setTeaserId(1);
//		dao.saveEntity(cnd);
	}
	
	@Test
	public void testSaveEntity2()
	{
		TeaserSolvingInfo solvingInfo = new TeaserSolvingInfo(1, 7);
		dao.saveEntity(solvingInfo);
	}

}
