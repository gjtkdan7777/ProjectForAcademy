package com.ncs.green;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hsm.vo.Search;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AA {

	@Autowired
	SqlSession sql;
	
	@Test
	public void test() {
		assertNotNull(sql);
//		Search search = new	Search();
//		search.setSearchType("e");
//		search.setSearchValue("01");
//		List<Search> list = sql.selectList("com.ncs.AdminMapper.userList", search);
//		System.out.println(list);
	
	}
}
