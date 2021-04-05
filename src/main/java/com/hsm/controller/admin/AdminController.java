package com.hsm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

	// admin member list
	@RequestMapping(value = "/MemberList")
	public ModelAndView adminMemberList(ModelAndView mv) {
		mv.setViewName("admin/member/list");
		return mv;
	}

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

}
