package com.hsm.controller.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsm.service.AdminService;
import com.hsm.vo.QnAVO;
import com.hsm.vo.Search;
import com.hsm.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "admin")
@Slf4j
public class AdminController {
	
	@Autowired
	AdminService service;

	// admin member modify
	@RequestMapping(value = "/MemberModify")
	public ModelAndView adminMemberModify(ModelAndView mv) {
		mv.setViewName("admin/member/modify");
		return mv;
	}

	// admin ticketing list
	@RequestMapping(value = "/TicketingList")
	public ModelAndView adminTicketingList(ModelAndView mv) {
		mv.setViewName("admin/ticketing/list");
		return mv;
	}

	// admin member detail
	@RequestMapping(value = "/QuestionsList")
	public ModelAndView adminQuestionsList(ModelAndView mv) {
		mv.setViewName("admin/questions/list");
		return mv;
	}

	// admin member detail
	@RequestMapping(value = "/QuestionsDetail")
	public ModelAndView adminQuestionsDetail(ModelAndView mv) {
		mv.setViewName("admin/questions/detail");
		return mv;
	}
	
	
	@RequestMapping(value = "/contentAns")
	public String contentSub(UserVO uvo, QnAVO qvo, HttpSession session) {
		qvo.setEmail((String)session.getAttribute("loginID"));
		String url = "redirect:qnaList";
		String msg = null;
		if(qvo.getEmail().equals(null)) {
			msg = "로그인 후 이용하실 수 있습니다";
			url = "redirect:loginf";
		}else {
//			service.adminContentInsert(qvo);
		}
		return url;
	}
	
	// admin member list
		@RequestMapping(value = "/MemberList")
		public String adminMemberList(Model model, Search vo) {
			List<Search> list = service.userList(vo);
			
			if(list!=null) {
				model.addAttribute("li", list);
			}
			return "admin/member/list";
		}
		
		@RequestMapping(value = "/Delete")
		public String Delete(Model model, HttpServletRequest request, UserVO vo) {
			String[] check = request.getParameterValues("chk");
			List<UserVO> list = new ArrayList<UserVO>();
			for (int i = 0; i < check.length; i++) {
				vo.setEmail(check[i]);
				service.deleteUser(vo);
			}
			return "redirect:MemberList";
		}
		
}
