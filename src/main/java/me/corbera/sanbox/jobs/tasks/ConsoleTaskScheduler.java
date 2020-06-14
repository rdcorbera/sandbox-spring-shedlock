package me.corbera.sanbox.jobs.tasks;

import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsoleTaskScheduler {

  @Scheduled(cron = "0/15 * * * * ?")
  @SchedulerLock(name = "ConsoleTaskScheduler_execute", lockAtLeastFor= "PT3S", lockAtMostFor = "PT6S")
  public void execute() {

    LockAssert.assertLocked();

    System.out.println("Send notification " + new Date().toString());

  }
}
