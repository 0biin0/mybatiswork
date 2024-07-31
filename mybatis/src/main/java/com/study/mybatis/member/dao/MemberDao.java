package com.study.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {
	public int CheckId(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("", userId);
	}
}
