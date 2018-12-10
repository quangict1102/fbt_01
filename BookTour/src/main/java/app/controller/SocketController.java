package app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import app.helper.ConvertDateSql;
import app.model.Message;
import app.model.OutputMessage;

@Controller
public class SocketController {
	
	@MessageMapping("/chat/user/{id}")
	@SendTo("/topic/user/{id}")
	public OutputMessage send(Message message, @PathVariable("id") String email) {
		return new OutputMessage(message.getFrom(), message.getText(), ConvertDateSql.dateFormatHH_mm());
	
	}

	@MessageMapping("/chat/admin/{id}")
	@SendTo("/topic/admin/{id}")
	public OutputMessage sendAdmin(Message message, @PathVariable("id") String email) {
		return new OutputMessage(message.getFrom(), message.getText(), ConvertDateSql.dateFormatHH_mm());
	}

}
