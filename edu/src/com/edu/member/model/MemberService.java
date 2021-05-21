package com.edu.member.model;

public class MemberService {

	// 처리를 위한 로직
	// 입력, 조회, 수정, 삭제 기능 구현 (실제 파일이나 디비는 X)
	
	MemberDAO dao = new MemberDAO();
	
	public void memberInsert(MemberVO member) {
		
		dao.insertMember(member);
		
	}
}
