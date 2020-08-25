package kr.or.ddit.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BuildedSqlMapClient {
	private static SqlMapClient smc;

	static {
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
		}
	}
	
	public static SqlMapClient getSqlMapClient(){
		return smc;
	}
}
