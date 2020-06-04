package dxc.com.jira.soft.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dxc.com.jira.soft.dashboard.service.IssueService;

@Controller
public class APIController {
	@Autowired
	private IssueService iisueService;
	
	
	@GetMapping("/getvalue")
	@ResponseBody
	public String GetIssue(@RequestParam String priority , @RequestParam String issueName) {
		
		int  i = iisueService.getValueIssueComplete(priority, issueName);
		System.out.println("length "+ i);
		return ""+i;
	}
	@GetMapping("/getvalue-in")
	@ResponseBody
	public String GetIssueIn(@RequestParam String priority , @RequestParam String issueName) {
		
		int  i = iisueService.getValueIssueInComplete(priority, issueName);
		System.out.println("length "+ i);
		return ""+i;
	}

}
