package com.dev.dao.service;

import java.util.List;

import com.dev.dao.MemberDAO;
import com.dev.dao.vo.MemberVO;

public class MemberService {

	// CRUD
	
	private static MemberService service = new MemberService();
	private MemberService() {};	// 외부에서 땡기지 못하게 여기서 미리 선언.
	MemberDAO dao = MemberDAO.getInstance();
	
	public static MemberService getInstance() {

		return service; 
	}
	
	public void memberInsert(MemberVO member) {
		
		dao.insertMember(member);
	}
	
	public MemberVO memberSearch(String id) {
		
		return dao.searchMember(id);
	}
	
	public void memberUpdate(MemberVO member) {
		
		dao.updateMember(member);
	}
	
	public void memberDelete(String id) {
		
		dao.deleteMember(id);
		
	}
	
	public List<MemberVO> memberList(){
		
		return dao.allMember();
	}
}
