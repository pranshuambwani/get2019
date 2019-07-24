package assignment7;
import org.junit.Assert;
import org.junit.Test;

public class SparseMatrixTest {
	
	@Test
	public void TransposeTest(){
		SparseMatrix matrix=new SparseMatrix(new Integer[][]{{1,2,0},{0,0,3}});
		Integer transpose[][]=matrix.TransposeMatrix();
		SparseMatrix transposeMat=new SparseMatrix(new Integer[][]{{1,0},{2,0},{0,3}});
		Assert.assertArrayEquals(transposeMat.sparseMatrix,transpose);
	}
	
	@Test
	public void SymmetricTest(){
		SparseMatrix matrix=new SparseMatrix(new Integer[][]{{1,2,3},{2,0,0},{3,0,0}});
		Assert.assertEquals(true, matrix.SymmetricalMatrix());
	}

	@Test
	public void additionTest(){
		SparseMatrix matrix1=new SparseMatrix(new Integer[][]{{1,2,3},{2,0,0},{3,0,0}});
		SparseMatrix matrix2=new SparseMatrix(new Integer[][]{{1,2,3},{2,0,0},{3,0,0}});
		SparseMatrix additionResult=new SparseMatrix(new Integer[][]{{2,4,6},{4,0,0},{6,0,0}});
		Assert.assertArrayEquals(additionResult.sparseMatrix, matrix1.AddMatrix(matrix1.sparseMatrix, matrix2.sparseMatrix));
	}
	
	@Test
	public void multiplyTest(){
		SparseMatrix mat1=new SparseMatrix(new Integer[][]{{0,1},{2,0}});
		SparseMatrix mat2=new SparseMatrix(new Integer[][]{{3,4},{0,0}});
		SparseMatrix multiplication=new SparseMatrix(new Integer[][]{{0,0},{6,8}});
		Assert.assertArrayEquals(multiplication.sparseMatrix,mat1.MultiplyTwoMatrix(mat1.sparseMatrix, mat2.sparseMatrix));
		
	}
}