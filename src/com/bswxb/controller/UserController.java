package com.bswxb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bswxb.dao.UserDao;
import com.bswxb.po.User;
import com.bswxb.service.UserService;
import com.bswxb.util.getIp;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/check.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findBookByHql(String uname, HttpServletRequest request) {

		getIp getip = new getIp();
		String ip = getip.getRemoteHost(request);

		if (userService.check(uname)) {

			return "用户名已存在";

		}

		if (userService.checkIp(ip)) {

			return "每位用户只能注册三个账号";
		}

		return null;
	}

	@RequestMapping(value = "/checkname.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkUsername(String yourName) {
		if (this.userService.check(yourName)) {
			return "用户名存在";
		} else {
			return "用户名不存在";
		}

	}

	@RequestMapping(value = "/getpassword.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public User getPassword(String yourName, String yourQuestion,
			String yourAnswer) {

		User user = new User();
		if (this.userService.check(yourName)) {

			user = this.userService.GetUserByName(yourName);

			// 如果问题通过则。
			if (user.getUquestion().equals(yourQuestion)
					&& user.getUanswer().equals(yourAnswer)) {
				return user;

			}

			user.setUanswer("答案与问题不匹配。");

			return user;

		} else {

			user.setUanswer("用户名不存在，请检查。");
			return user;
		}

	}

	@RequestMapping(value = "/login.do")
	public String login(HttpSession session, String username,
			String userpassword, HttpServletRequest request) {

		User user = new User();

		if (this.userService.check(username)) {

			user = this.userService.GetUserByName(username);

			// 检查密码。
			if (user.getUpwd().equals(userpassword)) {

				session.setAttribute("user", user);

				if (username.equals("fg885436fg")) {

					return "/views/feedback.jsp";

				}

				return "/views/table.jsp";

			}
		}

		request.setAttribute("msg", "用户或密码错误");
		return "/views/login.jsp";

	}

	@RequestMapping(value = "/regis.do")
	public String regis(String uname, String upwd, String uquestion,
			String uanswer, String party, HttpServletRequest request) {

		getIp getip = new getIp();
		String ip = getip.getRemoteHost(request);

		if (userService.check(uname)) {

			request.setAttribute("msg", "用户名已存在");
			return "/views/login.jsp";
		}

		if (userService.checkIp(ip)) {

			request.setAttribute("msg", "每位用户只能注册三个账号");
			return "/views/login.jsp";
		}

		// 注册

		User user = new User();
		user.setParty(party);
		user.setUanswer(uanswer);
		user.setUip(ip);
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setUquestion(uquestion);

		this.userDao.save(user);

		request.setAttribute("msg", "注册成功");
		return "/views/login.jsp";

	}

}
