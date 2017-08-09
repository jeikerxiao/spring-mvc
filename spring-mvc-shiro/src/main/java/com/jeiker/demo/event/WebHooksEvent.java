package com.jeiker.demo.event;
import org.springframework.context.ApplicationEvent;

/**
 * WebHooks事件
 */
public class WebHooksEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3443109525461436619L;

	public WebHooksEvent(Object source) {
		super(source);
	}

}