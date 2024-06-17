package com.harshit1108.studentportal.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.harshit1108.studentportal.service.StudentAssignmentReportService;

@Component

public class ReportScheduler {

	@Autowired
	private StudentAssignmentReportService studentAssignmentReportService;

	@Scheduled(cron = "0 0/5 * * * ?") // Run every 5 minutes
	public void generateReports() {

		System.out.println("Schedular is Running");
		this.studentAssignmentReportService.processAssignmentSubmission();
	}
}
